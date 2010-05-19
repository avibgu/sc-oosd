package plugin.itemsTable;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import rss.Item;

public class ItemsTablePluginCellRenderer extends DefaultTableCellRenderer{

	private static final long serialVersionUID = 7318261549021180210L;
	
	public Component getListCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {

		super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
				row, column);

		Item i = (Item) value;
		
		//TODO change getTitle to a new method that shows the plugin view
		
		setText( i.getTitle() );

		return this;
	}
}
