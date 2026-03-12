// Generated from C:/Users/adamgaafar/Documents/Projects/Alang/src/main/antlr/ArabicLang.g4 by ANTLR 4.13.2
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
	 * Enter a parse tree produced by {@link ArabicLangParser#terminator}.
	 * @param ctx the parse tree
	 */
	void enterTerminator(ArabicLangParser.TerminatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#terminator}.
	 * @param ctx the parse tree
	 */
	void exitTerminator(ArabicLangParser.TerminatorContext ctx);
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
	 * Enter a parse tree produced by {@link ArabicLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(ArabicLangParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(ArabicLangParser.PrimaryContext ctx);
}