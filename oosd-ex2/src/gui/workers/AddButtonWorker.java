package gui.workers;

import exception.AbortException;
import frames.ErrorFrame;
import gui.FeedsTreeModel2;

import java.net.MalformedURLException;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingWorker;
import javax.swing.tree.DefaultMutableTreeNode;

import main.SimpleXMLReader;
import rss.RSSFeed;
import rss.RssHandler;
import config.Feed;

public class AddButtonWorker extends SwingWorker<Void, Void>{
	
	private JTextField _url;
	private JTree _tree;
	private JComboBox _refresh;
	private int[] timeInts = { 5, 10, 30, 60, 600 };

	public AddButtonWorker(JTextField url, JTree tree, JComboBox refresh){
		
		this._url = url;
		this._tree = tree;
		this._refresh = refresh;
	}
	
	protected Void doInBackground() throws Exception {

		RssHandler rssHandler = new RssHandler();

		try{

			Feed feed = new Feed( this._url.getText() );

			if(feed.getAddress() != null){

				SimpleXMLReader reader = new SimpleXMLReader(feed, rssHandler);
				reader.read();

				FeedsTreeModel2 model = ((FeedsTreeModel2)_tree.getModel());

				RSSFeed newFeed = rssHandler.getRssFeed();

				if(!model.contains( newFeed ) ){

					DefaultMutableTreeNode node = new DefaultMutableTreeNode( newFeed );

					node.add( new DefaultMutableTreeNode(
							newFeed.getChannels().get(0).getDescription() ) );

					node.add( new DefaultMutableTreeNode(
							newFeed.getChannels().get(0).getLink() ) );

					((DefaultMutableTreeNode)model.getRoot()).add( node );
					
					//TODO add refresh timer..
					int refreshTime = timeInts[ this._refresh.getSelectedIndex() ];
					
					
				}
				else{

					ErrorFrame errorFrame = new ErrorFrame("The URL is already exist");
					errorFrame.setBounds(500, 200, 275, 180);
					errorFrame.setVisible(true);
				}
			}
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
		
		return null;
	}
	
	protected void done(){
		
		_tree.updateUI();
		_url.setText("");
	}
}
