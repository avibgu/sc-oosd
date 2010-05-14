package gui;

import static java.awt.GridBagConstraints.BOTH;
import static java.awt.GridBagConstraints.CENTER;
import static java.awt.GridBagConstraints.EAST;
import static java.awt.GridBagConstraints.HORIZONTAL;
import static java.awt.GridBagConstraints.NONE;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import main.SimpleXMLReader;

import config.Feed;

import exception.AbortException;
import frames.ErrorFrame;
import gui.workers.AddButtonWorker;

import rss.Channel;
import rss.Item;
import rss.RSSFeed;
import rss.RssHandler;

public class Gui2 extends JPanel
				   implements TreeSelectionListener, ListSelectionListener {

	private static final long serialVersionUID = 1048997770789816933L;


	private JTree _tree;

	private JTextArea _content;

	private JList _items;

	private RSSFeed _emptyFeed;

	private DefaultMutableTreeNode _selectedNode;



	public Gui2() {

		super(new GridBagLayout());


//------------------------------------------------------------
		//TODO remove it..
		DefaultMutableTreeNode feeds = prepareTheFeeds();
		this._selectedNode = null;

		// Create an empty feed
		this._emptyFeed = new RSSFeed("");
		Channel channel = new Channel();
		Item item = new Item();
		channel.getItems().add(item);
		this._emptyFeed.getChannels().add(channel);

		// Tree
		setTree( new JTree( new FeedsTreeModel2(feeds) ) );
		getTree().setCellRenderer(new FeedsTreeCellRenderer2());
		getTree().addTreeSelectionListener(this);
		getTree().setEditable(true);

		// Items list
		setItems(new JList( new ItemsListModel()) );
		getItems().setCellRenderer( new ItemsListCellRenderer() );
		getItems().setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		getItems().addListSelectionListener(this);

		// Text area
		setContent(new JTextArea(10, 30));
		getContent().setEditable(false);
		getContent().setTabSize(4);

//------------------------------------------------------------



		setBackground(Color.decode("5462640"));

		GridBagConstraints tProto = new GridBagConstraints();
		tProto.insets = new Insets(5,2,5,2);

		GridBagConstraints tLabelConst = (GridBagConstraints)tProto.clone();
		tLabelConst.anchor = EAST;
		tLabelConst.fill = NONE;
		tLabelConst.weightx = 1.0;

		GridBagConstraints tTextConst = (GridBagConstraints)tProto.clone();
		tTextConst.anchor = EAST;
		tTextConst.fill = HORIZONTAL;
		tTextConst.weightx = 5.0;

		GridBagConstraints tButtonsConst = (GridBagConstraints)tProto.clone();
		tButtonsConst.anchor = CENTER;
		tButtonsConst.fill = HORIZONTAL;
		tButtonsConst.weightx = 5.0;

		GridBagConstraints tButtonConst = (GridBagConstraints)tProto.clone();
		tButtonConst.anchor = CENTER;
		tButtonConst.fill = NONE;
		tButtonConst.weightx = 0.0;


		// (0,0) "Add New Feed"
		GridBagConstraints tConst = (GridBagConstraints)tLabelConst.clone();
		tConst.gridx = 0; tConst.gridy = 0;
		JLabel text = new JLabel("Add New Feed:\t");
		text.setFont(new Font("Time New Roman",Font.BOLD,16));
		text.setForeground(Color.WHITE);
		add(text, tConst);

		// (1,0) "URL"
		tConst =  (GridBagConstraints)tLabelConst.clone();
		tConst.gridx = 1; tConst.gridy = 0;
		text = new JLabel("URL");
		text.setFont(new Font("Time New Roman",Font.ITALIC,14));
		text.setForeground(Color.WHITE);
		add(text, tConst);

		// (2,0) [textField]
		tConst = (GridBagConstraints)tTextConst.clone();
		tConst.gridx = 2; tConst.gridy = 0;
		final JTextField url = new JTextField(30);
		add(url, tConst);

		// (3,0) "Refresh Rate"
		tConst = (GridBagConstraints)tLabelConst.clone();
		tConst.gridx = 3; tConst.gridy = 0;
		text = new JLabel("Refresh Rate");
		text.setFont(new Font("Time New Roman",Font.ITALIC,14));
		text.setForeground(Color.WHITE);
		add(text, tConst);

		// (4,0) [textField]
		tConst = (GridBagConstraints)tTextConst.clone();
		tConst.gridx = 4; tConst.gridy = 0;
		String[] timeStrings = { " 5 sec", " 10 sec", " 30 sec", " 1 min", " 10 min" };
		final JComboBox refresh = new JComboBox( timeStrings );
		refresh.setSelectedIndex(0);
		add(refresh, tConst);

		// (5,0) "Add" button
		tConst = (GridBagConstraints)tButtonConst.clone();
		tConst.gridx = 5; tConst.gridy = 0;
		JButton addButton = new JButton("Add");
		add(addButton, tConst);

		addButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				new AddButtonWorker( url, getTree(), refresh ).execute();
			}
		});

		GridBagConstraints tListConst = (GridBagConstraints)tProto.clone();
		tListConst.anchor = CENTER;
		tListConst.weightx = 1.0;
		tListConst.weighty = 1.0;
		tListConst.insets = new Insets(2, 2, 2, 2);


		// (0-1,2-5) List of feeds
	    getTree().setBorder( BorderFactory.createEtchedBorder() );

		tConst = (GridBagConstraints)tListConst.clone();
		tConst.fill = BOTH;
		tConst.gridx = 0; tConst.gridy = 2;
		tConst.gridwidth = 2; tConst.gridheight = 4;

		JScrollPane pane = new JScrollPane( getTree() );
		pane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
		pane.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	    add( pane, tConst );


		// (2-5,2-3) List of titles
	    getItems().setBorder( BorderFactory.createEtchedBorder() );

		tConst = (GridBagConstraints)tListConst.clone();
		tConst.anchor = CENTER;
		tConst.fill = BOTH;
		tConst.gridx = 2; tConst.gridy = 2;
		tConst.gridwidth = 4; tConst.gridheight = 2;

		pane = new JScrollPane( getItems() );
		pane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
		pane.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	    add( pane, tConst );


		// (2-5,4-5)Text Area
		getContent().setBorder( BorderFactory.createEtchedBorder() );

		tConst = new GridBagConstraints();
		tConst.insets = new Insets(2, 2, 2, 2);
		tConst.fill = BOTH;
		tConst.anchor = CENTER;
		tConst.weighty = 1.0;
		tConst.gridx = 2; tConst.gridy = 4;
		tConst.gridwidth = 4; tConst.gridheight = 2;

		pane = new JScrollPane( getContent() );
		pane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
		pane.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		add( pane, tConst);


		// (0,6) "Remove" button
		tConst = (GridBagConstraints)tButtonConst.clone();
		tConst.gridx = 0; tConst.gridy = 6;
		tConst.gridwidth = 1; tConst.gridheight = 1;

		JButton removeButton = new JButton("Remove");

		removeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if ( _selectedNode != null){

					((FeedsTreeModel2)getTree().getModel()).remove(_selectedNode);

					((ItemsListModel)getItems().getModel()).setFeed(_emptyFeed);

					getContent().setText("");
				}
			}
		});

		add(removeButton, tConst);

		// (1,6) "Refresh" button
		tConst = (GridBagConstraints)tButtonConst.clone();
		tConst.gridx = 1; tConst.gridy = 6;
		tConst.gridwidth = 1; tConst.gridheight = 1;

		JButton refreshButton = new JButton("Refresh");

