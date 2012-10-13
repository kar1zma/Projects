import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class assignment7 {
	final static int SAMPLESPERSECOND = 44100;
	public static void main(String[] args) throws FileNotFoundException {
		JFrame fr = new JFrame();
		fr.setSize(new Dimension(400,400));
		JPanel pane = new JPanel();
		JButton but = new JButton("CLICK ME");
		final JTextField text = new JTextField(20);

		but.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				String fileName = text.getText();
				Scanner reader;
				try {
					reader = new Scanner(new File(fileName));
					while(reader.hasNext()){
						int i = reader.nextInt();
						double time = reader.nextDouble();
						double frequency = createFrequency(i);
						playNote(frequency,time);
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			}
			
		});
		JLabel label = new JLabel("AHHHH:");
		pane.setLayout(new FlowLayout());
		pane.add(label);
		pane.add(text);
		pane.add(but);
		fr.add(pane);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	public static double[] playNote(double freq, double time){
		 int numberOfSamples = (int) (SAMPLESPERSECOND * time);
         
         double[] sound = new double[numberOfSamples]; 
         
         for(int i=0; i<numberOfSamples; i++)
            sound[i] = Math.sin(2 * Math.PI * freq* i / SAMPLESPERSECOND);
         
         StdAudio.play(sound);

		return null;
	}
	public static double createFrequency(int i){
		return (440.0*(Math.pow(2, (i/12.0))));
	}

}
