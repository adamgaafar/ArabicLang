// Generated from C:/Users/adamgaafar/Documents/Projects/Alang/src/main/antlr4/ArabicLang.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArabicLangParser}.
 */
public interface ArabicLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ArabicLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ArabicLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ArabicLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ArabicLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(ArabicLangParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(ArabicLangParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStatement(ArabicLangParser.AssignStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStatement(ArabicLangParser.AssignStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(ArabicLangParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(ArabicLangParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(ArabicLangParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(ArabicLangParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(ArabicLangParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(ArabicLangParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(ArabicLangParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(ArabicLangParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(ArabicLangParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(ArabicLangParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(ArabicLangParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(ArabicLangParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(ArabicLangParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(ArabicLangParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(ArabicLangParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(ArabicLangParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(ArabicLangParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(ArabicLangParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#forInitializer}.
	 * @param ctx the parse tree
	 */
	void enterForInitializer(ArabicLangParser.ForInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#forInitializer}.
	 * @param ctx the parse tree
	 */
	void exitForInitializer(ArabicLangParser.ForInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(ArabicLangParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(ArabicLangParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ArabicLangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ArabicLangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(ArabicLangParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(ArabicLangParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(ArabicLangParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(ArabicLangParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(ArabicLangParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(ArabicLangParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#comparisonExpression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(ArabicLangParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#comparisonExpression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(ArabicLangParser.ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(ArabicLangParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(ArabicLangParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(ArabicLangParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(ArabicLangParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(ArabicLangParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(ArabicLangParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(ArabicLangParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(ArabicLangParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(ArabicLangParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(ArabicLangParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(ArabicLangParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(ArabicLangParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(ArabicLangParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(ArabicLangParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArabicLangParser#terminator}.
	 * @param ctx the parse tree
	 */
	void enterTerminator(ArabicLangParser.TerminatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#terminator}.
	 * @param ctx the parse tree
	 */
	void exitTerminator(ArabicLangParser.TerminatorContext ctx);
}