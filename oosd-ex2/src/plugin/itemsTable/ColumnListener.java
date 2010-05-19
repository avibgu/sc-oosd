package plugin.itemsTable;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


class ColumnListener implements ListSelectionListener {
	
    public void valueChanged(ListSelectionEvent event) {
        
    	if (event.getValueIsAdjusting()) return;
    	
    }
}