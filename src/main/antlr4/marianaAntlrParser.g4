grammar marianaAntlrParser;

@header{
package co.edu.eafit.dis.st0270.p20151.mariana.pl0.parser;
}

//@lexer::header{
//package co.edu.eafit.dis.st0270.p20151.mariana.pl0.parser;
//}

IDENTIFIER  : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
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


prog : block '.' EOF                                                   #progEval
        ;

block : (defconst)? (defvar)? (defproc)* instruction                    #blockEval
      ;


defconst : 'const' IDENTIFIER '=' INT (',' IDENTIFIER '=' INT)* ';'    #defconstEval
         ;


defvar : 'var' IDENTIFIER (';' IDENTIFIER)* ';'       #defvarEval
       ;


defproc : 'procedure' IDENTIFIER ';' block ';'        #defprocEval
        ; 


instruction :(IDENTIFIER ':=' expr)                                #idenEval
            |('call' IDENTIFIER)                                    #idEval
            |('begin'instruction(';'instruction)* (';')? 'end')     #beginEval
            |('if' condition 'then' instruction)                    #ifEval
            |('while' condition 'do' instruction)                   #whiEval
            |                                                       #nullEval
            ;


condition : 'odd' expr                                 #oddEval
          | expr ('<'|'='|'<>'|'<='|'>'|'>=') expr     #expsimbolEval
          ;



expr : ('+'|'-')? term (('+'|'-') term)*         #exprEval
     ;


term : factor (('*'|'/') factor)*                #termEval
     ;

factor : IDENTIFIER           #identiEval
       | INT                  #intEval
       | '(' expr ')'         #factorEval
       ;                                             

CHAR : (.);
