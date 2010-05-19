package plugin.itemsTable;

import java.awt.Component;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import rss.Item;

public class ItemsTablePlugin implements TableModelListener{

	public Component make(Item item) {

		JTable tTable = new JTable( new ItemsTablePluginModel() );

		tTable.setDefaultRenderer( Vector.class, new ItemsTablePluginCellRenderer() );

		tTable.;
		
		table.setFillsViewportHeight(true);
		
		tTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );

		return tTable;
	}

	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		
	}
}
