package Java;

import java.awt.*;
import java.awt.Graphics.*;
import java.awt.event.*;
import javax.swing.*;
public class Checker extends javax.swing.JPanel {
    private int Xpos,Ypos;
     String position;


    /** Creates new form Checker */
    public Checker() {

        this.setPreferredSize(new Dimension(400,400));
        int w=getWidth();
        int h=getHeight();
        final int stepx=w/8;
        final int stepy=h/8;
        addMouseListener(
                new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me)
            {


           int x=me.getX();
           int y=me.getY();
           if(x>0&&x<stepx)
               Xpos=0;
           else if(x>stepx&&x<(2*stepx))
               Xpos=1;
           else if(x>(2*stepx)&&x<(3*stepx))
               Xpos=2;
          else if(x>(3*stepx)&&x<(4*stepx))
               Xpos=3;
          else if(x>(4*stepx)&&x<(5*stepx))
               Xpos=4;
           else if(x>(5*stepx)&&x<(6*stepx))
               Xpos=5;
           else if(x>(6*stepx)&&x<(7*stepx))
               Xpos=6;
           else if(x>(7*stepx)&&x<(8*stepx))
                Xpos=7;
           else Xpos=10000;
           if(y>0&&y<=stepy)
               Ypos=0;
           else if(y>stepy&&y<(2*stepy))
               Ypos=1;
           else if(y>(2*stepy)&&y<(3*stepy))
               Ypos=2;
           else if(y>(3*stepy)&&y<(4*stepy))
               Ypos=3;
           else if(y>(4*stepy)&&y<(5*stepy))
               Ypos=4;
           else if(y>(5*stepy)&&y<(6*stepy))
               Ypos=5;
           else if(y>(6*stepy)&&y<(7*stepy))
               Ypos=6;
           else if(y>(7*stepy)&&y<(8*stepy))
                Ypos=7;
           else Ypos=10000;
           position="You are in square ["+Xpos+","+Ypos+"]"+"with coordinates"+x+","+y;
           JOptionPane.showMessageDialog(null,position);



        }
        } );



    }
public void paintComponent(Graphics g)
{
    super.paintComponent(g);
  
    int divx=50;
        int divy=50;

    g.setColor(Color.RED);
    for(int i=0;i<8;i=i+2)
        for(int j=0;j<8;j=j+2)
        {
            g.fillRect(j*divx,i*divy,divx,divy);
            g.fillRect((1+j)*divx,(1+i)*divy,divx,divy);
        }
    

}
}