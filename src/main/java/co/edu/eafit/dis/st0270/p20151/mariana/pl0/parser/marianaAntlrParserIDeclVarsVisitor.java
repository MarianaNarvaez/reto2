package co.edu.eafit.dis.st0270.p20151.mariana.pl0.parser;

import java.util.HashSet;
import org.antlr.v4.runtime.tree.TerminalNode;
import co.edu.eafit.dis.st0270.p20151.mariana.pl0.parser.marianaAntlrParserParser.*;


public class marianaAntlrParserIDeclVarsVisitor extends marianaAntlrParserBaseVisitor 
{
     boolean glo = true, com=false;
     marianaAntlrParserParser.ProgEvalContext prog;
     HashSet<String> variables = new HashSet<String>();
     HashSet<String> glob  = new HashSet<String>();
//     variables.add(lo que voy a agregar); 

     public Integer visitProgEval(marianaAntlrParserParser.ProgEvalContext ctx) {
          System.out.println("***Decl Vars***");	
          System.out.println("***global***");
          System.out.println("***OK***");
          prog = ctx;
          visit(ctx.block());
          return 0;
     }

     public Integer visitBlockEval(marianaAntlrParserParser.BlockEvalContext ctx) { 
          if(ctx.defvar() != null) visit(ctx.defvar());
          for(DefprocContext dp: ctx.defproc()) visit(dp);
          if(ctx.defvar() != null) visit(ctx.instruction());          
          return 0;
     }
     public Integer visitDefvarEval(marianaAntlrParserParser.DefvarEvalContext ctx) {
          HashSet hid = new HashSet();

          for(TerminalNode var:ctx.IDENTIFIER()){

          variables.add(var.toString());
               if(glo){
                  glob.add(var.toString());
                }
          
               if(com && glob.contains(var.toString())){
                   hid.add(var.toString());

               }
           }
	
           System.out.println("vars: " + variables + "");
           variables.clear();
           System.out.print("hidings: " + hid+".");
           glo = false;

          return 0;
     }

     public Integer  visitDefprocEval(marianaAntlrParserParser.DefprocEvalContext ctx) {

           if(glo){ glo=false;}
           com=true;
           System.out.println("***"+ctx.IDENTIFIER().toString()+"***");
          visit(ctx.block());
          return 0;
     }
    
 
      public Integer visitBeginEval(marianaAntlrParserParser.BeginEvalContext ctx) { 

         if(ctx.getParent().getParent().equals(prog))
           System.out.println("***main***\nvar: []. \nhidings: []. ");
         return 0;
 }
}	   
