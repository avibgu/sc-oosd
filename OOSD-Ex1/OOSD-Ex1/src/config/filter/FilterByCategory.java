package config.filter;

import java.util.Vector;

import rss.Item;
import rss.RSSFeed;

public class FilterByCategory extends Filter{

	public FilterByCategory(String _name, String _arg) {

		super(_name, _arg);
	}

	@Override
	public boolean filterByType(Item item) {
		// TODO Auto-generated method stub
		return false;
	}



}
