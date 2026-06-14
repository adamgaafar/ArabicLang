import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class Interpreter extends ArabicLangBaseVisitor<Object> {

    private final Map<String, Object> globals = new HashMap<>();
    private final Deque<Map<String, Object>> scopes = new ArrayDeque<>();
    private final Map<String, ArabicLangParser.FunctionDeclarationContext> functions = new HashMap<>();

    public Interpreter() {
        scopes.push(globals);
    }

    // =========================
    // Helpers
    // =========================

    private Map<String, Object> currentScope() {
        return scopes.peek();
    }

    @Override
    public Object visitArrayLiteral(ArabicLangParser.ArrayLiteralContext ctx) {
        List<Object> list = new ArrayList<>();

        if (ctx.expression() != null) {
            for (ArabicLangParser.ExpressionContext expr : ctx.expression()) {
                list.add(visit(expr));
            }
        }

        return list;
    }

    @Override
    public Object visitForStatement(ArabicLangParser.ForStatementContext ctx) {
        if (ctx.forInitializer() != null) {
            visit(ctx.forInitializer());
        }

        while (true) {
            if (ctx.expression() != null) {
                Object condition = visit(ctx.expression());
                if (!isTruthy(condition)) {
                    break;
                }
            }

            for (ArabicLangParser.StatementContext stmt : ctx.statement()) {
                visit(stmt);
            }

            if (ctx.forUpdate() != null) {
                visit(ctx.forUpdate());
            }
        }

        return null;
    }

    @Override
    public Object visitForInitializer(ArabicLangParser.ForInitializerContext ctx) {
        if (ctx.variableDeclaration() != null) {
            return visit(ctx.variableDeclaration());
        }
        if (ctx.assignStatement() != null) {
            return visit(ctx.assignStatement());
        }
        if (ctx.expression() != null) {
            return visit(ctx.expression());
        }
        return null;
    }

    @Override
    public Object visitForUpdate(ArabicLangParser.ForUpdateContext ctx) {
        if (ctx.assignStatement() != null) {
            return visit(ctx.assignStatement());
        }
        if (ctx.expression() != null) {
            return visit(ctx.expression());
        }
        return null;
    }

    private void defineVariable(String name, Object value) {
        currentScope().put(name, value);
    }

    private void assignVariable(String name, Object value) {
        for (Map<String, Object> scope : scopes) {
            if (scope.containsKey(name)) {
                scope.put(name, value);
                return;
            }
        }
        throw new RuntimeException("Undefined variable: " + name);
    }

    private Object getVariable(String name) {
        for (Map<String, Object> scope : scopes) {
            if (scope.containsKey(name)) {
                return scope.get(name);
            }
        }
        throw new RuntimeException("Undefined variable: " + name);
    }

    private boolean isTruthy(Object value) {
        if (value == null) return false;
        if (value instanceof Boolean b) return b;
        if (value instanceof Number n) return n.doubleValue() != 0;
        if (value instanceof String s) return !s.isEmpty();
        return true;
    }

    private double toNumber(Object value) {
        if (value instanceof Number n) {
            return n.doubleValue();
        }
        throw new RuntimeException("Expected number but got: " + value);
    }

    private Object normalizeNumber(double value) {
        if (value == (int) value) {
            return (int) value;
        }
        return value;
    }

    private List<ArabicLangParser.StatementContext> getIfStatementsBeforeElse(ArabicLangParser.IfStatementContext ctx) {
        List<ArabicLangParser.StatementContext> result = new ArrayList<>();
        boolean elseReached = false;

        for (ParseTree child : ctx.children) {
            if (child instanceof TerminalNode terminal) {
                if (terminal.getSymbol().getType() == ArabicLangParser.ELSE) {
                    elseReached = true;
                }
            } else if (child instanceof ArabicLangParser.StatementContext stmt && !elseReached) {
                result.add(stmt);
            }
        }

        return result;
    }

    private List<ArabicLangParser.StatementContext> getIfStatementsAfterElse(ArabicLangParser.IfStatementContext ctx) {
        List<ArabicLangParser.StatementContext> result = new ArrayList<>();
        boolean elseReached = false;

        for (ParseTree child : ctx.children) {
            if (child instanceof TerminalNode terminal) {
                if (terminal.getSymbol().getType() == ArabicLangParser.ELSE) {
                    elseReached = true;
                }
            } else if (child instanceof ArabicLangParser.StatementContext stmt && elseReached) {
                result.add(stmt);
            }
        }

        return result;
    }

    private static class ReturnValue extends RuntimeException {
        final Object value;

        ReturnValue(Object value) {
            this.value = value;
        }
    }

    // =========================
    // Program / Statements
    // =========================

    @Override
    public Object visitProgram(ArabicLangParser.ProgramContext ctx) {
        for (ArabicLangParser.StatementContext stmt : ctx.statement()) {
            visit(stmt);
        }
        return null;
    }

    @Override
    public Object visitVariableDeclaration(ArabicLangParser.VariableDeclarationContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        Object value = null;

        if (ctx.expression() != null) {
            value = visit(ctx.expression());
        }

        defineVariable(varName, value);
        return null;
    }

    @Override
    public Object visitAssignStatement(ArabicLangParser.AssignStatementContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        Object value = visit(ctx.expression());
        assignVariable(varName, value);
        return null;
    }

    @Override
    public Object visitPrintStatement(ArabicLangParser.PrintStatementContext ctx) {
        if (ctx.argumentList() == null) {
            System.out.println();
            return null;
        }

        List<String> parts = new ArrayList<>();
        for (ArabicLangParser.ExpressionContext expr : ctx.argumentList().expression()) {
            Object value = visit(expr);
            parts.add(formatValue(value));
        }

        System.out.println(String.join(" ", parts));
        return null;
    }

    @Override
    public Object visitIfStatement(ArabicLangParser.IfStatementContext ctx) {
        Object condition = visit(ctx.expression());

        List<ArabicLangParser.StatementContext> ifStatements = getIfStatementsBeforeElse(ctx);
        List<ArabicLangParser.StatementContext> elseStatements = getIfStatementsAfterElse(ctx);

        if (isTruthy(condition)) {
            for (ArabicLangParser.StatementContext stmt : ifStatements) {
                visit(stmt);
            }
        } else {
            for (ArabicLangParser.StatementContext stmt : elseStatements) {
                visit(stmt);
            }
        }

        return null;
    }

    @Override
    public Object visitWhileStatement(ArabicLangParser.WhileStatementContext ctx) {
        while (isTruthy(visit(ctx.expression()))) {
            for (ArabicLangParser.StatementContext stmt : ctx.statement()) {
                visit(stmt);
            }
        }
        return null;
    }

    @Override
    public Object visitFunctionDeclaration(ArabicLangParser.FunctionDeclarationContext ctx) {
        String functionName = ctx.IDENTIFIER().getText();

        if (functions.containsKey(functionName)) {
            throw new RuntimeException("Function already defined: " + functionName);
        }

        functions.put(functionName, ctx);
        return null;
    }

    @Override
    public Object visitReturnStatement(ArabicLangParser.ReturnStatementContext ctx) {
        Object value = null;

        if (ctx.expression() != null) {
            value = visit(ctx.expression());
        }

        throw new ReturnValue(value);
    }

    @Override
    public Object visitExpressionStatement(ArabicLangParser.ExpressionStatementContext ctx) {
        return visit(ctx.expression());
    }

    // =========================
    // Expressions
    // =========================

    @Override
    public Object visitExpression(ArabicLangParser.ExpressionContext ctx) {
        return visit(ctx.logicalOrExpression());
    }

    @Override
    public Object visitLogicalOrExpression(ArabicLangParser.LogicalOrExpressionContext ctx) {
        Object left = visit(ctx.logicalAndExpression(0));

        for (int i = 1; i < ctx.logicalAndExpression().size(); i++) {
            if (isTruthy(left)) {
                return true;
            }

            Object right = visit(ctx.logicalAndExpression(i));
            left = isTruthy(left) || isTruthy(right);
        }

        return left;
    }

    @Override
    public Object visitLogicalAndExpression(ArabicLangParser.LogicalAndExpressionContext ctx) {
        Object left = visit(ctx.equalityExpression(0));

        for (int i = 1; i < ctx.equalityExpression().size(); i++) {
            if (!isTruthy(left)) {
                return false;
            }

            Object right = visit(ctx.equalityExpression(i));
            left = isTruthy(left) && isTruthy(right);
        }

        return left;
    }

    @Override
    public Object visitEqualityExpression(ArabicLangParser.EqualityExpressionContext ctx) {
        Object left = visit(ctx.comparisonExpression(0));

        for (int i = 1; i < ctx.comparisonExpression().size(); i++) {
            Object right = visit(ctx.comparisonExpression(i));
            String op = ctx.getChild(2 * i - 1).getText();

            left = switch (op) {
                case "==" -> Objects.equals(left, right);
                case "!=" -> !Objects.equals(left, right);
                default -> throw new RuntimeException("Unknown equality operator: " + op);
            };
        }

        return left;
    }

    @Override
    public Object visitComparisonExpression(ArabicLangParser.ComparisonExpressionContext ctx) {
        Object left = visit(ctx.additiveExpression(0));

        for (int i = 1; i < ctx.additiveExpression().size(); i++) {
            Object right = visit(ctx.additiveExpression(i));
            String op = ctx.getChild(2 * i - 1).getText();

            double l = toNumber(left);
            double r = toNumber(right);

            left = switch (op) {
                case ">" -> l > r;
                case "<" -> l < r;
                case ">=" -> l >= r;
                case "<=" -> l <= r;
                default -> throw new RuntimeException("Unknown comparison operator: " + op);
            };
        }

        return left;
    }

    @Override
    public Object visitAdditiveExpression(ArabicLangParser.AdditiveExpressionContext ctx) {
        Object left = visit(ctx.multiplicativeExpression(0));

        for (int i = 1; i < ctx.multiplicativeExpression().size(); i++) {
            Object right = visit(ctx.multiplicativeExpression(i));
            String op = ctx.getChild(2 * i - 1).getText();

            if (op.equals("+") && (left instanceof String || right instanceof String)) {
                left = String.valueOf(left) + String.valueOf(right);
                continue;
            }

            double l = toNumber(left);
            double r = toNumber(right);

            left = switch (op) {
                case "+" -> normalizeNumber(l + r);
                case "-" -> normalizeNumber(l - r);
                default -> throw new RuntimeException("Unknown additive operator: " + op);
            };
        }

        return left;
    }

    @Override
    public Object visitMultiplicativeExpression(ArabicLangParser.MultiplicativeExpressionContext ctx) {
        Object left = visit(ctx.unaryExpression(0));

        for (int i = 1; i < ctx.unaryExpression().size(); i++) {
            Object right = visit(ctx.unaryExpression(i));
            String op = ctx.getChild(2 * i - 1).getText();

            double l = toNumber(left);
            double r = toNumber(right);

            left = switch (op) {
                case "*" -> normalizeNumber(l * r);
                case "/" -> normalizeNumber(l / r);
                case "%" -> normalizeNumber(l % r);
                default -> throw new RuntimeException("Unknown multiplicative operator: " + op);
            };
        }

        return left;
    }

    @Override
    public Object visitUnaryExpression(ArabicLangParser.UnaryExpressionContext ctx) {
        if (ctx.primary() != null) {
            return visit(ctx.primary());
        }

        Object value = visit(ctx.unaryExpression());

        if (ctx.NOT() != null) {
            return !isTruthy(value);
        }

        if (ctx.MINUS() != null) {
            return normalizeNumber(-toNumber(value));
        }

        if (ctx.PLUS() != null) {
            return normalizeNumber(+toNumber(value));
        }

        return value;
    }

    @Override
    public Object visitPrimary(ArabicLangParser.PrimaryContext ctx) {
        Object value = visit(ctx.atom());

        for (ArabicLangParser.ExpressionContext expr : ctx.expression()) {
            Object indexObj = visit(expr);

            if (!(value instanceof List<?> list)) {
                throw new RuntimeException("Trying to index a non-array");
            }

            int index = (int) toNumber(indexObj);

            if (index < 0 || index >= list.size()) {
                throw new RuntimeException("Array index out of bounds: " + index);
            }

            value = list.get(index);
        }

        return value;
    }

    @Override
    public Object visitAtom(ArabicLangParser.AtomContext ctx) {
        if (ctx.NUMBER() != null) {
            String text = ctx.NUMBER().getText();
            return text.contains(".") ? Double.parseDouble(text) : Integer.parseInt(text);
        }

        if (ctx.STRING() != null) {
            String text = ctx.STRING().getText();
            return text.substring(1, text.length() - 1);
        }

        if (ctx.TRUE() != null) {
            return true;
        }

        if (ctx.FALSE() != null) {
            return false;
        }

        if (ctx.NULL() != null) {
            return null;
        }

        if (ctx.arrayLiteral() != null) {
            return visit(ctx.arrayLiteral());
        }

        if (ctx.functionCall() != null) {
            return visit(ctx.functionCall());
        }

        if (ctx.IDENTIFIER() != null) {
            return getVariable(ctx.IDENTIFIER().getText());
        }

        if (ctx.expression() != null) {
            return visit(ctx.expression());
        }

        return null;
    }

    @Override
    public Object visitFunctionCall(ArabicLangParser.FunctionCallContext ctx) {
        String functionName = ctx.IDENTIFIER().getText();

        if (!functions.containsKey(functionName)) {
            throw new RuntimeException("Undefined function: " + functionName);
        }

        ArabicLangParser.FunctionDeclarationContext functionCtx = functions.get(functionName);

        List<String> paramNames = new ArrayList<>();
        if (functionCtx.parameterList() != null) {
            for (TerminalNode id : functionCtx.parameterList().IDENTIFIER()) {
                paramNames.add(id.getText());
            }
        }

        List<Object> argValues = new ArrayList<>();
        if (ctx.argumentList() != null) {
            for (ArabicLangParser.ExpressionContext expr : ctx.argumentList().expression()) {
                argValues.add(visit(expr));
            }
        }

        if (paramNames.size() != argValues.size()) {
            throw new RuntimeException(
                    "Function " + functionName + " expects " + paramNames.size()
                            + " arguments but got " + argValues.size()
            );
        }

        Map<String, Object> localScope = new HashMap<>();
        for (int i = 0; i < paramNames.size(); i++) {
            localScope.put(paramNames.get(i), argValues.get(i));
        }

        scopes.push(localScope);

        try {
            for (ArabicLangParser.StatementContext stmt : functionCtx.statement()) {
                visit(stmt);
            }
        } catch (ReturnValue rv) {
            scopes.pop();
            return rv.value;
        }

        scopes.pop();
        return null;
    }

    private String formatValue(Object value) {
        if (value == null) {
            return "فارغ";
        }

        if (value instanceof Double d) {
            if (d == Math.floor(d)) {
                return String.valueOf(d.intValue());
            }
            return String.valueOf(d);
        }

        if (value instanceof List<?> list) {
            List<String> formattedItems = new ArrayList<>();
            for (Object item : list) {
                formattedItems.add(formatValue(item));
            }
            return "[" + String.join(", ", formattedItems) + "]";
        }

        return String.valueOf(value);
    }
}