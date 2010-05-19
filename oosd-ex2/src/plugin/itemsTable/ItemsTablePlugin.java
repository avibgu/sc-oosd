package plugin.itemsTable;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

import plugin.itemsList.ItemsPluginCellRenderer;
import plugin.itemsList.ItemsPluginModel;

import rss.Item;

public class ItemsTablePlugin {

	public Component make(Item item) {

		JList tList = new JList(new ItemsPluginModel());

		tList.setCellRenderer( new ItemsPluginCellRenderer() );
		tList.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );

		return tList;
	}
}
