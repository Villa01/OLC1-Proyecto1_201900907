/*--------------------------------------------------
 ------------  Codigo de Usuario ---------
 ---------------------------------------------------*/

//------> Paquetes,importaciones
package Analizadores; // Paquete donde se encuentra el archivo lexico.jflex
import java_cup.runtime.*;

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

"<!"(letra|digito|ascii[^!])*"!>"

//------> Estados

%%

/*------------------------------------------------
  ------------  Reglas Lexicas ---------
  ------------------------------------------------*/




//-----> Simbolos

"%"         { System.out.println("Reconocio "+yytext()+" porc"); return new Symbol(Simbolos.porc, yycolumn, yyline, yytext()); }
";"         { System.out.println("Reconocio "+yytext()+" punto y coma"); return new Symbol(Simbolos.ptycoma, yycolumn, yyline, yytext()); }
":"         { System.out.println("Reconocio "+yytext()+" dos puntos"); return new Symbol(Simbolos.dospuntos, yycolumn, yyline, yytext()); }
","         { System.out.println("Reconocio "+yytext()+" coma "); return new Symbol(Simbolos.coma, yycolumn, yyline, yytext()); }
"."         { System.out.println("Reconocio "+yytext()+" concatenación "); return new Symbol(Simbolos.conc, yycolumn, yyline, yytext()); }
"|"         { System.out.println("Reconocio "+yytext()+" or "); return new Symbol(Simbolos.or, yycolumn, yyline, yytext()); }
"*"         { System.out.println("Reconocio "+yytext()+" kleen "); return new Symbol(Simbolos.kleen, yycolumn, yyline, yytext()); }
"+"         { System.out.println("Reconocio "+yytext()+" mas "); return new Symbol(Simbolos.mas, yycolumn, yyline, yytext()); }
"{"         { System.out.println("Reconocio "+yytext()+" llave abierta "); return new Symbol(Simbolos.llava, yycolumn, yyline, yytext()); }
"}"         { System.out.println("Reconocio "+yytext()+" llave cerrada "); return new Symbol(Simbolos.llavc, yycolumn, yyline, yytext()); }
//"\""        { System.out.println("Reconocio "+yytext()+" comilla doble "); return new Symbol(Simbolos.comillaD, yycolumn, yyline, yytext()); }
"~"         { System.out.println("Reconocio "+yytext()+" guion "); return new Symbol(Simbolos.guion, yycolumn, yyline, yytext()); }
"?"         { System.out.println("Reconocio "+yytext()+" interrogacion "); return new Symbol(Simbolos.interrogacion, yycolumn, yyline, yytext()); }
">"         {return new Symbol(Simbolos.mayorq, yycolumn, yyline, yytext());}

//-----> Palabras reservadas

"CONJ" { System.out.println("Reconocio Inicio de conjuntos " + yytext()); return new Symbol(Simbolos.conj, yycolumn, yyline, yytext());}

//-------> Simbolos ER
{id}                    { System.out.println("Reconocio ID "+yytext()); return new Symbol(Simbolos.id, yycolumn, yyline, yytext()); }
{digito}                { System.out.println("Reconocio "+yytext()+" digito"); return new Symbol(Simbolos.digito, yycolumn, yyline, yytext()); }
{letra}                 { System.out.println("Reconocio LETRA "+yytext()); return new Symbol(Simbolos.letra, yycolumn, yyline, yytext()); }
{cadena}                { System.out.println("Reconocio CADENA "+yytext()); return new Symbol(Simbolos.cadena, yycolumn, yyline, yytext()); }
{flecha}                { System.out.println("Reconocio FLECHA "+yytext()); return new Symbol(Simbolos.flecha, yycolumn, yyline, yytext());}
{ascii}                 { System.out.println("Reconocio ASCII "+yytext()); return new Symbol(Simbolos.ascii, yycolumn, yyline, yytext());}
{escapado}              { System.out.println("Reconocio escapado "+yytext()); return new Symbol(Simbolos.escapado, yycolumn, yyline, yytext()); }

//----->Espacios
{comentariosimple}      {System.out.println("Se omitio el Comentario: "+yytext()); }
{comentarioMultilinea}  {System.out.println("Se omitio el Comentario multilinea: "+yytext()); }
[ \t\r\n\f\s]             {/* Espacios en blanco, se ignoran */}

//------> Errores Lexicos
.           { System.out.println("Error Lexico "+yytext()); }