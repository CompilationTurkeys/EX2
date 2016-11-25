/***************************/
/* FILE NAME: LEX_FILE.lex */
/***************************/

/***************************/
/* AUTHOR: OREN ISH SHALOM */
/***************************/

/*************/
/* USER CODE */
/*************/
   
import java_cup.runtime.*;

/******************************/
/* DOLAR DOLAR - DON'T TOUCH! */
/******************************/
      
%%
   
/************************************/
/* OPTIONS AND DECLARATIONS SECTION */
/************************************/
   
/*****************************************************/ 
/* Lexer is the name of the class JFlex will create. */
/* The code will be written to the file Lexer.java.  */
/*****************************************************/ 
%class Lexer

/********************************************************************/
/* The current line number can be accessed with the variable yyline */
/* and the current column number with the variable yycolumn.        */
/********************************************************************/
%line
%column
    
/******************************************************************/
/* CUP compatibility mode interfaces with a CUP generated parser. */
/******************************************************************/
%cup
   
/****************/
/* DECLARATIONS */
/****************/
/*****************************************************************************/   
/* Code between %{ and %}, both of which must be at the beginning of a line, */
/* will be copied letter to letter into the Lexer class code.                */
/* Here you declare member variables and functions that are used inside the  */
/* scanner actions.                                                          */  
/*****************************************************************************/   
%{   
    /*********************************************************************************/
    /* Create a new java_cup.runtime.Symbol with information about the current token */
    /*********************************************************************************/
    private Symbol symbol(int type)               {return new Symbol(type, yyline, yycolumn);}
    private Symbol symbol(int type, Object value) {return new Symbol(type, yyline, yycolumn, value);}
%}

/***********************/
/* MACRO DECALARATIONS */
/***********************/
LINETERMINATOR	= \r|\n|\r\n
WHITESPACE		= {LINETERMINATOR} | [ \t\f]
INTEGER			= 0 | [1-9][0-9]*
IDENTIFIER		= [a-z][a-zA-Z_0-9]*
QUOTE			= \"([^\\\"]|\\.)*\"
CLASSID 		= [A-Z][a-z_0-9]*
COMMENTS		= "/*"((("*"[^/])?)|[^*])*"*/" | "//".*

   
/******************************/
/* DOLAR DOLAR - DON'T TOUCH! */
/******************************/

%%

/************************************************************/
/* LEXER matches regular expressions to actions (Java code) */
/************************************************************/
   
/**************************************************************/
/* YYINITIAL is the state at which the lexer begins scanning. */
/* So these regular expressions will only be matched if the   */
/* scanner is in the start state YYINITIAL.                   */
/**************************************************************/
   
