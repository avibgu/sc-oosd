package plugin.itemsList;


import java.awt.Component;

import java.io.File;

import javax.swing.JList;
import javax.swing.ListSelectionModel;


public class ItemsPlugin {

	public Component make(File file) {

		JList tList = new JList(new ItemsPluginModel());

		tList.setCellRenderer( new ItemsPluginCellRenderer() );
		tList.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );

		return tList;

	}
}
