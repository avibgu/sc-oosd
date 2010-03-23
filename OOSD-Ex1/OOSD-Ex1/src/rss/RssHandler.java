package rss;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import java.util.Stack;
import java.util.Vector;

public class RssHandler extends DefaultHandler {

	private Stack<String> stack;
	private StringBuffer sb;

	private RSSFeed feed;


	/**
	 * default ctor
	 */
	public RssHandler(){

		this.stack = new Stack<String>();
		this.sb = new StringBuffer();

		this.feed = new RSSFeed();

	}

	public RSSFeed getRssFeed(){

		return this.feed;
	}




	/**
	 * this method invoked when an element starts
	 *
	 * @param uri the uri name
	 * @param lName some other name
	 * @param qName the name that we use
	 * @param attribs the attributes
	 */
    public void startElement( String uri, String lName, String qName, Attributes attribs ) {

    	this.stack.push(qName);
    }

    /**
     * this method reads the text inside the body of an element
     *
     * @param ch the characters array
	 * @param start the start index
	 * @param len the length of the array
     */
    public void characters(char[] ch,int start,int len){

    	this.sb.append( ch, start, len );
    }

	/**
	 * this method invoked when an element ends
	 *
	 * @param uri the uri name
	 * @param lName some other name
	 * @param qName the name that we use
	 */
    public void endElement( String uri, String lName, String qName ) {


    	if ( qName.equals("filter") ){

    		this.filters.add( new Filter(this.name, this.args) );
    		this.sb = new StringBuffer();
    	}

        this.stack.pop();
    }
}
