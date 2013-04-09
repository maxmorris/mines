/*
 * CS203
 * Spring 2013
 * Max Morris
 * Midterm Tetris Project
 */

package mines;

import javalib.colors.*;
import java.util.Random;
import java.util.Arrays;
import java.util.List;
      
/**
 * Generates a random block color of either red, yellow, blue, or red.
 * @author maxmorris
 */
public class RandomColor {
    private static Random rand = new Random();
    private static List<IColor> colors = 
            Arrays.asList(new Red(), new Yellow(), new Blue(), new Green());
    public static IColor randomColor() {
        return colors.get(rand.nextInt(colors.size()));
    }
}