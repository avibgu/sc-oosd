package main;

import javax.swing.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame tFrame = new JFrame( "Feeds Reader" );
		tFrame.setContentPane( new gui.Gui2() );	
		tFrame.pack();
		tFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		tFrame.setBounds(200, 100, 850, 500);
		tFrame.setVisible( true );
	}
}
