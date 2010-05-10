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

import main.SimpleXMLReader;

import config.Feed;

import frames.ErrorFrame;

import rss.Channel;
import rss.Item;
import rss.RSSFeed;
import rss.RssHandler;

public class Gui extends JPanel
				   implements TreeSelectionListener, ListSelectionListener {

	private static final long serialVersionUID = 1048997770789816933L;


	private JTree _tree;

	private JTextArea _content;

	private JList _items;

	private RSSFeed _emptyFeed;

	private RSSFeed _selectedFeed;



	public Gui() {

		super(new GridBagLayout());


//------------------------------------------------------------
		//TODO remove it..
		Vector<RSSFeed> feeds = prepareTheFeeds();
		this._selectedFeed = null;

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
		final JTextField refresh = new JTextField(10);
		add(refresh, tConst);

		// (5,0) "Add" button
		tConst = (GridBagConstraints)tButtonConst.clone();
		tConst.gridx = 5; tConst.gridy = 0;
		JButton addButton = new JButton("Add");
		add(addButton, tConst);

		addButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				RssHandler rssHandler = new RssHandler();
				try{
					Feed feed = new Feed(url.getText());
					if(feed.getAddress() != null){
						SimpleXMLReader reader = new SimpleXMLReader(feed, rssHandler);
						reader.read();
						FeedsTreeModel model = ((FeedsTreeModel)getTree().getModel());
						Vector<RSSFeed> feeds = ((FeedsTreeModel)getTree().getModel()).getFeeds();
						if(!model.contains(rssHandler.getRssFeed())){
							feeds.add(rssHandler.getRssFeed());
							getTree().updateUI();

						}
					}
				} catch (MalformedURLException ex) {
					//TODO create an error frame with an ok button
					ErrorFrame errorFrame = new ErrorFrame("Make sure that the URL is valid");
					errorFrame.setSize(275, 180);
					errorFrame.setVisible(true);
				}
				url.setText("");
				refresh.setText("");
			}
		});


		GridBagConstraints tListConst = (GridBagConstraints)tProto.clone();
		tListConst.anchor = CENTER;
		tListConst.weightx = 1.0;
		tListConst.weighty = 1.0;
		tListConst.insets = new Insets(2, 2, 2, 2);


		// (0-1,2-5) List of feeds

		getTree().setBorder( BorderFactory.createEtchedBorder() );
		getTree().setScrollsOnExpand(true);


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

				if ( _selectedFeed != null){

					((FeedsTreeModel)getTree().getModel()).remove(_selectedFeed);

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

		add(refreshButton, tConst);

		// (5,6) "Load Plugin" button
		tConst = (GridBagConstraints)tButtonConst.clone();
		tConst.gridx = 5; tConst.gridy = 6;
		tConst.gridwidth = 1; tConst.gridheight = 1;

		JButton loadButton = new JButton("Load Plugin");

		add(loadButton, tConst);
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
			getItems().clearSelection();
			getContent().setText("");

			this._selectedFeed = null;

			return;
		}

		RSSFeed tFeed = (RSSFeed) e.getPath().getLastPathComponent();
		((ItemsListModel)getItems().getModel()).setFeed(tFeed);

		this._selectedFeed = tFeed;

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
