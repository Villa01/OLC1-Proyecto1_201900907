/*--------------------------------------------------
 ------------  Codigo de Usuario ---------
 ---------------------------------------------------*/

//------> Paquetes,importaciones
package Analizadores; // Paquete donde se encuentra el archivo lexico.jflex
import java_cup.runtime.*;
import Estructuras.*;
import GUI.Interface;

/*----------------------------------------------------------
  ------------ Opciones y Declaraciones ---------
  ----------------------------------------------------------*/
%%
%{
    //----> Codigo de usuario en sintaxis java
%}

//-------> Directivas
%public 
%class lexico
%cupsym Simbolos
%cup
%char
%column
%full
%ignorecase
%line
%unicode

//------> Expresiones Regulares
digito              = [0-9]
letra               = [A-Za-z]
cadena              = \"[^\"\"]*\"
ascii               = [!-\/]|[:-@]|[\[-`]|[{-}]
flecha              = -(\s)*>
id                  = {letra}({digito}|{letra}|_)+
escapado            =  \\\'|\\"n"|\\\"
//FinLinea            = \r|\n|\r\n
//InputCharacter      = [^\r\n]
comentariosimple    =  "//" [^\r\n]* (\r|\n|\r\n)?
comentarioMultilinea = <![^"!>"]*!>


//------> Estados

%%

/*------------------------------------------------
  ------------  Reglas Lexicas ---------
  ------------------------------------------------*/




//-----> Simbolos

"%"         { return new Symbol(Simbolos.porc, yycolumn, yyline, yytext()); }
";"         { return new Symbol(Simbolos.ptycoma, yycolumn, yyline, yytext()); }
":"         { return new Symbol(Simbolos.dospuntos, yycolumn, yyline, yytext()); }
","         { return new Symbol(Simbolos.coma, yycolumn, yyline, yytext()); }
"."         { return new Symbol(Simbolos.conc, yycolumn, yyline, yytext()); }
"|"         { return new Symbol(Simbolos.or, yycolumn, yyline, yytext()); }
"*"         { return new Symbol(Simbolos.kleen, yycolumn, yyline, yytext()); }
"+"         { return new Symbol(Simbolos.mas, yycolumn, yyline, yytext()); }
"{"         { return new Symbol(Simbolos.llava, yycolumn, yyline, yytext()); }
"}"         { return new Symbol(Simbolos.llavc, yycolumn, yyline, yytext()); }
//"\""      { return new Symbol(Simbolos.comillaD, yycolumn, yyline, yytext()); }
"~"         { return new Symbol(Simbolos.guion, yycolumn, yyline, yytext()); }
"?"         { return new Symbol(Simbolos.interrogacion, yycolumn, yyline, yytext()); }
">"         { return new Symbol(Simbolos.mayorq, yycolumn, yyline, yytext());}

//-----> Palabras reservadas

"CONJ" { System.out.println("Reconocio Inicio de conjuntos " + yytext()); return new Symbol(Simbolos.conj, yycolumn, yyline, yytext());}

//-------> Simbolos ER
{id}                    { return new Symbol(Simbolos.id, yycolumn, yyline, yytext()); }
{digito}                { return new Symbol(Simbolos.digito, yycolumn, yyline, yytext()); }
{letra}                 { return new Symbol(Simbolos.letra, yycolumn, yyline, yytext()); }
{cadena}                { return new Symbol(Simbolos.cadena, yycolumn, yyline, yytext()); }
{flecha}                { return new Symbol(Simbolos.flecha, yycolumn, yyline, yytext());}
{ascii}                 { return new Symbol(Simbolos.ascii, yycolumn, yyline, yytext());}
{escapado}              { return new Symbol(Simbolos.escapado, yycolumn, yyline, yytext()); }

//----->Espacios
{comentariosimple}      { }
{comentarioMultilinea}  { }
[ \t\r\n\f\s]             {/* Espacios en blanco, se ignoran */}

//------> Errores Lexicos
.           { System.out.println("Error Lexico"+yytext()+" Linea "+yyline+" Columna "+yycolumn); 
                            error nuevo = new error("Error Sintactico (Recuperado)", yytext(), yyline, yycolumn);
                            Interface.listaErrores.add(nuevo); }