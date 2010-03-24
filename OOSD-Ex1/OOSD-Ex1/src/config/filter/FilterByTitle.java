package config.filter;

import java.util.Vector;

import rss.Channel;
import rss.Item;
import rss.RSSFeed;

public class FilterByTitle extends Filter {

	public FilterByTitle(String _name, String _arg){

		super(_name, _arg);
	}

	@Override
	public boolean filterByType(Item item) {

		String title = item.getM_title();
		return title.contains(this.arg);
	}



}