//		refreshButton.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				
//				if(_selectedNode != null){
//					
//					RssHandler rssHandler = new RssHandler();
//					
//					try{
//						
//						Feed feed = new Feed(_selectedFeed.getAddress().toString());
//						
//						SimpleXMLReader reader = new SimpleXMLReader(feed, rssHandler);
//						reader.read();
//						
//						FeedsTreeModel model = ((FeedsTreeModel)getTree().getModel());
//						Vector<RSSFeed> feeds = ((FeedsTreeModel)getTree().getModel()).getFeeds();
//						
//						RSSFeed rssFeed = rssHandler.getRssFeed();
//						
//						if(!model.contains(rssFeed) && rssFeed.getChannels().get(0).getLink() != null){
//							
//							feeds.add(rssHandler.getRssFeed());
//							getTree().updateUI();	
//						}
//						else{
//							
//							int feedIndex = feeds.indexOf(_selectedFeed);
//							
//							feeds.remove(feedIndex);
//							feeds.add(feedIndex, rssHandler.getRssFeed());
//							
//							getTree().updateUI();
//						}
//						
//					}
//					catch (MalformedURLException ex) {
//						
//						ErrorFrame errorFrame = new ErrorFrame("Make sure that the URL is valid");
//						errorFrame.setSize(275, 180);
//						errorFrame.setVisible(true);
//					}
//					catch (AbortException ex) {
//						ErrorFrame errorFrame = new ErrorFrame("Not a RSS link!");
//						errorFrame.setSize(275, 180);
//						errorFrame.setVisible(true);
//					}
//					url.setText("");
//					refresh.setText("");
//				}
//			}
//		});
		
		add(refreshButton, tConst);

		// (5,6) "Load Plugin" button
		tConst = (GridBagConstraints)tButtonConst.clone();
		tConst.gridx = 5; tConst.gridy = 6;
		tConst.gridwidth = 1; tConst.gridheight = 1;

		JButton loadButton = new JButton("Load Plugin");

		add(loadButton, tConst);
	}


	//---------| TODO remove it - only for testing |--------------
	private DefaultMutableTreeNode prepareTheFeeds() {

		DefaultMutableTreeNode feeds =
			new DefaultMutableTreeNode( new String("Feeds") );

		RSSFeed feed1 = new RSSFeed("AVI");
		Channel channel = new Channel();
		Item item = new Item();
		item.setTitle("Avi's title");
		item.setDescription("Avi's description\n");
		channel.getItems().add(item);
		feed1.getChannels().add(channel);

		RSSFeed feed2 = new RSSFeed("AVIA");
		channel = new Channel();
		item = new Item();
		item.setTitle("Avia's title");
		item.setDescription("Avia's description\n");
		channel.getItems().add(item);
		feed2.getChannels().add(channel);

		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode( feed1 );
		DefaultMutableTreeNode node2 = new DefaultMutableTreeNode( feed2 );

		node1.add( new DefaultMutableTreeNode( "node1.description" ) );
		node1.add( new DefaultMutableTreeNode( "node1.link" ) );

		node2.add( new DefaultMutableTreeNode( "node2.description" ) );
		node2.add( new DefaultMutableTreeNode( "node2.link" ) );

		feeds.add( node1 );
		feeds.add( node2 );

		return feeds;
	}
