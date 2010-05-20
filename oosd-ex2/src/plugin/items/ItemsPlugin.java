package plugin.items;


import java.awt.Component;
import java.io.File;
import javax.swing.JList;
import javax.swing.JTextArea;

public class ItemsPlugin {

	public Component make(File file, JTextArea textArea) {

		JList tList = new JList();

		tList.setCellRenderer( new ItemsPluginCellRenderer() );
		
		return tList;

	}
}
