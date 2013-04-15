/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mines;

import java.awt.Color;
import javalib.colors.*;
import java.util.Random;
import javalib.worldimages.*;

/**
 *
 * @author alpemberton
 */
public class Space {
    
    public static int SIZE = 22;
    public static int HALF_SIZE= SIZE/2;
    int col;
    int row;
    int num;
    boolean bomb;
    boolean clicked;
    
    public Space(int r, int c){
        col=c;
        row=r;
        num=0;
        bomb=false;
        clicked=false;
    }
    
    boolean hasBomb(){
        return bomb;
    }
    
    public String printNumBomb(){
        String myString="";
        if(this.hasBomb()){
            myString="B";
        }
        else{
            myString=""+this.num;
        }
        return myString;
    }
    
    WorldImage spaceImage() {
        if(this.clicked){
        Posn textposn = getPosn();
        TextImage image = new TextImage(textposn, this.printNumBomb(), Color.red);
        WorldImage myImage= new OverlayImages(
                new RectangleImage(this.getPosn(), SIZE, SIZE, Color.DARK_GRAY),
                new RectangleImage(this.getPosn(), SIZE - 2, SIZE - 2, Color.LIGHT_GRAY));
        myImage= new OverlayImages(myImage, image);
        return myImage;
    }
        else{
            WorldImage myImage2= new OverlayImages(
                new RectangleImage(this.getPosn(), SIZE, SIZE, Color.DARK_GRAY),
                new RectangleImage(this.getPosn(), SIZE - 2, SIZE - 2, Color.LIGHT_GRAY));
        return myImage2;
        }
    }
    
    public Posn getPosn() {
        int pinholeX = (this.col * Space.SIZE) + Space.HALF_SIZE;
        int pinholeY = (this.row * Space.SIZE) + Space.HALF_SIZE;
        return new Posn(pinholeX, pinholeY);
    }
}
