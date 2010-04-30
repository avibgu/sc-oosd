package data.config.format;

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
		ans += "* " + item.getM_description() + "\n\n";

		return ans;
	}

	@Override
	protected String after() {

		return "";
	}
}
