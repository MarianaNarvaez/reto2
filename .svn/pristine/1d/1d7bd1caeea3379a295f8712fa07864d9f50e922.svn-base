package co;
import  co.edu.eafit.dis.st0270.p20151.mariana.pl0.lexer.marianaJFlexLexer;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class MainmarianaJFlexLexer {

 static boolean estandar = false;
 static boolean imprimir = false;
 private static void usage(int errcode){
     System.exit(errcode);
   }  

   public static void main (String args[]){
      
        if(args.length < 1) {
          leerEntradaEstandar();
        }

       for (int i = 0; i < args.length; i++){
          if(args[i].equals("-")){
             leerEntradaEstandar();
          }else{
            boolean noEst = false;
             leerCadena(args[i], noEst);
          }
       }  

    
 }
     public static void leerEntradaEstandar(){
      imprimir = true;
      Scanner entrada = new Scanner(System.in);
      String  a  = "";    

      try{
          a=entrada.next();
      }catch(Exception e){
          System.exit(0);
      }
       try{
          for(; ;){
              a = a +"\n" + entrada.next();
          }
       }catch(Exception esd){
            boolean est = true; 
            leerCadena(a, est );
     }
}

  public static void leerCadena(String texto, boolean estandar){
    
 	 FileReader fis = null;
  	 try{
   		 if(!estandar){
      	        fis = new FileReader(texto);
          
                }
         }catch(FileNotFoundException fnfe){
    		 System.out.println(fnfe);
         	usage(2);
         }
    

   	try{    
                  marianaJFlexLexer lexer = null;
                if(estandar){
         	   lexer = new marianaJFlexLexer( new StringReader(texto));
         	}else{
                   lexer = new marianaJFlexLexer(fis);
                }
                   
                       if(imprimir){    
                       System.out.println( "fichero: Entrada Estandar");
                        imprimir = false;
                       }else{
                        System.out.println("fichero: " + texto);
                        
                       } 
                         int t = lexer.getNextToken();
                        
                	 while( t != lexer.YYEOF) {
                   	      if(getTokenName(t).equals("Identifier")){
                                  String id = lexer.yytext();
                                  if(id.length()  > 32){
                                   System.out.println ("Error: \"" + id +
                                                       "\" fila: " + lexer. getLine() +
                                                        " col: " + lexer. getColumn()
                                                       );
                                   break;
                                  }
                               
                               }
                               

                              if(getTokenName(t).equals("Integer")){
                                 try{
                                   String in = lexer.yytext();
                                   int num = Integer.parseInt(in);
                                 }catch(Exception es){
                                   System.out.println ("Error: \"" + lexer.yytext() +
                                                       "\" fila: " + lexer. getLine() +
                                                        " col: " + lexer. getColumn()
                                                       );
                                     break;
                                  }
                               } 
                   
                          if(lexer.fic){
                             break;
                           }                   
 
	                   System.out.println(
                                  "Tipo: " +   getTokenName(t) +
                                  " valor: \"" + lexer.yytext() +
                                  "\" Linea: " + lexer.getLine() +
                                  " Column: " + lexer.getColumn() 
                                   );
        	          t = lexer.getNextToken();
                	 }
                         
    	}catch(Exception e){
        System.exit(3);
    }
}

  public static String getTokenName(int t ){
     switch(t) {
        case 0:
          return "Keyword";
        case 1: 
          return "Identifier";
        case 2:
          return "Integer";
        case 3:
          return "Separator";
        case 4:
          return "Operator" ;
        default:
         return "NA ";
 
      }
   }
}
