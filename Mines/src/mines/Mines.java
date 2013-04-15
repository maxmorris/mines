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
import java.awt.event.*;
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
    public static int NUM_BOMBS = 99;
    
    public Mines() {
        super();
        board=new Spaces(MAX_ROWS, MAX_COLS);
        
    }
    
    
    
    public void onMouseClicked(Posn p){
        
        int c = (p.x/Space.SIZE);
        int r = (p.y/Space.SIZE);
        this.board.spaces[r][c].clicked=true;
        if(this.board.spaces[r][c].num==0){
            if(c-1>-1){
            if(r-1>-1){
                if(!this.board.spaces[r-1][c-1].clicked){
                this.onMouseClicked(this.board.spaces[r-1][c-1].getPosn());}
                if(!this.board.spaces[r][c-1].clicked){
                    this.onMouseClicked(this.board.spaces[r][c-1].getPosn());
                }
            }
            if(r+1<Mines.MAX_ROWS){
                if(!this.board.spaces[r+1][c-1].clicked){
                    this.onMouseClicked(this.board.spaces[r+1][c-1].getPosn());
                }
            }
        }
        if(r-1>-1){
            if(!this.board.spaces[r-1][c].clicked){
                this.onMouseClicked(this.board.spaces[r-1][c].getPosn());
            }
        }
        if(r+1<Mines.MAX_ROWS){
            if(!this.board.spaces[r+1][c].clicked){
                this.onMouseClicked(this.board.spaces[r+1][c].getPosn());
            }
        }
        if(c+1<Mines.MAX_COLS){
            if(r-1>-1){
                if(!this.board.spaces[r-1][c+1].clicked){
                    this.onMouseClicked(this.board.spaces[r-1][c+1].getPosn());
                }
                if(!this.board.spaces[r][c+1].clicked){
                    this.onMouseClicked(this.board.spaces[r][c+1].getPosn());
                }
            }
            if(r+1<Mines.MAX_ROWS){
                if(!this.board.spaces[r+1][c+1].clicked){
                    this.onMouseClicked(this.board.spaces[r+1][c+1].getPosn());
                }
            }
        }
            
//        if(!this.board.spaces[row-1][col-1].bomb){
//            onMouseClicked(this.board.spaces[row-1][col-1].getPosn());
//        }
//        if(!this.board.spaces[row-1][col].bomb){
//            onMouseClicked(this.board.spaces[row-1][col].getPosn());
//        }
//        if(!this.board.spaces[row-1][col+1].bomb){
//            onMouseClicked(this.board.spaces[row-1][col+1].getPosn());
//        }
//        if(!this.board.spaces[row][col-1].bomb){
//            onMouseClicked(this.board.spaces[row][col-1].getPosn());
//        }
//        if(!this.board.spaces[row][col+1].bomb){
//            onMouseClicked(this.board.spaces[row][col+1].getPosn());
//        }
//        if(!this.board.spaces[row+1][col-1].bomb){
//            onMouseClicked(this.board.spaces[row+1][col-1].getPosn());
//        }
//        if(!this.board.spaces[row+1][col].bomb){
//            onMouseClicked(this.board.spaces[row+1][col].getPosn());
//        }
//        if(!this.board.spaces[row+1][col+1].bomb){
//            onMouseClicked(this.board.spaces[row+1][col+1].getPosn());
//        }
        }
        this.makeImage();
        
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
                board.spaces[x][y].num=10;
                board.incrementSurroundings(x,y);
            }
            
        }
    }
    
    /**
     * Create a background field to build the images upon
     */
    public WorldImage background =
            new RectangleImage(new Posn(this.width / 2, this.height / 2),
            this.width, this.height, Color.MAGENTA);
    
     public WorldImage makeImage() {
        WorldImage worldImage = this.board.spacesImage(this.background);
        return worldImage;

    }
     public static Examples examplesInstance = new Examples();
    
}


