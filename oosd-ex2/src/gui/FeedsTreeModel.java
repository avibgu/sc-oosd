package gui;

import java.util.Vector;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import rss.RSSFeed;

public class FeedsTreeModel implements TreeModel {

	private String root;
	
	private Vector<RSSFeed> _feeds;
	
	public FeedsTreeModel(Vector<RSSFeed> feeds){
	
		setFeeds(feeds);
		this.setRoot("Feeds");
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
	
	public void addTreeModelListener(TreeModelListener l) {}

	public void removeTreeModelListener(TreeModelListener l) {}

	private void setRoot(String root) {
		
		this.root = root;
	}
}
