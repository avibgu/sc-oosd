package rss;

import java.net.URL;
import java.util.UUID;
import java.util.Vector;

public class Item extends RSSElement{

	private UUID m_guid;
	private String m_author;
	private Vector<String> m_categories;

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

	public UUID getM_guid() {
		return this.m_guid;
	}

	public String getM_author() {
		return this.m_author;
	}

	public Vector<String> getM_categories() {
		return this.m_categories;
	}
}
