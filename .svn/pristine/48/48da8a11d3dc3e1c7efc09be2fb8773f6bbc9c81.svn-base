package co.edu.eafit.dis.st0270.p20151.mariana.pl0.lexer;

import co.edu.eafit.dis.st0270.p20151.mariana.pl0.tokens.Token;

%%
%class marianaJFlexLexer
%unicode
%line
%column
%function getNextToken
%int
%public

%{
public int getLine() {
   return yyline + 1;
}

public int getColumn() {
   return yycolumn + 1;
}

public boolean fic = false;

%}

InputCharacter       = [^\r\n]
WhiteSpace           = {LineTerminator} | [ \t\n\f]
LineTerminator       = \r|\n|\r\n


Identifier           = [a-z|A-Z] [a-z|A-Z|0-9|"_"]*
Integer              = ( 0)* | [1-9][0-9]*

Keyword              = "const" | "var" | "procedure" | "call" | "begin" | "end" |
 "if" | "then" | "while" | "do" | "odd"

Separator            = "(" | ")" | ";" | "," | "."| "{" | "}"

Operator             = "<" | "<=" | ">" | ">=" | "=" | ":=" | "<>" | "+" |"*" | "|"

%%


<YYINITIAL> {
   {Keyword}                 { return Token.Keyword.ordinal();}
   {Identifier}              { return Token.Identifier.ordinal(); }
   {Integer}     	     { return Token.Integer.ordinal(); }
   {Separator}               { return Token.Separator.ordinal(); }
   {Operator}                { return Token.Operator.ordinal();}
   {WhiteSpace}              { /* Ignore */ }
}

.|\n  {
      
         
       
         System.out.println("error: \"" + yytext()
          + "\" fila: " + getLine() + " col: " + getColumn());
   
         fic = true;

      }

