package gui;

import static java.awt.GridBagConstraints.BOTH;
import static java.awt.GridBagConstraints.CENTER;
import static java.awt.GridBagConstraints.EAST;
import static java.awt.GridBagConstraints.HORIZONTAL;
import static java.awt.GridBagConstraints.NONE;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View1 extends JPanel{

	private static final long serialVersionUID = 1048997770789816933L;

	public View1() {

		super(new GridBagLayout());

		setBackground(Color.decode("5462640"));

		GridBagConstraints tProto = new GridBagConstraints();
		tProto.insets = new Insets(5,2,5,2);

		GridBagConstraints tLabelConst = (GridBagConstraints)tProto.clone();
		tLabelConst.anchor = EAST;
		tLabelConst.fill = NONE;
		tLabelConst.weightx = 1.0;

		GridBagConstraints tTextConst = (GridBagConstraints)tProto.clone();
		tTextConst.anchor = EAST;
		tTextConst.fill = HORIZONTAL;
		tTextConst.weightx = 5.0;

		GridBagConstraints tButtonsConst = (GridBagConstraints)tProto.clone();
		tButtonsConst.anchor = CENTER;
		tButtonsConst.fill = HORIZONTAL;
		tButtonsConst.weightx = 5.0;

		GridBagConstraints tButtonConst = (GridBagConstraints)tProto.clone();
		tButtonConst.anchor = CENTER;
		tButtonConst.fill = NONE;
		tButtonConst.weightx = 0.0;

	    
		// (0,0) "Add New Feed"
		GridBagConstraints tConst = (GridBagConstraints)tLabelConst.clone();
		tConst.gridx = 0; tConst.gridy = 0;
		JLabel text = new JLabel("Add New Feed:\t");
		text.setFont(new Font("Time New Roman",Font.BOLD,16));
		text.setForeground(Color.WHITE);
		add(text, tConst);

		// (1,0) "URL"
		tConst =  (GridBagConstraints)tLabelConst.clone();
		tConst.gridx = 1; tConst.gridy = 0;
		text = new JLabel("URL");
		text.setFont(new Font("Time New Roman",Font.ITALIC,14));
		text.setForeground(Color.WHITE);
		add(text, tConst);

		// (2,0) [textField]
		tConst = (GridBagConstraints)tTextConst.clone();
		tConst.gridx = 2; tConst.gridy = 0;
		add(new JTextField(20), tConst);

		// (3,0) "Refresh Rate"
		tConst = (GridBagConstraints)tLabelConst.clone();
		tConst.gridx = 3; tConst.gridy = 0;
		text = new JLabel("Refresh Rate");
		text.setFont(new Font("Time New Roman",Font.ITALIC,14));
		text.setForeground(Color.WHITE);
		add(text, tConst);

		// (4,0) [textField]
		tConst = (GridBagConstraints)tTextConst.clone();
		tConst.gridx = 4; tConst.gridy = 0;
		add(new JTextField(10), tConst);

		// (5,0) "Add" button
		tConst = (GridBagConstraints)tButtonConst.clone();
		tConst.gridx = 5; tConst.gridy = 0;
		add(new JButton("Add"), tConst);


		GridBagConstraints tListConst = (GridBagConstraints)tProto.clone();
		tListConst.anchor = CENTER;
		tListConst.weightx = 1.0;
		tListConst.weighty = 1.0;
		tListConst.insets = new Insets(2, 2, 2, 2);


		// (0-1,2-5) List of feeds
		tConst = (GridBagConstraints)tListConst.clone();
		tConst.fill = BOTH;
		tConst.gridx = 0; tConst.gridy = 2;
		tConst.gridwidth = 2; tConst.gridheight = 4;
		
		String[] listEnrties = {"enrty_1","enrty_2","enrty_3","enrty_4","enrty_5"};
	    JList list = new JList( listEnrties );
	    add(list, tConst);
	    
	    
		// (2-5,2-3) List of titles
		tConst = (GridBagConstraints)tListConst.clone();
		tConst.fill = BOTH;
		tConst.gridx = 2; tConst.gridy = 2;
		tConst.gridwidth = 4; tConst.gridheight = 2;


	    list = new JList( listEnrties );
	    add(list, tConst);


		// (2-5,4-5)Text Area
	    final JTextArea textArea = new JTextArea(15, 30);
	    
		textArea.setBorder(BorderFactory.createEtchedBorder());

		tConst = new GridBagConstraints();
		tConst.insets = new Insets(2, 2, 2, 2);
		tConst.fill = BOTH;
		tConst.anchor = CENTER;
		tConst.weighty = 1.0;
		tConst.gridx = 2; tConst.gridy = 4;
		tConst.gridwidth = 4; tConst.gridheight = 2;

		add(textArea, tConst);
		
		
		// (0-1,6) "Remove" button
		tConst = (GridBagConstraints)tButtonConst.clone();
		tConst.gridx = 0; tConst.gridy = 6;
		tConst.gridwidth = 2; tConst.gridheight = 1;
		
		JButton removeButton = new JButton("Remove Feed");
		
		add(removeButton, tConst);
	}
}
