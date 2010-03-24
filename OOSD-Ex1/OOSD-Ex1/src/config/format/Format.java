package config.format;

import java.util.Vector;

import config.ConfImpl;

import rss.Channel;
import rss.Item;
import rss.RSSFeed;

public abstract class Format extends ConfImpl {

	private String format;

	/**
	 * ctor
	 *
	 * @param _format the format of the output
	 */
	public Format(String _format){

		this.format = _format;
	}

	/**
	 * @return the format type
	 */
	public String getFormat(){

		return this.format;
	}

	public final String convertToMyFormat(Vector<RSSFeed> rssFeeds){

		String ans = "";

		ans += before();

		for (RSSFeed feed: rssFeeds){

			Vector <Channel> channels = feed.getChannels();

			for (Channel channel: channels){

				Vector <Item> items = channel.getItems();

				for (Item item: items){

					ans += forEachItem(item);
				}
			}
		}

		ans += after();

		return ans;
	}

	protected abstract String before();

	protected abstract  String forEachItem(Item item);

	protected abstract String after();
}
