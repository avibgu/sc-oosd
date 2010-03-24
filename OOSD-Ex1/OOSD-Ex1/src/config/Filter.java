package config;

import java.util.Vector;

import rss.RSSFeed;

public abstract class Filter extends ConfImpl {

	private String name;
	private String arg;

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

	public abstract Vector<RSSFeed> filter (Vector<RSSFeed> rssFeeds);
}
