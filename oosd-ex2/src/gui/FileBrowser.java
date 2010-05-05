package gui;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import rss.Channel;
import rss.Item;
import rss.RSSFeed;

public class FileBrowser extends JFrame
						 implements TreeSelectionListener, ListSelectionListener{

	private static final long serialVersionUID = 5109460248103737764L;

	private JTree _tree;
	
	private JTextArea _content;
	
	private JList _items;

	private RSSFeed _emptyFeed;
	
	public FileBrowser() {
		
		super();

		//TODO remove it..
		Vector<RSSFeed> feeds = prepareTheFeeds();
		
		// Create an empty feed
		this._emptyFeed = new RSSFeed("");
		Channel channel = new Channel();
		Item item = new Item();
		channel.getItems().add(item);
		this._emptyFeed.getChannels().add(channel);
		
		// Tree
		setTree(new JTree(new FeedsTreeModel(feeds)));
		getTree().setCellRenderer(new FeedsTreeCellRenderer());
		getTree().addTreeSelectionListener(this);
		
		// File list
		setItems(new JList( new ItemsListModel()) );
		getItems().setCellRenderer( new ItemsListCellRenderer() );
		getItems().setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		getItems().addListSelectionListener(this);
		
		// Text area
		setContent(new JTextArea(10, 30));
		getContent().setEditable(false);
		getContent().setTabSize(4);
		
		// Prepare layout
		JSplitPane tHorizonSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		tHorizonSplit.setLeftComponent(getTree());
		JSplitPane tVertSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		tHorizonSplit.setRightComponent(tVertSplit);
		tVertSplit.setTopComponent(new JScrollPane(getItems()));
		tVertSplit.setBottomComponent(new JScrollPane(getContent()));
		
		// Put the layout pane as content pane
		setContentPane(tHorizonSplit);
		pack();
		setVisible(true);
	}

//---------| TODO remove it - only for testing |--------------
	private Vector<RSSFeed> prepareTheFeeds() {
		
		Vector<RSSFeed> feeds = new Vector<RSSFeed>();

		feeds.add(new RSSFeed("AVI"));
		Channel channel = new Channel();
		Item item = new Item();
		item.setTitle("Avi's title");
		item.setDescription("Avi's description\n");
		channel.getItems().add(item);
		feeds.get(0).getChannels().add(channel);

		feeds.add(new RSSFeed("AVIA"));
		channel = new Channel();
		item = new Item();
		item.setTitle("Avia's title");
		item.setDescription("Avia's description\n");
		channel.getItems().add(item);
		feeds.get(1).getChannels().add(channel);
		
		return feeds;
	}
//-------------------------------------------------------------

	public void valueChanged(TreeSelectionEvent e) {

		if ( e.getPath().getLastPathComponent() instanceof String ){
			
			((ItemsListModel)getItems().getModel()).setFeed( this._emptyFeed );
			return;
		}
		
		RSSFeed tFeed = (RSSFeed) e.getPath().getLastPathComponent();
		((ItemsListModel)getItems().getModel()).setFeed(tFeed);
		
		// clear item selection and content pane
		getItems().clearSelection();
		getContent().setText("");
	}

	public void valueChanged(ListSelectionEvent e) {
        
		Item tItem = (Item) getItems().getSelectedValue();
		
		if (tItem == null) return;
			
		getContent().setText( tItem.getDescription() );
	}
	
	private void setTree(JTree jTree) { this._tree = jTree; }
	
	private JTree getTree() { return this._tree; }

	private void setItems(JList jList) { this._items = jList; }

	private JList getItems() { return this._items; }
	
	private void setContent(JTextArea jTextArea) { this._content = jTextArea; }
	
	private JTextArea getContent() { return this._content; }
}
