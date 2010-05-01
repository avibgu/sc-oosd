package gui;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class FeedsTreeModel implements TreeModel {

	private File _dir;
	
	public FeedsTreeModel(File dir){
		
		setDir(dir);
	}	

	private void setDir(File dir) {

		this._dir = dir;
	}

	private static FileFilter _FILTER = new FileFilter() {
		
		public boolean accept(File file) {
			
			return file.isDirectory();
		}
	};
	
	private File[] list(File file){
		
		return file.listFiles(_FILTER);
	}
	
	public Object getRoot() {

		return getDir();
	}
	

	private Object getDir() {

		return this._dir;
	}

	public Object getChild(Object parent, int index) {

		File[] tChildren = list((File)parent);	
		
		return tChildren[index];
	}
	
	public int getChildCount(Object parent) {

		return list((File)parent).length;
	}
	
	public boolean isLeaf(Object node) {

		return getChildCount(node) == 0;
	}
	
	public int getIndexOfChild(Object parent, Object child) {

		List<File> tFiles = Arrays.asList(list((File)parent));
		return tFiles.indexOf((File)child);
	}
	
	public void valueForPathChanged(TreePath path, Object newValue) {}
	
	public void addTreeModelListener(TreeModelListener l) {}

	public void removeTreeModelListener(TreeModelListener l) {}
}
