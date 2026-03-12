import java.util.HashMap;
import java.util.Map;

public class Interpreter extends ArabicLangBaseVisitor<Object> {

    private final Map<String, Object> variables = new HashMap<>();

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

        variables.put(varName, value);
        return null;
    }

    @Override
    public Object visitPrintStatement(ArabicLangParser.PrintStatementContext ctx) {
        Object value = visit(ctx.expression());
        System.out.println(value);
        return null;
    }

    @Override
    public Object visitExpression(ArabicLangParser.ExpressionContext ctx) {
        return visit(ctx.comparisonExpression());
    }

    @Override
    public Object visitComparisonExpression(ArabicLangParser.ComparisonExpressionContext ctx) {
        Object left = visit(ctx.additiveExpression(0));

        for (int i = 1; i < ctx.additiveExpression().size(); i++) {
            Object right = visit(ctx.additiveExpression(i));
            String op = ctx.getChild(2 * i - 1).getText();

            double l = ((Number) left).doubleValue();
            double r = ((Number) right).doubleValue();

            left = switch (op) {
                case ">" -> l > r;
                case "<" -> l < r;
                case ">=" -> l >= r;
                case "<=" -> l <= r;
                case "==" -> l == r;
                case "!=" -> l != r;
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

            double l = ((Number) left).doubleValue();
            double r = ((Number) right).doubleValue();

            left = switch (op) {
                case "+" -> l + r;
                case "-" -> l - r;
                default -> throw new RuntimeException("Unknown additive operator: " + op);
            };
        }

        return left;
    }

    @Override
    public Object visitMultiplicativeExpression(ArabicLangParser.MultiplicativeExpressionContext ctx) {
        Object left = visit(ctx.primary(0));

        for (int i = 1; i < ctx.primary().size(); i++) {
            Object right = visit(ctx.primary(i));
            String op = ctx.getChild(2 * i - 1).getText();

            double l = ((Number) left).doubleValue();
            double r = ((Number) right).doubleValue();

            left = switch (op) {
                case "*" -> l * r;
                case "/" -> l / r;
                default -> throw new RuntimeException("Unknown multiplicative operator: " + op);
            };
        }

        return left;
    }

    @Override
    public Object visitPrimary(ArabicLangParser.PrimaryContext ctx) {
        if (ctx.NUMBER() != null) {
            String text = ctx.NUMBER().getText();
            return text.contains(".") ? Double.parseDouble(text) : Integer.parseInt(text);
        }

        if (ctx.STRING() != null) {
            String text = ctx.STRING().getText();
            return text.substring(1, text.length() - 1);
        }

        if (ctx.IDENTIFIER() != null) {
            String varName = ctx.IDENTIFIER().getText();
            if (!variables.containsKey(varName)) {
                throw new RuntimeException("Undefined variable: " + varName);
            }
            return variables.get(varName);
        }

        if (ctx.expression() != null) {
            return visit(ctx.expression());
        }

        return null;
    }

    @Override
    public Object visitIfStatement(ArabicLangParser.IfStatementContext ctx) {
        Object condition = visit(ctx.expression());

        if (!(condition instanceof Boolean)) {
            throw new RuntimeException("If condition must evaluate to a boolean.");
        }

        if ((Boolean) condition) {
            for (ArabicLangParser.StatementContext stmt : ctx.statement()) {
                visit(stmt);
            }
        }

        return null;
    }

    @Override
    public Object visitAssignStatement(ArabicLangParser.AssignStatementContext ctx) {
        String varName = ctx.IDENTIFIER().getText();

        if (!variables.containsKey(varName)) {
            throw new RuntimeException("Undefined variable: " + varName);
        }

        Object value = visit(ctx.expression());
        variables.put(varName, value);

        return null;
    }

    @Override
    public Object visitWhileStatement(ArabicLangParser.WhileStatementContext ctx) {
        while (true) {
            Object condition = visit(ctx.expression());

            if (!(condition instanceof Boolean)) {
                throw new RuntimeException("While condition must evaluate to a boolean.");
            }

            if (!((Boolean) condition)) {
                break;
            }

            for (ArabicLangParser.StatementContext stmt : ctx.statement()) {
                visit(stmt);
            }
        }

        return null;
    }






}