//-------------------------------------------------------------

	public void valueChanged(TreeSelectionEvent e) {

		DefaultMutableTreeNode tNode =
			(DefaultMutableTreeNode) e.getPath().getLastPathComponent();

		if (tNode.getUserObject() instanceof RSSFeed){

			((ItemsListModel)getItems().getModel()).setFeed(
					((RSSFeed)tNode.getUserObject()) );

			this._selectedNode = tNode;
		}
		else{

			String str = (String)tNode.getUserObject();

			if ( str.equals("Feeds") ){

				((ItemsListModel)getItems().getModel()).setFeed( this._emptyFeed );
			}
			else{

				((ItemsListModel)getItems().getModel()).setFeed(
						((RSSFeed)((DefaultMutableTreeNode)
								tNode.getParent()).getUserObject()) );
			}

			this._selectedNode = null;
		}

		// clear item selection and content pane
		getItems().clearSelection();
		getContent().setText("");
	}

	public void valueChanged(ListSelectionEvent e) {

		Item tItem = (Item) getItems().getSelectedValue();

		if (tItem == null) return;

		String author = tItem.getAuthor();

		getContent().setText( tItem.getDescription() + " - by " + author );
	}

	private void setTree(JTree jTree) { this._tree = jTree; }

	private JTree getTree() { return this._tree; }

	private void setItems(JList jList) { this._items = jList; }

	private JList getItems() { return this._items; }

	private void setContent(JTextArea jTextArea) { this._content = jTextArea; }

	private JTextArea getContent() { return this._content; }
}
