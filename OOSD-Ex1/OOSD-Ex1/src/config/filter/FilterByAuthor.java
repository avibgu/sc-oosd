package config.filter;

import rss.Item;


public class FilterByAuthor extends Filter {

	public FilterByAuthor(String _name, String _arg) {

		super(_name, _arg);
	}

	@Override
	public boolean filterByType(Item item) {
		String author = item.getM_author();
		return author.equals(this.arg);

	}



}
