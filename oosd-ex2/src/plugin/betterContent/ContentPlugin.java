package plugin.betterContent;

import java.awt.Component;

import javax.swing.JTextArea;

import rss.Item;

public class ContentPlugin {

	public Component make(Item item) {

		JTextArea tText = new JTextArea();

		return tText; //TODO return some of panel component with the desired options..
	}
}
