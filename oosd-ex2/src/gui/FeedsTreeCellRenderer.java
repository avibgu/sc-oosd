package gui;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import rss.RSSFeed;

public class FeedsTreeCellRenderer extends DefaultTreeCellRenderer {

	private static final long serialVersionUID = 7408770029078116878L;
	
	
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus){

		super.getTreeCellRendererComponent(tree,value,sel,expanded,leaf,row,hasFocus);

		if (value instanceof String){
			
			setText( (String)value );
			return this;
		}
		
		RSSFeed tFeed = (RSSFeed) value;
		
		setText( tFeed.getName() );
		setIcon( expanded ? openIcon : closedIcon );
		
		return this;
	}
}
