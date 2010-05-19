package plugin.itemsTable;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.table.DefaultTableCellRenderer;

public class ItemsTablePluginCellRenderer extends DefaultTableCellRenderer{

	private static final long serialVersionUID = 7318261549021180210L;
	
	public Component getListCellRendererComponent(JList list, Object value,
			int index,boolean isSelected, boolean cellHasFocus) {
		
		return this;
	}
}
