/*
 * CS203
 * Spring 2013
 * Max Morris
 * <Assignment>
 */

package mines;

import java.util.Random;
import javalib.colors.*;
import javalib.worldimages.*;
import java.util.*;
import java.awt.Color;
import javalib.colors.*;


public class Space {
    /**
     * Size of the Block in pixels
     */
    public static int SIZE=40;
    /**
     * Size of half of the Block in pixels
     */
    public static int HALF_SIZE=SIZE/2;
    /**
     * random number generator to specify block starting column.
     */
    public static Random COL_GEN = new Random();
    
    //Class Fields
    int col;
    int row;
    Color color;
    boolean bomb;
    boolean flag;
    boolean view;
    int proximity;

    /**
     * Empty Constructor for Block class.
     * Creates a Block in a random column of row 0 with a randomly generated
     * color of either red, blue, green, or yellow.
     */
    public Space(int x, int y) {
        this.col=y;
        this.row=x;
//        this.color = RandomColor.randomColor();
        this.color = Color.LIGHT_GRAY;
        this.bomb = false;
        this.flag = false;
        this.view = false;
        this.proximity = 0;
    }
    
    public Space (int col, int row, IColor color,
            boolean bomb, int proximity) {
        this.col = col;
        this.row=row;
        this.color=Color.LIGHT_GRAY;
        this.bomb=false;
        this.flag = false;
        this.view = false;
        this.proximity=proximity;
    }
    
    public WorldImage spaceImage(){
	return new OverlayImages(
                new RectangleImage(this.getPosn(), Space.SIZE, Space.SIZE, new Black()),
                new RectangleImage(this.getPosn(), Space.SIZE-4, Space.SIZE-4, this.color));	
	}
    
    public Posn getPosn(){
        int pinholeX = (this.col * Space.SIZE) + Space.HALF_SIZE;
        int pinholeY = (this.row * Space.SIZE) + Space.HALF_SIZE;
        return new Posn(pinholeX, pinholeY);
    }

}
