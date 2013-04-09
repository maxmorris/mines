/*
 * CS203
 * Spring 2013
 * Max Morris
 * <Assignment>
 */

package mines;

import java.awt.Color;
import tester.*;
import javalib.colors.*;
import javalib.worldcanvas.*;
import javalib.worldimages.OverlayImages;
import javalib.worldimages.Posn;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldEnd;

public class Examples {
    
    public static void main(String[] argv) {
        Examples be = new Examples();
        Tester.runReport(be, false, false);
        
        Mines w = new Mines();
        w.bigBang(Mines.MAX_COLS*Space.SIZE,
                Mines.MAX_ROWS*Space.SIZE, 0.5);
    }

}
