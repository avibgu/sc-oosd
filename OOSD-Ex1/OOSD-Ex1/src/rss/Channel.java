package rss;

import java.net.URL;
import java.util.Vector;

public class Channel extends RSSElement{

	private Vector<Item> m_items;

	public Channel(){
		this.m_items = new Vector<Item>();
		
	}
	
	public Vector<Item>getItems(){
		return this.m_items;
	}
	
	public void setTitle(String title){
		this.m_title = title;

	}
	
	public void setLink(URL link){
		this.m_link = link;

	}
	
	public void setDescription(String description){
		this.m_description = description;

	}
	
}
