package data.config.filter;

import java.util.Vector;

import rss.Item;
import rss.RSSFeed;

public class FilterByContent extends Filter {

	public FilterByContent(String _name, String _arg) {

		super(_name, _arg);
	}

	@Override
	public boolean filterByType(Item item) {
		String title = item.getM_title();
		String description = item.getM_description();
		return (title.contains(this.arg) || description.contains(this.arg));

	}



}
