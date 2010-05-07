package gui;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import rss.Item;
import rss.RSSFeed;

public class FeedsTreeModel implements TreeModel {

	private String root;

	private Vector<RSSFeed> _feeds;
	
	private Collection<TreeModelListener> _listeners;
	
	public FeedsTreeModel(Vector<RSSFeed> feeds){
	
		setFeeds(feeds);
		setRoot("Feeds");
		setListeners( new LinkedList<TreeModelListener>() );
	}
	
	private void setFeeds(Vector<RSSFeed> feeds) {

		this._feeds = feeds;
	}
	
	public String getRoot() {
	
			return this.root;
	}
	
	public Vector<RSSFeed> getFeeds() {
	
		return this._feeds;
	}
	
	public RSSFeed getChild(Object parent, int index) {

		if ( ((String)parent).equals(this.root) )
			return this._feeds.get(index);
		
		else
			return null;
	}
	
	public int getChildCount(Object parent) {
		
		if ( ((String)parent).equals(this.root) )
			return this._feeds.size();
		
		else return 0;
	}
	
	public boolean isLeaf(Object node) {

		return !(node instanceof String);
	}
	
	public int getIndexOfChild(Object parent, Object child) {
		
		return this._feeds.indexOf((RSSFeed)child);
	}
	
	public void valueForPathChanged(TreePath path, Object newValue) {}
	
	public void addTreeModelListener(TreeModelListener l) {
		
		getListeners().add(l);
	}

	public void removeTreeModelListener(TreeModelListener l) {
		
		getListeners().remove(l);
	}

	private void setRoot(String root) { this.root = root; }
	
	public void remove(RSSFeed feed){
		
		this._feeds.remove(feed);
		
		Object[] path = {this.getRoot()};
		
		TreeModelEvent tEvt = new TreeModelEvent(this, path);
		
		for (TreeModelListener tListener : getListeners()){
		
			tListener.treeNodesRemoved(tEvt);
		}		
	}

	private Collection<TreeModelListener> getListeners() { return this._listeners; }

	public void setListeners(LinkedList<TreeModelListener> list) {
		
		this._listeners = list;
	}
}
