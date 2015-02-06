package org.ttair.app;

import java.io.File;

import org.ttair.util.GraphViz;

public class Proba
{
   public static void main(String[] args)
   {
      Proba p = new Proba();
      p.start();
      p.start2();
   }

   /**
    * Construct a DOT graph in memory, convert it
    * to image and store the image in the file system.
    */
   private void start()
   {
      GraphViz gv = new GraphViz();
      gv.addln(gv.start_digraph("G"));
      gv.addln("A -> B;");
      gv.addln("A -> C;");
      gv.addln(gv.end_digraph());
      System.out.println(gv.getDotSource());
      
      String type = "png";

      File out = new File("./temp/Teste." + type);   

      gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
   }
   
   /**
    * Read the DOT source from a file,
    * convert to image and store the image in the file system.
    */
   private void start2()
   {
      String dir = "./temp";     // Linux
      String input = dir + "/BehaviorTTAir_NEWLAYOUT.dot";
	   
	   GraphViz gv = new GraphViz();
	   gv.readSource(input);
	   System.out.println(gv.getDotSource());
   		
      String type = "png";
//    String type = "dot";
//    String type = "fig";    // open with xfig
//    String type = "pdf";
//    String type = "ps";
//    String type = "svg";    // open with inkscape
//    String type = "png";
//      String type = "plain";
	   File out = new File(dir + "/behaviorTTair." + type);  
	   gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
   }
}
