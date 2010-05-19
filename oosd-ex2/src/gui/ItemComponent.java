package gui;

import javax.swing.ListModel;

public interface ItemComponent {
	
	public Object getSelectedValue();

	public ListModel getModel();

	public void clearSelection();
}
