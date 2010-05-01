package gui;

import java.io.File;
import java.io.FileFilter;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import rss.RSSFeed;

public class FeedsTreeModel implements TreeModel {

//	private File _dir;
	
	private Vector<RSSFeed> _feeds;
	
//	public FeedsTreeModel(File dir){
//		
//		setDir(dir);
//	}
	
	public FeedsTreeModel(Vector<RSSFeed> feeds){
	
		setFeeds(feeds);
	}

//	private void setDir(File dir) {
//
//		this._dir = dir;
//	}
	
	private void setFeeds(Vector<RSSFeed> feeds) {

		this._feeds = feeds;
	}

//	private static FileFilter _FILTER = new FileFilter() {
//		
//		public boolean accept(File file) {
//			
//			return file.isDirectory();
//		}
//	};
	
//	private File[] list(File file){
//		
//		return file.listFiles(_FILTER);
//	}
	
//	public Object getRoot() {
//
//		return getDir();
//	}
	
	public Object getRoot() {
	
			return this._feeds.get(0);
	}
	
//	private Object getDir() {
//
//		return this._dir;
//	}
	
	private Object getFeeds() {
	
		return this._feeds;
	}

//	public Object getChild(Object parent, int index) {
//
//		File[] tChildren = list((File)parent);	
//		
//		return tChildren[index];
//	}
	
	public Object getChild(Object parent, int index) {

		return ((Vector<RSSFeed>)parent).get(index);	
	}
	
//	public int getChildCount(Object parent) {
//
//		return list((File)parent).length;
//	}
	
	public int getChildCount(Object parent) {

		return ((Vector<RSSFeed>)parent).size();
	}
	
//	public boolean isLeaf(Object node) {
//
//		return getChildCount(node) == 0;
//	}
	
	public boolean isLeaf(Object node) {

		return true;
	}
	
//	public int getIndexOfChild(Object parent, Object child) {
//
//		List<File> tFiles = Arrays.asList(list((File)parent));
//		return tFiles.indexOf((File)child);
//	}
	
	public int getIndexOfChild(Object parent, Object child) {
		
		return this._feeds.indexOf((RSSFeed)child);
	}
	
	public void valueForPathChanged(TreePath path, Object newValue) {}
	
	public void addTreeModelListener(TreeModelListener l) {}

	public void removeTreeModelListener(TreeModelListener l) {}
}
