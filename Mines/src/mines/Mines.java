/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mines;


import java.awt.Color;
import javalib.colors.*;
import javalib.impworld.*;
import javalib.worldimages.*;
import java.util.Random;
/**
 *
 * @author alpemberton
 */
public class Mines extends World{
    public static int MAX_COLS = 30;
    public static int MAX_ROWS = 16;
    int width = Mines.MAX_COLS * Space.SIZE;
    int height = Mines.MAX_ROWS * Space.SIZE;
    Spaces board;
    public static int NUM_BOMBS = 50;
    
    public Mines() {
        super();
        board=new Spaces(MAX_ROWS, MAX_COLS);
        
    }
    
    public void layBombs(){
        Random myRandom = new Random();
        for(int i=0; i<NUM_BOMBS; i++){
            int x = myRandom.nextInt(MAX_ROWS);
            int y = myRandom.nextInt(MAX_COLS);
            if(board.spaces[x][y].hasBomb()){
                i--;
            }
            else{
                board.spaces[x][y].bomb=true;
                board.incrementSurroundings(x,y);
            }
            
        }
    }
    
    /**
     * Create a background field to build the images upon
     */
    public WorldImage background =
            new RectangleImage(new Posn(this.width / 2, this.height / 2),
            this.width, this.height, Color.LIGHT_GRAY);
    
     public WorldImage makeImage() {
        WorldImage worldImage = this.board.spacesImage(this.background);
        return worldImage;

    }
     public static Examples examplesInstance = new Examples();
    
}


