import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

import edu.ship.SimpleGraphics.*;


/**
 * @author Travis Fitzsimmons
 *
 */
public class firstday
{
	static final int MAX_VALUE = 25;
	static final int MIN_VALUE = 1;
	static final int NUMBER_OF_VALUES = (MAX_VALUE - MIN_VALUE + 1);
	private static int x = 0;
	private static int y = 0;
	
        /**
         * @param args
         * @throws InterruptedException 
         */
        public static void main (String args[]) throws InterruptedException
        {

                
                
                Smiley s = new Smiley();
             
        		int[][] HoldValues = new int[5][5];
        		Random R = new Random();
        		for(int i = 0; i < 5; i++ )
        		{
        			for(int j = 0;  j < 5; j++)
        			{
        				HoldValues[i][j] = R.nextInt(200);
        			}
        			
        		}
        		{
                s.draw(HoldValues[R.nextInt(4)][R.nextInt(4)],HoldValues[R.nextInt(4)][R.nextInt(4)]);
            
        		}
                }
                
        
       
}
