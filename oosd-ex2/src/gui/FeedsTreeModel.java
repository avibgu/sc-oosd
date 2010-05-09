package gui;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

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
	
	public Object getChild(Object parent, int index) {

		if ( (parent instanceof String) && ((String)parent).equals(this.root) )
			return this._feeds.get(index);
		
		else if (index == 0)
			return ((RSSFeed)parent).getChannels().get(0).getDescription();
		
		else if (index == 1)
			return ((RSSFeed)parent).getChannels().get(0).getLink();
		
		else return null;
	}
	
	public int getChildCount(Object parent) {
		
		if ( (parent instanceof String) && ((String)parent).equals(this.root) )
			return this._feeds.size();
		
		else if (parent instanceof RSSFeed) return 2;
		
		else return 0;
	}
	
	public boolean isLeaf(Object node) {

		return getChildCount(node) == 0;
	}
	
	public int getIndexOfChild(Object parent, Object child) {
		
		if ( (parent instanceof String) && ((String)parent).equals(this.root) )
			return this._feeds.indexOf((RSSFeed)child);
		
		if (parent instanceof RSSFeed){
			
			if ( ((String)child).equals(
					((RSSFeed)parent).getChannels().get(0).getDescription() ) )
					return 0;
		}
		
		return 1;
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
		
		int[] index = { this._feeds.indexOf( feed ) };
		
		this._feeds.remove( feed );
		
		Object[] children = { feed };
		
		TreeModelEvent tEvt =
			new TreeModelEvent( this, new TreePath( getRoot() ), index, children );
		
		for (TreeModelListener tListener : getListeners()){
		
			tListener.treeNodesRemoved(tEvt);
		}		
	}

	public void add(RSSFeed feed){
		this._feeds.add(feed);
		
		Object[] path = {this.getRoot()};
		
		TreeModelEvent tEvt = new TreeModelEvent(this, path);
		
		for (TreeModelListener tListener : getListeners()){
		
			tListener.treeNodesInserted(tEvt);
		}	
		
	}
	
	private Collection<TreeModelListener> getListeners() { return this._listeners; }

	public void setListeners(LinkedList<TreeModelListener> list) {
		
		this._listeners = list;
	}
	
	public boolean contains(RSSFeed feed){
		boolean contains = false;
		for(RSSFeed rssFeed : this._feeds){
			if(rssFeed.equals(feed)){
				contains = true;
				break;
			}
		}
		return contains;
	}
}
