import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class ArabicLangCLI {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: Alang <file.alam>");
            return;
        }

        String filePath = args[0];

        if (!filePath.endsWith(".alam")) {
            System.out.println("Error: file must have .alam extension");
            return;
        }

        try {
            CharStream input = CharStreams.fromFileName(filePath);

            ArabicLangLexer lexer = new ArabicLangLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ArabicLangParser parser = new ArabicLangParser(tokens);

            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(
                        Recognizer<?, ?> recognizer,
                        Object offendingSymbol,
                        int line,
                        int charPositionInLine,
                        String msg,
                        RecognitionException e
                ) {
                    throw new RuntimeException(
                            "Syntax error at line " + line + ":" + charPositionInLine + " -> " + msg
                    );
                }
            });

            ParseTree tree = parser.program();

            Interpreter interpreter = new Interpreter();
            interpreter.visit(tree);

        } catch (Exception e) {
            if (e.getMessage().contains("Array index out"))
                System.out.println("هذيه المصفوفة غارج نتطاق البحث");
            System.out.println("Execution error: " + e.getMessage());
        }
    }
}