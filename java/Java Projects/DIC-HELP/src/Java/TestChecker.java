package Java;

import java.awt.*;
import javax.swing.*;
public class TestChecker {
	
	
public static void main(String args[])
{
    JFrame chess=new JFrame("The Checker board for chess game");
    Checker c=new Checker();
    

    c.setBackground(Color.WHITE);
   chess.add(c);
   chess.pack();
    chess.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    chess.setVisible(true);
}
}