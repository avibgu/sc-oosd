package plugin.itemsList;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import rss.Item;

public class ItemsPluginCellRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = 8146672558908762353L;

	private static Color _ALT = new Color(220, 220, 220);

	public Component getListCellRendererComponent(JList list, Object value,
			int index,boolean isSelected, boolean cellHasFocus) {

		super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);

		Item i = (Item) value;
		//TODO change getTitle to a new method that shows the plugin view
		setText(i.getTitle());

		if (!isSelected && index % 2 == 0) setBackground(_ALT);

		return this;
	}
}
