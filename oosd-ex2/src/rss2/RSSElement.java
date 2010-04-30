package rss2;


public class RSSElement {

	protected String m_title;
	protected String m_link;
	protected String m_description;

	/**
	 * creates a new RSSElement
	 */
	public RSSElement(){
		
		this.m_title = "";
		this.m_link = "";
		this.m_description = "";

	}

	/**
	 * returns the element's title
	 * @return the element's title
	 */
	public String getTitle() {
		return this.m_title;
	}

	/**
	 * returns the element's link
	 * @return the element's link
	 */
	public String getLink() {
		return this.m_link;
	}

	/**
	 * returns the element's description
	 * @return the element's description
	 */
	public String getDescription() {
		return this.m_description;
	}
}
