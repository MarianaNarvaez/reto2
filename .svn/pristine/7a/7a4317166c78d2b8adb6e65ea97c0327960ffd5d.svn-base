lexer grammar marianaAntlrLexer;

@header{
package co.edu.eafit.dis.st0270.p20151.mariana.pl0.lexer;
}

SEPARATOR
    : '('
    | ')'
    | '{'
    | '}'
    | ';'
    | ','
    | '.'
    ;

OPERATOR
    :
    | '<'
    | '<='
    | '>'
    | '>='
    | '='
    | '<>'
    | ':='
    | '+'
    | '-'
    | '*'
    | '/'
    ;

KEYWORDS
    : 'call'
    | 'begin'
    | 'if'
    | 'then'
    | 'while'
    | 'do'
    | 'end'
    | 'odd'
    | 'procedure'
    | 'var'
    | 'int'
    ;

IDENTIFIER  :    ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT : ('1'..'9')('0'..'9')* | ('0')*
    ;


WHITESPACE  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        | '\f'
        | '\r\n'
      ) ->skip ;

CHAR : (.);
