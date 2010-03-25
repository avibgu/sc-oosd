package config.format;

import rss.Item;

public class TextFormat extends Format {

	public TextFormat(String _format) {

		super(_format);
	}

	@Override
	protected String before() {

		return "";
	}

	@Override
	protected String forEachItem(Item item) {

		String ans = "";

		ans += item.getM_title() + "\n";
		
		String description = item.getM_description();
		
		String[] splitted = description.split("\n");
		
		for (int i=0; i < splitted.length; i++)
			
			ans += "* " + splitted[i] + "\n";
		
		ans += "\n";

		return ans;
	}

	@Override
	protected String after() {

		return "";
	}
}
