// Generated from ArabicLang.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ArabicLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ArabicLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ArabicLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ArabicLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArabicLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ArabicLangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArabicLangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(ArabicLangParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArabicLangParser#assignStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStatement(ArabicLangParser.AssignStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArabicLangParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(ArabicLangParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArabicLangParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(ArabicLangParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArabicLangParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(ArabicLangParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArabicLangParser#terminator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminator(ArabicLangParser.TerminatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArabicLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ArabicLangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArabicLangParser#comparisonExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression(ArabicLangParser.ComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArabicLangParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(ArabicLangParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArabicLangParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(ArabicLangParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArabicLangParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(ArabicLangParser.PrimaryContext ctx);
}