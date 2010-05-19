package gui;

import javax.swing.ListModel;

public interface ItemComponent {
	
	public Object getSelectedValue();

	public Object getModel();

	public void clearSelection();
}
