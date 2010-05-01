package gui;

import java.io.File;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.JTextComponent;

import rss.Channel;
import rss.Item;
import rss.RSSFeed;

public class FileBrowser extends JFrame
						 implements TreeSelectionListener, ListSelectionListener{

	private static final long serialVersionUID = 5109460248103737764L;

	private JTree _tree;
	
	private JTextArea _content;
	
	private JList _items;
	
	public FileBrowser(File file) {
		
		super(file.getAbsolutePath());
		
		// TODO remove it - only for testing..
		Vector<RSSFeed> feeds = new Vector<RSSFeed>();
		feeds.add(new RSSFeed("AVI"));
		Channel channel = new Channel();
		Item item = new Item();
		item.setDescription("AVI DIGMI");
		channel.getItems().add(item);
		feeds.get(0).getChannels().add(channel);
		
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

	private void setTree(JTree jTree) {

		this._tree = jTree;
	}
	
	private JTree getTree() {

		return this._tree;
	}

	private void setItems(JList jList) {

		this._items = jList;
	}

	private JList getItems() {
		
		return this._items;
	}
	
	private void setContent(JTextArea jTextArea) {

		this._content = jTextArea;
	}

	public void valueChanged(TreeSelectionEvent e) {

//		File tDir = (File) e.getPath().getLastPathComponent();
//		((ItemsListModel)getFiles().getModel()).setDir(tDir);
		
		RSSFeed tFeed = (RSSFeed) e.getPath().getLastPathComponent();
		((ItemsListModel)getItems().getModel()).setFeed(tFeed);
	}

	public void valueChanged(ListSelectionEvent e) {
		
		// Gotcha 1: Check if value is adjusting
		if (e.getValueIsAdjusting()) return;
		
		// Gotcha 2: Don't use e's indices
		Item tItem = (Item) getItems().getSelectedValue();
		getContent().setText("");
		
		// Gotcha 3: Don't re-use a worker
		SwingWorker<Void, String> tWorker = new ItemReaderWorker(tItem, getContent());
		tWorker.execute();
	}

	private JTextArea getContent() {
		
		return this._content;
	}

}
