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



\'[()\{\}\-+a-zA-Z0-9_\[\]*.]*\' {System.out.println(yytext()); return new Symbol(REGEXQ , yytext()); }
"("	  { return new Symbol(PARI, yytext()); }
")"	  { return new Symbol(PARD, yytext()); }
":"	  { return new Symbol(COLON, yytext()); }
","   { return new Symbol(COMMA, yytext()); }
"\+"   { return new Symbol(PLUS, yytext()); }
"-"   { return new Symbol(MINUS, yytext()); }
"&"	  { return new Symbol(UNION, yytext()); }
"\|"  { return new Symbol(INTER, yytext()); }
"$"   { return new Symbol(DOLLAR, yytext()); }
"/"   { return new Symbol(SLASH, yytext()); }
"\."  { return new Symbol(DOT, yytext()); }
"~"   { return new Symbol(TILDE , yytext()); }
"\'"  { return new Symbol(QUOTE , yytext()); }
[a-zA-Z_][a-zA-Z0-9_]* { return new Symbol(ID, yytext()); }
\"[^\n\"]*\" { return new Symbol(STRING, yyline, yycolumn, yytext()); }
([0-9]*\.)?[0-9]+([eE][+-]?[0-9]+)? { return new Symbol(NUM, Double.parseDouble(yytext())); }
[\{\}-+a-zA-Z0-9_\[\]*]* { return new Symbol(REGEX , yytext()); } 
[ \t\r\n\f\v]+ { /* Ignore */ }

.	{ /* Fallback */
		return new Symbol(error, "Unexpected input <"+ yytext() +">!"); 
	}