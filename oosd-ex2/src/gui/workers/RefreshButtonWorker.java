package gui.workers;

import exception.AbortException;

import frames.ErrorFrame;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JTree;
import javax.swing.SwingWorker;
import javax.swing.tree.DefaultMutableTreeNode;

import main.SimpleXMLReader;

import rss.RSSFeed;
import rss.RssHandler;

import config.Feed;

public class RefreshButtonWorker extends SwingWorker<Void, Void>{
	
	private DefaultMutableTreeNode _selectedNode;
	private JTree _tree;

	public RefreshButtonWorker(DefaultMutableTreeNode selectedNode, JTree tree){
		
		this._selectedNode = selectedNode;
		this._tree = tree;
	}
	
	protected Void doInBackground() throws Exception {
		
		if( _selectedNode != null ){
			
			RssHandler rssHandler = new RssHandler();
			
			try{
				
				URL address = ((RSSFeed)_selectedNode.getUserObject()).getAddress();
				
				Feed feed = new Feed( address );
				
				SimpleXMLReader reader = new SimpleXMLReader(feed, rssHandler);
				reader.read();

				((RSSFeed)_selectedNode.getUserObject()).getChannels().
				get(0).setItems( rssHandler.getRssFeed().getChannels().get(0).getItems() );
			}
			catch (MalformedURLException ex) {
				
				ErrorFrame errorFrame = new ErrorFrame("Make sure that the URL is valid");
				errorFrame.setBounds(500, 200, 275, 180);
				errorFrame.setVisible(true);
			}
			catch (AbortException ex) {
				ErrorFrame errorFrame = new ErrorFrame("Not a RSS link!");
				errorFrame.setBounds(500, 200, 275, 180);
				errorFrame.setVisible(true);
			}
		}
		
		return null;
	}
	
	protected void done(){
		
		_tree.updateUI();
	}
}
