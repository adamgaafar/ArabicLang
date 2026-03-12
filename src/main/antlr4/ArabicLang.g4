grammar ArabicLang;

// Parser Rules
program
    : statement* EOF
    ;

statement
    : variableDeclaration terminator?
    | assignStatement terminator?
    | printStatement terminator?
    | ifStatement
    | whileStatement
    ;

variableDeclaration
    : VAR IDENTIFIER (ASSIGN expression)?
    ;

assignStatement
    : IDENTIFIER ASSIGN expression
    ;

printStatement
    : LPAREN expression RPAREN PRINT
    | PRINT LPAREN expression RPAREN
    ;

ifStatement
    : IF LPAREN expression RPAREN LBRACE statement* RBRACE
    | RBRACE IF LPAREN expression RPAREN statement* LBRACE
    ;

whileStatement
    : RBRACE WHILE LPAREN expression RPAREN statement* LBRACE
    | WHILE LPAREN expression RPAREN LBRACE statement* RBRACE
    ;

terminator
    : SEMI
    ;

expression
    : comparisonExpression
    ;

comparisonExpression
    : additiveExpression ((GT | LT | GTE | LTE | EQ | NEQ) additiveExpression)*
    ;

additiveExpression
    : multiplicativeExpression ((PLUS | MINUS) multiplicativeExpression)*
    ;

multiplicativeExpression
    : primary ((MULT | DIV) primary)*
    ;

primary
    : NUMBER
    | STRING
    | IDENTIFIER
    | LPAREN expression RPAREN
    ;

// Lexer Rules
build on the generator 

