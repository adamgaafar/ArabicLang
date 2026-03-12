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
STRING : '"' ~["\r\n]* '"' ;
NUMBER : [0-9]+ ('.' [0-9]+)? ;

VAR    : 'عرف' ;
PRINT  : 'اطبع' ;
IF     : 'اذا' ;
ELSE   : 'وإلا' ;
WHILE  : 'طالما' ;
RETURN : 'ارجع' ;

COMMENT : '#' ~[\r\n]* -> skip ;

SEMI   : ';' ;
RBRACE : '}' ;
LBRACE : '{' ;
LPAREN : '(' ;
RPAREN : ')' ;

PLUS   : '+' ;
MINUS  : '-' ;
MULT   : '*' ;
DIV    : '/' ;

GTE    : '>=' ;
LTE    : '<=' ;
EQ     : '==' ;
NEQ    : '!=' ;
GT     : '>' ;
LT     : '<' ;
ASSIGN : '=' ;

WS      : [ \t]+ -> skip ;
NEWLINE : ('\r'? '\n')+ -> skip ;

IDENTIFIER : [\u0621-\u064A_][\u0621-\u064A0-9_]* ;

