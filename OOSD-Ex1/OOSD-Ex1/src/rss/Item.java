package rss;

import java.net.URL;
import java.util.UUID;

public class Item extends RSSElement{

	private UUID m_guid;
	private String m_author;
	private String m_category;
	
	public Item(){
		
	}
	
	public void setGuid(UUID guid){
		this.m_guid = guid;
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
	
	public void setAuthor(String author){
		this.m_author = author;
	}
	
	public void setCategory(String category){
		this.m_category = category;
	}
}
