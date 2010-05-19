package gui;

import javax.swing.ListModel;

import rss.RSSFeed;

public interface ItemsModel extends ListModel {
	
	public void setFeed(RSSFeed feed);
}