<YYINITIAL> {

"+"					{ System.out.println((yyline+1)+ ": " + "PLUS"); return symbol(sym.PLUS);}
"-"					{ System.out.println((yyline+1)+ ": " + "MINUS"); return symbol(sym.MINUS);}
"*"					{ System.out.println((yyline+1)+ ": " + "MULTIPLY"); return symbol(sym.MULTIPLY);}
"/"					{ System.out.println((yyline+1)+ ": " + "DIVIDE"); return symbol(sym.DIVIDE);}
"("					{ System.out.println((yyline+1)+ ": " + "LP"); return symbol(sym.LP);}
")"					{ System.out.println((yyline+1)+ ": " + "RP"); return symbol(sym.RP);}
"class"				{ System.out.println((yyline+1)+ ": " + "CLASS"); return symbol(sym.CLASS);}
"{"					{ System.out.println((yyline+1)+ ": " + "LCBR"); return symbol(sym.LCBR);}
"int"				{ System.out.println((yyline+1)+ ": " + "INT"); return symbol(sym.INT);}
"["					{ System.out.println((yyline+1)+ ": " + "LB"); return symbol(sym.LB);}
"]"					{ System.out.println((yyline+1)+ ": " + "RB"); return symbol(sym.RB);}
";"					{ System.out.println((yyline+1)+ ": " + "SEMI"); return symbol(sym.SEMI);}
"="							{ System.out.println((yyline+1)+ ": " + "ASSIGN");return symbol(sym.ASSIGN);}
"boolean"					{ System.out.println((yyline+1)+ ": " + "BOOLEAN");return symbol(sym.BOOLEAN);}
"break"						{ System.out.println((yyline+1)+ ": " + "BREAK");return symbol(sym.BREAK);}
","							{ System.out.println((yyline+1)+ ": " + "COMMA");return symbol(sym.COMMA);}
"continue"					{ System.out.println((yyline+1)+ ": " + "CONTINUE");return symbol(sym.CONTINUE);}
"."							{ System.out.println((yyline+1)+ ": " + "DOT");return symbol(sym.DOT);}
"=="					{ System.out.println((yyline+1)+ ": " + "EQUAL");return symbol(sym.EQUAL);}
"extends"				{ System.out.println((yyline+1)+ ": " + "EXTENDS");return symbol(sym.EXTENDS);}
"else"					{ System.out.println((yyline+1)+ ": " + "ELSE");return symbol(sym.ELSE);}
"false"					{ System.out.println((yyline+1)+ ": " + "FALSE");return symbol(sym.FALSE);}
">"						{ System.out.println((yyline+1)+ ": " + "GT");return symbol(sym.GT);}
">="						{ System.out.println((yyline+1)+ ": " + "GTE");return symbol(sym.GTE);}
"if"						{ System.out.println((yyline+1)+ ": " + "IF");return symbol(sym.IF);}
"integer"						{ System.out.println((yyline+1)+ ": " + "INTEGER");return symbol(sym.INTEGER);}
"&&"						{ System.out.println((yyline+1)+ ": " + "LAND");return symbol(sym.LAND);}
"length"						{ System.out.println((yyline+1)+ ": " + "LENGTH");return symbol(sym.LENGTH);}
"new"						{ System.out.println((yyline+1)+ ": " + "NEW");return symbol(sym.NEW);}
"!"						{ System.out.println((yyline+1)+ ": " + "LNEG");return symbol(sym.LNEG);}
"||"						{ System.out.println((yyline+1)+ ": " + "LOR");return symbol(sym.LOR);}
"<"						{ System.out.println((yyline+1)+ ": " + "LT");return symbol(sym.LT);}
"<="						{ System.out.println((yyline+1)+ ": " + "LTE");return symbol(sym.LTE);}
"%"						{ System.out.println((yyline+1)+ ": " + "MOD");return symbol(sym.MOD);}
"!="						{ System.out.println((yyline+1)+ ": " + "NEQUAL");return symbol(sym.NEQUAL);}
"null"						{ System.out.println((yyline+1)+ ": " + "NULL");return symbol(sym.NULL);}
"}"						{ System.out.println((yyline+1)+ ": " + "RCBR");return symbol(sym.RCBR);}
"return"						{ System.out.println((yyline+1)+ ": " + "RETURN");return symbol(sym.RETURN);}
"static"						{ System.out.println((yyline+1)+ ": " + "STATIC");return symbol(sym.STATIC);}
"string"						{ System.out.println((yyline+1)+ ": " + "STRING");return symbol(sym.STRING);}
"this"						{ System.out.println((yyline+1)+ ": " + "THIS");return symbol(sym.THIS);}
"true"						{ System.out.println((yyline+1)+ ": " + "TRUE");return symbol(sym.TRUE);}
"void"						{ System.out.println((yyline+1)+ ": " + "VOID");return symbol(sym.VOID);}
"while"						{ System.out.println((yyline+1)+ ": " + "WHILE");return symbol(sym.WHILE);}
<<EOF>>     				{ System.out.print((yyline+2)+ ": " + "EOF");return symbol(sym.EOF);}


{QUOTE}  			{ System.out.println((yyline+1)+ ": " + "QUOTE"+"(" +yytext()+")"); return symbol(sym.QUOTE);}
{CLASSID}  			{ System.out.println((yyline+1)+ ": " + "CLASS_ID"+"(" +yytext()+")"); return symbol(sym.CLASS_ID);}
{INTEGER}			{ System.out.println((yyline+1)+ ": " + "INTEGER" +"(" +yytext()+")"); return symbol(sym.INTEGER, new Integer(yytext()));}   
{WHITESPACE}		{ /* just skip what was found, do nothing */ }
{COMMENTS}			{ /* just skip what was found, do nothing */ }
{IDENTIFIER}		{ System.out.println((yyline+1)+ ": " + "ID"+"(" +yytext()+")"); return symbol(sym.ID);}

}

[^]                 { System.out.print((yyline+1)+ ": "+"Lexical error: illegal character "+"'"+yytext()+"'"); System.exit(-1);}
