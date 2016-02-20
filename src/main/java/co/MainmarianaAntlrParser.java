import org.antlr.v4.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.StringReader;
import java.io.IOException;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import java.lang.Object.*;
import java.util.*;
import org.antlr.v4.runtime.RecognitionException;
import co.edu.eafit.dis.st0270.p20151.mariana.pl0.parser.marianaAntlrParserParser;
import co.edu.eafit.dis.st0270.p20151.mariana.pl0.parser.marianaAntlrParserLexer;
import co.edu.eafit.dis.st0270.p20151.mariana.pl0.parser.marianaAntlrParserIDeclVarsVisitor;
import co.edu.eafit.dis.st0270.p20151.mariana.pl0.parser.marianaAntlrParserIUsedVarsVisitor;

public class MainmarianaAntlrParser {

	public static void main(String args[]) throws IOException {

		StringReader sr = new StringReader(args[0]);
		ANTLRInputStream ais = new ANTLRInputStream(sr);
                
		marianaAntlrParserLexer lexer = new marianaAntlrParserLexer(ais);
    		CommonTokenStream tokens = new CommonTokenStream(lexer);
                marianaAntlrParserParser parser = new marianaAntlrParserParser(tokens);


                System.out.println("***Ok***");

                marianaAntlrParserIDeclVarsVisitor decl =  new marianaAntlrParserIDeclVarsVisitor();
//                marianaAntlrParserIUsedVarsVisitor used =  new marianaAntlrParserIUsedVarsVisitor();

		ParseTree tree = parser.prog();

                decl.visit(tree);
//		used.visit(tree);

		
	if(args.length==0){
       		CharStream afs = null;	
       		 try {
	
        	    afs = new ANTLRInputStream(System.in);
       		 }
       		 catch (IOException ioe) {
       		System.err.println("error: "+ioe);
		System.exit(2);
		 }

         System.out.println("Fichero: Entrada Estandar");

	}

     for(int i=0;i<args.length;i++){

//	if(i!=0){
//	salir=false;
//	}

        CharStream afs = null;

		if(args[i].equals("-")){     

       			 try {

        	    	afs = new ANTLRInputStream(System.in);
       			 }
		       	 catch (IOException ioe) {
			System.err.println("error: " +ioe);
			System.exit(2);
       			}

         System.out.println("Fichero: Entrada Estandar");
	
	}else{


           try {
		afs =new ANTLRFileStream(args[i]);
	   }
	   catch (IOException ioe){
	   System.err.println("error: " + ioe);
	   System.exit(2);
	   }

	  System.out.println("Fichero: " + args[i]);

        }
}
}
}
