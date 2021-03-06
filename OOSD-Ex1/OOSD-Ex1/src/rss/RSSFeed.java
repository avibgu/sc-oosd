package rss;

import java.util.Vector;

public class RSSFeed {

	
	private Vector<Channel> m_channels;

	/**
	 * creates a new RSSFeed
	 */
	public RSSFeed(){
		
		this.m_channels = new Vector<Channel>();
	}
	
	/**
	 * returns the feed's channels
	 * @return the feed's channels
	 */
	public Vector<Channel> getChannels(){
		return this.m_channels;
	}

}
