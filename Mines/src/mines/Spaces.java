/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mines;

import java.util.*;
import javalib.worldimages.OverlayImages;
import javalib.worldimages.WorldImage;

/**
 *
 * @author alpemberton
 */
public class Spaces {
    
    Space[][] spaces;
    
    public Spaces(int numRows, int numCols){
        spaces = new Space[numRows][numCols];
        for(int x=0; x<numRows; x++){
            for(int y=0; y<numCols; y++){
                spaces[x][y] = new Space(x,y);
                
            }
        }        
    }
    
    public void incrementSurroundings(int r, int c){
        if(c-1>-1){
            if(r-1>-1){
                spaces[r-1][c-1].num++;
                spaces[r][c-1].num++;
            }
            if(r+1<Mines.MAX_ROWS){
                spaces[r+1][c-1].num++;
            }
        }
        if(r-1>-1){
            spaces[r-1][c].num++;
        }
        if(r+1<Mines.MAX_ROWS){
            spaces[r+1][c].num++;
        }
        if(c+1<Mines.MAX_COLS){
            if(r-1>-1){
                spaces[r-1][c+1].num++;
                spaces[r][c+1].num++;
            }
            if(r+1<Mines.MAX_ROWS){
                spaces[r+1][c+1].num++;
            }
        }
        
        
    }
    
    public WorldImage spacesImage(WorldImage background){
        for(int x=0; x<Mines.MAX_ROWS; x++){
            for(int y=0; y<Mines.MAX_COLS; y++){
                background = new OverlayImages(background, spaces[x][y].spaceImage());
                
            }
        }
        return background;
    }
}

