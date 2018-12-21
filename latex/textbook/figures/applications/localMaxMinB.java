                  /*  File: localMaxMinB.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class localMaxMinB extends Template {

     static {templateClass = new localMaxMinB() ; }

     public void setup() {
          filePrefix = "localMaxMinB" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;   
          ysize = 2.0 ;   
          xmin = -1.2 ;
          xmax = 1.2 ;
          ymin = -1.2 ;
          ymax = 1.2 ;
          topmargin = 0.1 ;
          bottommargin = 0.1 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fTeXlabel(xmax, -0.04, "tc", "$x$", "x") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$", "y") ;
          
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fLine(1.0, 0,  1.0, -0.08) ;
          fTeXlabel(1.0, -0.12, "tc",  "$1$") ;
          fLine(-1.0, 0,  -1.0, -0.08) ;
          fTeXlabel(-1.0, -0.12, "tc",  "$-1$") ;

          fEnv("lineWidth", 1.0) ;
          fCurve("y=x*x*x", 0, -1, 1, OPEN) ;
          double x = 1 ; double y = x*x*x ;
          fTeXlabel(x+0.1, y, "tl", "$y=f(x)=x^3$") ;

          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;
          double aspect = (ymax-ymin)*xsize/(xmax-xmin)/ysize ;
          double r = 0.04 ;
          x = 0 ; y = x*x*x ;
          fDisk(x,y, r,r*aspect, FILLED) ;
          fTeXlabel(x+0.02,y-0.07, "tl", "$\\big(c, f(c)\\big)$") ;



     }
}
