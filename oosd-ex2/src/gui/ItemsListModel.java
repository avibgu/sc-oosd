package gui;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class ItemsListModel implements ListModel{

	private File _dir;
	
	private List<File> _files;
	
	private Collection<ListDataListener> _listeners;
	
	private static FileFilter _FILTER = new FileFilter() {
		
		public boolean accept(File f) {
			
			return f.isFile();
		}
	};
	
	public ItemsListModel() {
		
		setListeners( new LinkedList<ListDataListener>() );
		setFiles( Collections.EMPTY_LIST );
	}
	
	private void setListeners(LinkedList<ListDataListener> linkedList) {
		
		this._listeners = linkedList;
	}
	
	private void setFiles(List<File> emptyList) {
		
		this._files = emptyList;
	}

	public File getDir() {
		
		return _dir;
	}

	public void setDir(File dir) {
		
		this._dir = dir;
		
		int tOldSize = getSize();
		
		File[] tFiles = dir.listFiles(_FILTER);
		
		setFiles(Arrays.asList(tFiles));
		
		int tMax = Math.max(tOldSize, getSize());
		
		ListDataEvent tEvt = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED,
													0,tMax);
		
		for (ListDataListener tListener : getListeners()){
		
			tListener.contentsChanged(tEvt);
		}
	}

	private Collection<ListDataListener> getListeners() {

		return this._listeners;
	}
	
	public int getSize() {
		
		return getFiles().size();
	}

	private List<File> getFiles() {
		
		return this._files;
	}

	public Object getElementAt(int index) {
	
		return getFiles().get(index);
	}
	
	public void addListDataListener(ListDataListener l) {
		
		getListeners().add(l);
	}

	public void removeListDataListener(ListDataListener l) {
		
		getListeners().remove(l);
	}
}
