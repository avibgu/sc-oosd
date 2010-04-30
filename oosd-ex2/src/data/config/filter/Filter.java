package data.config.filter;

import java.util.Vector;

import data.config.ConfImpl;

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

		for (int i=0; i < rssFeeds.size(); i++){

			Vector <Channel> channels = rssFeeds.get(i).getChannels();

			for (int j=0; j < channels.size(); j++){

				Channel channel = channels.get(j);
				Vector <Item> items = channel.getItems();
				Vector <Item> newItems = new Vector<Item>( items.size() );

				for (int k=0; k < items.size(); k++){

					if (this.filterByType(items.get(k)))

						newItems.add(items.get(k));
				}

				channel.setItems(newItems);
			}
		}

		return rssFeeds;
	}

	//TODO change method name
	public abstract boolean filterByType(Item item);

}
