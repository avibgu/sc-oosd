package config.filter;

import java.util.Vector;

import config.ConfImpl;

import rss.Channel;
import rss.Item;
import rss.RSSFeed;

public abstract class Filter extends ConfImpl {

	protected String name;
	protected String arg;

	/**
	 * ctor
	 *
	 * @param _name the type of the filter
	 * @param _arg the arguments
	 */
	public Filter(String _name, String _arg){

		this.name = _name;
		this.arg = _arg;
	}

	/**
	 * @return the type of the filter
	 */
	public String getName(){

		return this.name;
	}

	/**
	 * @return the argument
	 */
	public String getArg(){

		return this.arg;
	}

	public final Vector<RSSFeed> filter (Vector<RSSFeed> rssFeeds){
		for (RSSFeed feed: rssFeeds){

			Vector <Channel> channels = feed.getChannels();

			for (Channel channel: channels){

				Vector <Item> items = channel.getItems();

				for (Item item: items){

					if(!filterByType(item)){
						items.remove(item);

					}
				}
			}
		}

		return rssFeeds;
	}

	//TODO change method name
	public abstract boolean filterByType(Item item);

}
