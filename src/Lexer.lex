package java_quaero.parser;

import java_cup.runtime.Symbol;

%%

%public 
%class Lexer
%cupsym Tokens
%cup
%implements Tokens

%{ 
	/* Embedded lexer class code */  
%}

%% 
// Tokens.
 
"("	  { return new Symbol(PARI, yyline, yycolumn, yytext()); }
")"	  { return new Symbol(PARD, yyline, yycolumn, yytext()); }
"F"	  { return new Symbol(FALSE, yyline, yycolumn, yytext()); }
"T"	  { return new Symbol(TRUE, yyline, yycolumn, yytext()); }
"~"	  { return new Symbol(NEG, yyline, yycolumn, yytext()); }
"/\\" { return new Symbol(CONJ, yyline, yycolumn, yytext()); }
"\\/" { return new Symbol(DISY, yyline, yycolumn, yytext()); }
"->"  { return new Symbol(COND, yyline, yycolumn, yytext()); }
"<->" { return new Symbol(BICOND, yyline, yycolumn, yytext()); }
";"   { return new Symbol(PUNTOCOMA); }
"="   { return new Symbol(IGUAL); }

[a-z][a-zA-Z0-9]* {return new Symbol(ID, yyline, yycolumn, yytext()); }
[ \t\r\n\f\v]+
	{ /* Ignore */ }

.	{ /* Fallback */
		return new Symbol(error, "Unexpected input <"+ yytext() +">!"); 
	}