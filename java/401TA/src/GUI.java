import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class GUI {
	public static void main(String[]fsdafseew){
		JFrame frame = new JFrame("Example");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pane = new JPanel();
		final JTextField textbox = new JTextField(9);
		JLabel label = new JLabel("Song File:");
		JButton button = new JButton("Click Me to Do something");
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(textbox.getText());
				assignment7.main([textbox.getText()]);
			}
			
		});
		pane.add(label);
		pane.add(textbox);
		pane.add(button);
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.add(pane);
		frame.pack();
	}
}
