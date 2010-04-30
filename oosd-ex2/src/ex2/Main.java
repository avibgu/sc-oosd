package ex2;

import javax.swing.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame tFrame = new JFrame("Feeds Reader");
		tFrame.setContentPane(new gui.View1());
		tFrame.pack();
		tFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tFrame.setVisible(true);
	}
}
