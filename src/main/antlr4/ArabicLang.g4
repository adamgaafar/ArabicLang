grammar ArabicLang;

// =========================
// Parser Rules
// =========================

program
    : statement* EOF
    ;

statement
    : variableDeclaration terminator?
    | assignStatement terminator?
    | printStatement terminator?
    | ifStatement
    | whileStatement
    | forStatement
    | functionDeclaration
    | returnStatement terminator?
    | expressionStatement terminator?
    ;

variableDeclaration
    : VAR IDENTIFIER (ASSIGN expression)?
    ;

assignStatement
    : IDENTIFIER ASSIGN expression
    ;

printStatement
    : PRINT LPAREN argumentList? RPAREN
    ;

functionDeclaration
    : FUNCTION IDENTIFIER LPAREN parameterList? RPAREN RBRACE statement* LBRACE
    ;

ifStatement
    : IF LPAREN expression RPAREN RBRACE statement* LBRACE
      (ELSE RBRACE statement* LBRACE)?
    ;

whileStatement
    : WHILE LPAREN expression RPAREN RBRACE statement* LBRACE
    ;

forStatement
    : FOR LPAREN forInitializer? SEMI expression? SEMI forUpdate? RPAREN RBRACE statement* LBRACE
    ;

returnStatement
    : RETURN expression?
    ;

expressionStatement
    : expression
    ;

parameterList
    : IDENTIFIER (COMMA IDENTIFIER)*
    ;

argumentList
    : expression (COMMA expression)*
    ;

forInitializer
    : variableDeclaration
    | assignStatement
    | expression
    ;

forUpdate
    : assignStatement
    | expression
    ;

// =========================
// Expressions
// =========================

expression
    : logicalOrExpression
    ;

logicalOrExpression
    : logicalAndExpression (OR logicalAndExpression)*
    ;

logicalAndExpression
    : equalityExpression (AND equalityExpression)*
    ;

equalityExpression
    : comparisonExpression ((EQ | NEQ) comparisonExpression)*
    ;

comparisonExpression
    : additiveExpression ((GT | LT | GTE | LTE) additiveExpression)*
    ;

additiveExpression
    : multiplicativeExpression ((PLUS | MINUS) multiplicativeExpression)*
    ;

multiplicativeExpression
    : unaryExpression ((MULT | DIV | MOD) unaryExpression)*
    ;

unaryExpression
    : (NOT | MINUS | PLUS) unaryExpression
    | primary
    ;

primary
    : atom (LBRACKET expression RBRACKET)*
    ;

atom
    : NUMBER
    | STRING
    | TRUE
    | FALSE
    | NULL
    | arrayLiteral
    | functionCall
    | IDENTIFIER
    | LPAREN expression RPAREN
    ;

arrayLiteral
    : LBRACKET (expression (COMMA expression)*)? RBRACKET
    ;

functionCall
    : IDENTIFIER LPAREN argumentList? RPAREN
    ;

terminator
    : SEMI
    ;

// =========================
// Lexer Rules

// =========================

VAR       : 'عرف' ;
PRINT     : 'اطبع' ;
IF        : 'اذا' ;
ELSE      : 'وإلا' ;
WHILE     : 'طالما' ;
FOR       : 'لكل' ;
FUNCTION  : 'دالة' ;
RETURN    : 'ارجع' ;

TRUE      : 'صح' ;
FALSE     : 'خطأ' ;
NULL      : 'فارغ' ;

COMMENT   : '#' ~[\r\n]* -> skip ;

SEMI      : '؛' ;
COMMA     : ',' ;

RBRACE    : '}' ;
LBRACE    : '{' ;

LPAREN    : '(' ;
RPAREN    : ')' ;

LBRACKET  : '[' ;
RBRACKET  : ']' ;

PLUS      : '+' ;
MINUS     : '-' ;
MULT      : '*' ;
DIV       : '/' ;
MOD       : '%' ;

GTE       : '>=' ;
LTE       : '<=' ;
EQ        : '==' ;
NEQ       : '!=' ;
GT        : '>' ;
LT        : '<' ;

AND       : '&&' ;
OR        : '||' ;
NOT       : '!' ;

ASSIGN    : '=' ;

STRING
    : '"' ( '\\' . | ~["\\\r\n] )* '"'
    ;

NUMBER
    : [0-9]+ ('.' [0-9]+)?
    ;

IDENTIFIER
    : [\u0621-\u064A_a-zA-Z_][\u0621-\u064A0-9_a-zA-Z_]*
    ;

WS
    : [ \t]+ -> skip
    ;


NEWLINE
    : ('\r'? '\n')+ -> skip
    ;