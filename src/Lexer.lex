package java_quaero.parser;

import java_cup.runtime.Symbol;

%%

%public 
%class Lexer
%cupsym Tokens
%cup
%implements Tokens
%unicode

%{ 
	/* Embedded lexer class code */  
%}

%% 
// Tokens.

\/\*(\*[^\/]|[^*])*\*\/	{/*ignore */}
\"[^\n\"]*\" { return new Symbol(STRING, yyline, yycolumn, yytext()); }
\'[a-zA-Z_.][a-zA-Z0-9_.]*\' { return new Symbol(ID, yytext()); }
\'[()\{\}\-+a-zA-Z0-9_\[\]*.?\^\\|,]*\' {return new Symbol(REGEX , yytext()); }
-\u221E  {return new Symbol(NUM, Double.MIN_VALUE);}
\u221E  {return new Symbol(NUM , Double.MAX_VALUE);}
([0-9]*\.)?[0-9]+([eE][+-]?[0-9]+)? { return new Symbol(NUM, Double.parseDouble(yytext())); }
"("	  { return new Symbol(PARI, yytext()); }
")"	  { return new Symbol(PARD, yytext()); }
":"	  { return new Symbol(COLON, yytext()); }
","   { return new Symbol(COMMA, yytext()); }
"\+"   { return new Symbol(PLUS, yytext()); }
"-"   { return new Symbol(MINUS, yytext()); } 
\u2229|&	  { return new Symbol(INTER, yytext()); } 
\u222A|"\|"  { return new Symbol(UNION, yytext()); }
"$"   { return new Symbol(DOLLAR, yytext()); }
"/"   { return new Symbol(SLASH, yytext()); }
"\."  { return new Symbol(DOT, yytext()); }
"~"   { return new Symbol(TILDE , yytext()); }
"\'"  { return new Symbol(QUOTE , yytext()); }
True|true|False|false	{ return new Symbol(BOOL , Boolean.valueOf(yytext())); }
\u22A4	{ return new Symbol(BOOL , Boolean.valueOf("true")); }
\u22A5	{ return new Symbol(BOOL , Boolean.valueOf("false")); }
[a-zA-Z_][a-zA-Z0-9_]* { return new Symbol(ID, yytext()); }
([\{\}a-zA-Z0-9_\[\]*?\^\\]|&&)* { return new Symbol(REGEX , yytext()); } 
[ \t\r\n\f\v]+ { /* Ignore */ }

.	{ /* Fallback */
		return new Symbol(error, "Unexpected input <"+ yytext() +">!"); 
	}