/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mines;

import javalib.colors.White;
import javalib.impworld.World;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.WorldImage;
import java.util.Random;


/**
 *
 * @author maxmorris
 */
public class Mines extends World {

    //Class constants
    public static int MAX_COLS=20;
    public static int MAX_ROWS=20;
    
    //Class fields
    Spaces board;
    int width =MAX_COLS*Space.SIZE;
    int height = MAX_ROWS*Space.SIZE;
    int Mines=(MAX_COLS*MAX_ROWS)/10;

    WorldImage background =
            new RectangleImage(new Posn(this.width/2, this.height/2),
                                this.width, this.height, new White());
    
    public Mines() {
        super();
        board = new Spaces(MAX_ROWS, MAX_COLS);
        layBombs();
    }
    
    public void layBombs () {
        int bombs_to_lay = Mines;
        Random rand = new Random();
        int prevY=0, prevX=0;
        while (Mines >0) {
            int nextX = rand.nextInt(MAX_COLS);
            if (nextX != prevX) {nextX = prevX;}
            int nextY = rand.nextInt(MAX_ROWS);
            if (nextY != prevY) {nextY = prevY;}
            if (board.spaces[nextX][nextY].bomb = false) {
                board.spaces[nextX][nextY].bomb = true;
                Mines--;
                if (nextX-1>0 && nextY-1>0) {board.spaces[nextX-1][nextY-1].proximity++;}
                if (nextX-1>0 && nextY+1<MAX_ROWS) {board.spaces[nextX-1][nextY+1].proximity++;}
                if (nextX-1>0) {board.spaces[nextX-1][nextY].proximity++;}
                if (nextY-1>0) {board.spaces[nextX][nextY-1].proximity++;}
                if (nextY+1<MAX_ROWS) {board.spaces[nextX][nextY+1].proximity++;}
                if (nextX+1<MAX_COLS && nextY-1>0) {board.spaces[nextX+1][nextY-1].proximity++;}
                if (nextX+1<MAX_COLS && nextY+1<MAX_ROWS) {board.spaces[nextX+1][nextY+1].proximity++;}
                if (nextX+1<MAX_COLS) {board.spaces[nextX+1][nextY].proximity++;}
            }
        }
    }
    
    public WorldImage makeImage() {
        WorldImage worldImage = this.board.spacesImage(this.background);
        return worldImage;
    }
        
        
    
    public static Examples examplesInstance = new Examples();
}
