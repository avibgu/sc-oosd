package gui;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.JTextComponent;

public class FileBrowser extends JFrame
						 implements TreeSelectionListener, ListSelectionListener{

	private static final long serialVersionUID = 5109460248103737764L;

	private JTree _tree;
	
	private JTextArea _content;
	
	private JList _files;
	
	public FileBrowser(File file) {
		
		super(file.getAbsolutePath());
		
		// Tree
		setTree(new JTree(new FeedsTreeModel(file)));
		getTree().setCellRenderer(new FeedsTreeCellRenderer());
		getTree().addTreeSelectionListener(this);
		
		// File list
		setFiles(new JList( new ItemsListModel()) );
		getFiles().setCellRenderer( new ItemsListCellRenderer() );
		getFiles().setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		getFiles().addListSelectionListener(this);
		
		// Text area
		setContent(new JTextArea(10, 30));
	}

	private void setTree(JTree jTree) {

		this._tree = jTree;
	}
	
	private JTree getTree() {

		return this._tree;
	}

	private void setFiles(JList jList) {

		this._files = jList;
	}

	private JList getFiles() {
		
		return this._files;
	}
	
	private void setContent(JTextArea jTextArea) {

		this._content = jTextArea;
	}

	public void valueChanged(TreeSelectionEvent e) {

		File tDir = (File) e.getPath().getLastPathComponent();
		((ItemsListModel)getFiles().getModel()).setDir(tDir);
	}

	public void valueChanged(ListSelectionEvent e) {
		
		// Gotcha 1: Check if value is adjusting
		if (e.getValueIsAdjusting()) return;
		
		// Gotcha 2: Don't use e's indices
		File tFile = (File) getFiles().getSelectedValue();
		getContent().setText("");
		
		// Gotcha 3: Don't re-use a worker
		SwingWorker<Void, String> tWorker = new FileReaderWorker(tFile, getContent());
		tWorker.execute();
	}

	private JTextArea getContent() {
		
		return this._content;
	}

}
