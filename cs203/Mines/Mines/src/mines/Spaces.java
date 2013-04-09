/*
 * CS203
 * Spring 2013
 * Max Morris
 * <Assignment>
 */

package mines;

import java.util.ArrayList;
import java.util.List;
import javalib.worldimages.OverlayImages;
import javalib.worldimages.WorldImage;

public class Spaces {
    
    Space[][] spaces;
    
    public Spaces(int x, int y) {
        this.spaces = new Space[x][y];
        for (int i=0; i<x; i++) {
            for (int j=0; j<y; j++) {
                spaces[i][j] = new Space(i,j);
            }
        }
    }
    
    public WorldImage spacesImage(WorldImage background) {
        for (int i=0; i<spaces[0].length; i++) {
            for (int j=0; j<spaces.length; j++) {
            background = new OverlayImages(background, spaces[j][i].spaceImage());
            }
        }
        return background;
    }

}
