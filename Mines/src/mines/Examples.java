/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mines;

/**
 *
 * @author alpemberton
 */
public class Examples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mines m =
                new Mines();
        m.layBombs();
        m.bigBang(Mines.MAX_COLS * Space.SIZE,
                Mines.MAX_ROWS * Space.SIZE,
                0.5);
    }
}
