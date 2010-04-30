package data.config.format;

import java.util.Vector;

import rss.Item;

public class RssFormat extends Format {

	public RssFormat(String _format) {

		super(_format);
	}

	protected String before() {

		String ans = "";

		ans += "<rss>\n";
		ans += "\t<channel>\n";
		ans += "\t\t<title></title>\n";
		ans += "\t\t<link></link>\n";
		ans += "\t\t<description></description>\n";

		return ans;
	}

	protected String forEachItem(Item item) {

		String ans = "";

		ans += "\t\t<item>\n";

		ans += "\t\t\t<guid>" + item.getM_guid() + "</guid>\n";
		ans += "\t\t\t<title>" + item.getM_title() + "</title>\n";
		ans += "\t\t\t<link>" + item.getM_link() + "</link>\n";
		ans += "\t\t\t<description>" + item.getM_description() + "</description>\n";
		ans += "\t\t\t<author>" + item.getM_author() + "</author>\n";

		Vector<String> categories = item.getM_categories();

		if (categories != null){

			for (int i=0; i < categories.size(); i++){

				ans += "\t\t\t<category>" + categories.get(i) + "</category>\n";
			}
		}

		ans += "\t\t</item>\n";

		return ans;
	}

	protected String after() {

		String ans = "";

		ans += "\t</channel>\n";
		ans += "</rss>\n";

		return ans;
	}
}
