import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class ArabicLangCLI {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.out.println("Usage: Alang <file.alam>");
                return;
            }

            String filePath = args[0];

            if (!filePath.endsWith(".alam")) {
                System.out.println("Error: file must have .alam extension");
                return;
            }

            CharStream input = CharStreams.fromFileName(filePath);

            ArabicLangLexer lexer = new ArabicLangLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ArabicLangParser parser = new ArabicLangParser(tokens);

            ParseTree tree = parser.program();

            if (parser.getNumberOfSyntaxErrors() > 0) {
                System.out.println("Parsing failed due to syntax errors.");
                return;
            }

            Interpreter interpreter = new Interpreter();
            interpreter.visit(tree);

            System.out.println("Execution finished.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}