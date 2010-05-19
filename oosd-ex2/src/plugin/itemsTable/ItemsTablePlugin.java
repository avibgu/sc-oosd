package plugin.itemsTable;

import java.awt.Component;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import rss.Item;

public class ItemsTablePlugin {

	public Component make(Item item) {

		JTable tTable = new JTable( new ItemsTablePluginModel() );

		tTable.setDefaultRenderer( Vector.class, new ItemsTablePluginCellRenderer() );

		tTable.getSelectionModel().addListSelectionListener( new RowListener() );
		
//		tTable.getColumnModel().getSelectionModel().
//            addListSelectionListener(new ColumnListener());
		
		tTable.setFillsViewportHeight(true);
		
		tTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );

		return tTable;
	}
}
