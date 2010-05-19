package plugin.itemsTable;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


public class ItemsTablePluginModel implements TableModel {

	private final String[] _columnNames = {"Title", "Author", "Categories"};
    private Vector< Vector<String> > _data;
    
	private Collection<TableModelListener> _listeners;
	
	public ItemsTablePluginModel(){
		
		this._data = new Vector< Vector<String> >();
		
		this._data.add( new Vector<String>() );
		this._data.add( new Vector<String>() );
		this._data.add( new Vector<String>() );
		
		setListeners( new LinkedList<TableModelListener>() );
	}

	public int getRowCount() {

		return this._data.get(0).size();
	}

	public Class<?> getColumnClass(int columnIndex) {

		return Vector.class;
	}

	public String getColumnName(int columnIndex) {

		return this._columnNames[columnIndex];
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {

		return true;
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

		this._data.get( columnIndex ).set( rowIndex, (String)aValue );
		
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {

		return this._data.get( columnIndex ).get( rowIndex );
	}


	
//-------------------| Listeners |----------------------------------------
	
	public void setListeners(Collection<TableModelListener> listeners) {
		
		this._listeners = listeners;
	}

	public Collection<TableModelListener> getListeners() {
		
		return _listeners;
	}
	
	public void addTableModelListener(TableModelListener l) {
		
		getListeners().add(l);
	}

	public void removeTableModelListener(TableModelListener l) {

		getListeners().remove(l);
	}

	
	
//-------------| Columns |------------------
	
	public String[] getColumnNames() { return _columnNames; }

	public int getColumnCount() { return getColumnNames().length; }










}
