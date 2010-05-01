package gui;

import java.awt.Component;
import java.io.File;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class FeedsTreeCellRenderer extends DefaultTreeCellRenderer {

	private static final long serialVersionUID = 7408770029078116878L;
	
	
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus){
		
		super.getTreeCellRendererComponent(tree,value,sel,expanded,leaf,row,hasFocus);
		
		File tRoot = (File) tree.getModel().getRoot();
		File tFile = (File) value;
		
		setText( tRoot.equals(value) ? tFile.getAbsolutePath() : tFile.getName() );
		setIcon( expanded ? openIcon : closedIcon );
		
		return this;
	}
}
