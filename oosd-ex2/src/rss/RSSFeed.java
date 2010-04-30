package rss;

import java.util.Vector;

public class RSSFeed {

	
	private Vector<Channel> m_channels;

	public RSSFeed(){
		
		this.m_channels = new Vector<Channel>();
	}
	
	public Vector<Channel> getChannels(){
		return this.m_channels;
	}

}
