package rss;

import java.net.URL;

public class RSSElement {

	protected String m_title;
	protected URL m_link;
	protected String m_description;

	public RSSElement(){


	}

	public String getM_title() {
		return m_title;
	}

	public URL getM_link() {
		return m_link;
	}

	public String getM_description() {
		return m_description;
	}
}
