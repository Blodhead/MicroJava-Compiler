
package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{

	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\f" 	{ }

"program"   { return new_symbol(sym.PROG, yytext());}
"const"		{ return new_symbol(sym.CONST, yytext());}
"void" 		{ return new_symbol(sym.VOID, yytext());}
"if"		{ return new_symbol(sym.IF, yytext());}
"else"		{ return new_symbol(sym.ELSE, yytext());}
"while"		{ return new_symbol(sym.WHILE, yytext());}
"break" 	{ return new_symbol(sym.BREAK, yytext());}
"continue"	{ return new_symbol(sym.CONTINUE, yytext());}
"return" 	{ return new_symbol(sym.RETURN, yytext());}
"read"		{ return new_symbol(sym.READ, yytext());}
"print" 	{ return new_symbol(sym.PRINT, yytext());}
"new"		{ return new_symbol(sym.NEW, yytext());}

"||"		{ return new_symbol(sym.OR, yytext());}
"&&"		{ return new_symbol(sym.AND, yytext());}

"+" 		{ return new_symbol(sym.PLUS, yytext());}
"-" 		{ return new_symbol(sym.MINUS, yytext());}
"*" 		{ return new_symbol(sym.MUL, yytext());}
"/" 		{ return new_symbol(sym.DIV, yytext());}
"%" 		{ return new_symbol(sym.MOD, yytext());}

"++"		{ return new_symbol(sym.PLUSPLUS, yytext());}
"--"		{ return new_symbol(sym.MINUSMINUS, yytext());}

"=="		{ return new_symbol(sym.SAME, yytext());}
"!="		{ return new_symbol(sym.DIFFERENT, yytext());}
">"			{ return new_symbol(sym.GREATER, yytext());}
">="		{ return new_symbol(sym.EGREATER, yytext());}
"<"			{ return new_symbol(sym.LESSER, yytext());}
"<="		{ return new_symbol(sym.ELESSER, yytext());}


"=" 		{ return new_symbol(sym.EQUAL, yytext());}
";" 		{ return new_symbol(sym.SEMI, yytext());}
"," 		{ return new_symbol(sym.COMMA, yytext());}
"(" 		{ return new_symbol(sym.LPAREN, yytext());}
")" 		{ return new_symbol(sym.RPAREN, yytext());}
"{" 		{ return new_symbol(sym.LBRACE, yytext());}
"}"			{ return new_symbol(sym.RBRACE, yytext());}
"["			{ return new_symbol(sym.LSQUARE, yytext());}
"]"			{ return new_symbol(sym.RSQUARE, yytext());}

"//" {yybegin(COMMENT);}
<COMMENT> . {yybegin(COMMENT);}
<COMMENT> "\r\n" { yybegin(YYINITIAL); }

[0-9]+  { return new_symbol(sym.NUMBER, new Integer (yytext())); }
"true"|"false"  { return new_symbol(sym.BOOLEAN, new String (yytext())); }
"'"[ -~]"'"		{ return new_symbol(sym.CHAR, yytext()); }
([a-z]|[A-Z])[a-zA-Z0-9_]* 	{return new_symbol (sym.IDENT, yytext()); }

. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)); }










