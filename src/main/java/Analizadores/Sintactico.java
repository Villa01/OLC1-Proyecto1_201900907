
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Analizadores;

import java_cup.runtime.Symbol;
import java.util.LinkedList;
import Estructuras.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Sintactico extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return Simbolos.class;
}

  /** Default constructor. */
  @Deprecated
  public Sintactico() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Sintactico(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Sintactico(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\042\000\002\002\004\000\002\002\005\000\002\007" +
    "\010\000\002\007\003\000\002\016\004\000\002\016\004" +
    "\000\002\016\003\000\002\016\003\000\002\004\010\000" +
    "\002\010\005\000\002\010\003\000\002\006\005\000\002" +
    "\006\003\000\002\013\003\000\002\013\003\000\002\013" +
    "\003\000\002\013\003\000\002\013\003\000\002\014\006" +
    "\000\002\014\003\000\002\012\005\000\002\012\005\000" +
    "\002\012\004\000\002\012\004\000\002\012\004\000\002" +
    "\012\005\000\002\012\003\000\002\011\003\000\002\011" +
    "\003\000\002\011\003\000\002\011\003\000\002\011\003" +
    "\000\002\003\007\000\002\003\006" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\101\000\004\022\005\001\002\000\004\002\103\001" +
    "\002\000\010\003\007\005\014\007\011\001\002\000\012" +
    "\003\036\004\ufffa\005\014\007\011\001\002\000\014\003" +
    "\uffee\004\uffee\005\uffee\007\uffee\023\ufffe\001\002\000\004" +
    "\004\070\001\002\000\004\010\040\001\002\000\012\003" +
    "\036\004\ufffb\005\014\007\011\001\002\000\004\023\035" +
    "\001\002\000\004\006\015\001\002\000\004\007\016\001" +
    "\002\000\004\010\017\001\002\000\014\013\021\014\022" +
    "\015\020\025\023\026\024\001\002\000\010\011\uffe4\012" +
    "\uffe4\024\uffe4\001\002\000\010\011\uffe6\012\uffe6\024\uffe6" +
    "\001\002\000\010\011\uffe5\012\uffe5\024\uffe5\001\002\000" +
    "\010\011\uffe3\012\uffe3\024\uffe3\001\002\000\010\011\uffe2" +
    "\012\uffe2\024\uffe2\001\002\000\010\011\ufff5\012\ufff5\024" +
    "\033\001\002\000\006\011\031\012\030\001\002\000\006" +
    "\011\ufff7\012\ufff7\001\002\000\014\013\021\014\022\015" +
    "\020\025\023\026\024\001\002\000\012\003\ufff9\004\ufff9" +
    "\005\ufff9\007\ufff9\001\002\000\006\011\ufff8\012\ufff8\001" +
    "\002\000\014\013\021\014\022\015\020\025\023\026\024" +
    "\001\002\000\006\011\ufff6\012\ufff6\001\002\000\004\002" +
    "\000\001\002\000\012\003\uffee\004\uffee\005\uffee\007\uffee" +
    "\001\002\000\004\004\ufffd\001\002\000\030\013\051\014" +
    "\044\015\055\016\053\017\045\020\050\021\054\022\041" +
    "\025\043\026\042\027\052\001\002\000\004\007\066\001" +
    "\002\000\032\011\ufff0\013\ufff0\014\ufff0\015\ufff0\016\ufff0" +
    "\017\ufff0\020\ufff0\021\ufff0\022\ufff0\025\ufff0\026\ufff0\027" +
    "\ufff0\001\002\000\032\011\ufff1\013\ufff1\014\ufff1\015\ufff1" +
    "\016\ufff1\017\ufff1\020\ufff1\021\ufff1\022\ufff1\025\ufff1\026" +
    "\ufff1\027\ufff1\001\002\000\032\011\ufff3\013\ufff3\014\ufff3" +
    "\015\ufff3\016\ufff3\017\ufff3\020\ufff3\021\ufff3\022\ufff3\025" +
    "\ufff3\026\ufff3\027\ufff3\001\002\000\030\013\051\014\044" +
    "\015\055\016\053\017\045\020\050\021\054\022\041\025" +
    "\043\026\042\027\052\001\002\000\004\011\063\001\002" +
    "\000\032\011\uffe7\013\uffe7\014\uffe7\015\uffe7\016\uffe7\017" +
    "\uffe7\020\uffe7\021\uffe7\022\uffe7\025\uffe7\026\uffe7\027\uffe7" +
    "\001\002\000\030\013\051\014\044\015\055\016\053\017" +
    "\045\020\050\021\054\022\041\025\043\026\042\027\052" +
    "\001\002\000\032\011\ufff4\013\ufff4\014\ufff4\015\ufff4\016" +
    "\ufff4\017\ufff4\020\ufff4\021\ufff4\022\ufff4\025\ufff4\026\ufff4" +
    "\027\ufff4\001\002\000\030\013\051\014\044\015\055\016" +
    "\053\017\045\020\050\021\054\022\041\025\043\026\042" +
    "\027\052\001\002\000\030\013\051\014\044\015\055\016" +
    "\053\017\045\020\050\021\054\022\041\025\043\026\042" +
    "\027\052\001\002\000\030\013\051\014\044\015\055\016" +
    "\053\017\045\020\050\021\054\022\041\025\043\026\042" +
    "\027\052\001\002\000\032\011\ufff2\013\ufff2\014\ufff2\015" +
    "\ufff2\016\ufff2\017\ufff2\020\ufff2\021\ufff2\022\ufff2\025\ufff2" +
    "\026\ufff2\027\ufff2\001\002\000\032\011\uffea\013\uffea\014" +
    "\uffea\015\uffea\016\uffea\017\uffea\020\uffea\021\uffea\022\uffea" +
    "\025\uffea\026\uffea\027\uffea\001\002\000\030\013\051\014" +
    "\044\015\055\016\053\017\045\020\050\021\054\022\041" +
    "\025\043\026\042\027\052\001\002\000\032\011\uffed\013" +
    "\uffed\014\uffed\015\uffed\016\uffed\017\uffed\020\uffed\021\uffed" +
    "\022\uffed\025\uffed\026\uffed\027\uffed\001\002\000\032\011" +
    "\uffe9\013\uffe9\014\uffe9\015\uffe9\016\uffe9\017\uffe9\020\uffe9" +
    "\021\uffe9\022\uffe9\025\uffe9\026\uffe9\027\uffe9\001\002\000" +
    "\032\011\uffeb\013\uffeb\014\uffeb\015\uffeb\016\uffeb\017\uffeb" +
    "\020\uffeb\021\uffeb\022\uffeb\025\uffeb\026\uffeb\027\uffeb\001" +
    "\002\000\012\003\uffef\004\uffef\005\uffef\007\uffef\001\002" +
    "\000\030\013\051\014\044\015\055\016\053\017\045\020" +
    "\050\021\054\022\041\025\043\026\042\027\052\001\002" +
    "\000\032\011\uffec\013\uffec\014\uffec\015\uffec\016\uffec\017" +
    "\uffec\020\uffec\021\uffec\022\uffec\025\uffec\026\uffec\027\uffec" +
    "\001\002\000\004\023\067\001\002\000\032\011\uffe8\013" +
    "\uffe8\014\uffe8\015\uffe8\016\uffe8\017\uffe8\020\uffe8\021\uffe8" +
    "\022\uffe8\025\uffe8\026\uffe8\027\uffe8\001\002\000\004\004" +
    "\071\001\002\000\004\004\072\001\002\000\004\004\073" +
    "\001\002\000\004\007\075\001\002\000\004\023\uffff\001" +
    "\002\000\004\006\076\001\002\000\004\025\077\001\002" +
    "\000\004\011\100\001\002\000\006\007\075\023\uffe0\001" +
    "\002\000\004\023\uffe1\001\002\000\004\004\ufffc\001\002" +
    "\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\101\000\004\002\003\001\001\000\002\001\001\000" +
    "\012\004\011\007\012\014\005\016\007\001\001\000\010" +
    "\004\011\014\005\016\101\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\010\004\011\014\005" +
    "\016\036\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\010\006\026\010\025" +
    "\011\024\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\011" +
    "\031\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\011\033\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\006\012\045\013\046" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\006\012\063\013\046\001\001" +
    "\000\002\001\001\000\002\001\001\000\006\012\061\013" +
    "\046\001\001\000\002\001\001\000\006\012\060\013\046" +
    "\001\001\000\006\012\056\013\046\001\001\000\006\012" +
    "\055\013\046\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\012\057\013\046\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\006" +
    "\012\064\013\046\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\003\073\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\003\100\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Sintactico$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Sintactico$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Sintactico$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public String resultado = "";
    public static Nodo raiz;
    public int numHojas = 1;
    public LinkedList<ExpresionRegular> expresiones = new LinkedList<ExpresionRegular>();
    public Nodo getRaiz(){ return raiz;}
    public LinkedList<ExpresionRegular> getExpresiones(){return expresiones;}


    public void syntax_error(Symbol s)
    {
        System.err.println("Error en la Linea " + (s.right+1) +" Columna "+(s.left+1)+ ". Identificador "+s.value + " no reconocido. Se ha recuperado del error." );
        //error nuevo = new error("Error Sintactico (Recuperado)", s.value.toString(), s.right+1, s.left+1);
        //Ventana.listaErrores.add(nuevo);
    }
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception
    {
        System.err.println("Error en la Linea " + (s.right+1)+ " Columna "+(s.left+1)+". Identificador " +s.value + " no reconocido.");
        //error nuevo = new error("Error Sintactico", s.value.toString(), s.right+1, s.left+1);
        //Ventana.listaErrores.add(nuevo);
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Sintactico$actions {

  
  private final Sintactico parser;

  /** Constructor */
  CUP$Sintactico$actions(Sintactico parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Sintactico$do_action_part00000000(
    int                        CUP$Sintactico$act_num,
    java_cup.runtime.lr_parser CUP$Sintactico$parser,
    java.util.Stack            CUP$Sintactico$stack,
    int                        CUP$Sintactico$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Sintactico$result;

      /* select the action based on the action number */
      switch (CUP$Sintactico$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= S EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		String start_val = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		RESULT = start_val;
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Sintactico$parser.done_parsing();
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // S ::= llava CUERPO llavc 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		  
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("S",0, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // CUERPO ::= ENCABEZADO porc porc porc porc VALID 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-5)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-5)).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-5)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("CUERPO",5, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-5)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // CUERPO ::= error 
            {
              String RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("CUERPO",5, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // ENCABEZADO ::= CONJUNTO ENCABEZADO 
            {
              Object RESULT =null;
		  
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("ENCABEZADO",12, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // ENCABEZADO ::= EXPR ENCABEZADO 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		ExpresionRegular a = (ExpresionRegular)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Object b = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = b; parser.expresiones.add(a); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("ENCABEZADO",12, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // ENCABEZADO ::= CONJUNTO 
            {
              Object RESULT =null;
		  
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("ENCABEZADO",12, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // ENCABEZADO ::= EXPR 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		ExpresionRegular a = (ExpresionRegular)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 parser.expresiones.add(a); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("ENCABEZADO",12, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // CONJUNTO ::= conj dospuntos id flecha CONJ ptycoma 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		  
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("CONJUNTO",2, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-5)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // CONJ ::= CONJ coma SIMBCONJ 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		  
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("CONJ",6, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // CONJ ::= LISTASIMB 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		  
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("CONJ",6, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // LISTASIMB ::= SIMBCONJ guion SIMBCONJ 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		  
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("LISTASIMB",4, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // LISTASIMB ::= SIMBCONJ 
            {
              String RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		  
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("LISTASIMB",4, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // SIMB ::= letra 
            {
              Nodo RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Hoja( parser.numHojas, a.toString(), "" , false, null, null); parser.numHojas++;  
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("SIMB",9, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // SIMB ::= digito 
            {
              Nodo RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Hoja( parser.numHojas, a.toString(), "" , false, null, null); parser.numHojas++;  
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("SIMB",9, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // SIMB ::= ascii 
            {
              Nodo RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Hoja( parser.numHojas, a.toString(), "" , false, null, null); parser.numHojas++;  
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("SIMB",9, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // SIMB ::= cadena 
            {
              Nodo RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Hoja( parser.numHojas, a.toString(), "" , false, null, null); parser.numHojas++;  
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("SIMB",9, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // SIMB ::= escapado 
            {
              Nodo RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Hoja( parser.numHojas, "\\\\" + a.toString(), "" , false, null, null); parser.numHojas++; 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("SIMB",9, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // EXPR ::= id flecha ER ptycoma 
            {
              ExpresionRegular RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Nodo a = (Nodo)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		
                                                        RESULT = new ExpresionRegular(new ArbolSintactico(a), a.toString()); parser.numHojas = 1;
                                                      
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("EXPR",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // EXPR ::= error 
            {
              ExpresionRegular RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("EXPR",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // ER ::= conc ER ER 
            {
              Nodo RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Nodo a = (Nodo)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Nodo b = (Nodo)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Nodo( ".", "",false, a, b ); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("ER",8, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // ER ::= or ER ER 
            {
              Nodo RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Nodo a = (Nodo)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Nodo b = (Nodo)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Nodo( "|", "",false, a, b ); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("ER",8, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // ER ::= kleen ER 
            {
              Nodo RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Nodo a = (Nodo)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Nodo( "*", "",false, a, null ); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("ER",8, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // ER ::= mas ER 
            {
              Nodo RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Nodo a = (Nodo)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Nodo( "+", "",false, a, null ); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("ER",8, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // ER ::= interrogacion ER 
            {
              Nodo RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Nodo a = (Nodo)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Nodo( "?", "",false, a, null ); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("ER",8, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // ER ::= llava id llavc 
            {
              Nodo RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		 RESULT = new Hoja( parser.numHojas, a.toString(), "", false, null, null); parser.numHojas++; 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("ER",8, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // ER ::= SIMB 
            {
              Nodo RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Nodo a = (Nodo)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = a; 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("ER",8, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // SIMBCONJ ::= letra 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		   
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("SIMBCONJ",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // SIMBCONJ ::= digito 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		   
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("SIMBCONJ",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // SIMBCONJ ::= ascii 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		   
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("SIMBCONJ",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // SIMBCONJ ::= cadena 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		   
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("SIMBCONJ",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // SIMBCONJ ::= escapado 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		   
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("SIMBCONJ",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // VALID ::= id dospuntos cadena ptycoma VALID 
            {
              String RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("VALID",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-4)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // VALID ::= id dospuntos cadena ptycoma 
            {
              String RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("VALID",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Sintactico$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Sintactico$do_action(
    int                        CUP$Sintactico$act_num,
    java_cup.runtime.lr_parser CUP$Sintactico$parser,
    java.util.Stack            CUP$Sintactico$stack,
    int                        CUP$Sintactico$top)
    throws java.lang.Exception
    {
              return CUP$Sintactico$do_action_part00000000(
                               CUP$Sintactico$act_num,
                               CUP$Sintactico$parser,
                               CUP$Sintactico$stack,
                               CUP$Sintactico$top);
    }
}

}
