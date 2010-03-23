
package config;


import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import java.util.Stack;
import java.util.Vector;

public class ConfigHandler extends DefaultHandler{

	private Stack<String> stack;
	private StringBuffer sb;

	private Vector<Feed> feeds;
	private Vector<Filter> filters;
	private Format format;

	private String name;
	private String arg;

	/**
	 * default ctor
	 */
	public ConfigHandler(){

		this.stack = new Stack<String>();
		this.sb = new StringBuffer();

		this.feeds = new Vector<Feed>();
		this.filters = new Vector<Filter>();
		this.format = null;

		this.name = null;
		this.arg = null;
	}

	/**
	 * @return the feed
	 */
	public Vector<Feed> getFeed(){

		return this.feeds;
	}

	/**
	 * @return the filters
	 */
	public Vector<Filter> getFilters(){

		return this.filters;
	}

	/**
	 * @return the format
	 */
	public Format getFormat(){

		return this.format;
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

    	// TODO check what are the differences between this.stack.peek().equals("name")
    	// and qName.equals("name")
    	if ( this.stack.peek().equals("name") ){

    		this.name = this.sb.toString();
    		this.sb = new StringBuffer();
    	}

    	if ( this.stack.peek().equals("args") ){

    		this.arg = this.sb.toString();
    		this.sb = new StringBuffer();
    	}

    	if ( qName.equals("feed") ){

    		this.feeds.add( new Feed( this.sb.toString() ) );
    		this.sb = new StringBuffer();
    	}

    	if ( qName.equals("format") ){

    		this.format = new Format( this.sb.toString() );
    		this.sb = new StringBuffer();
    	}

    	if ( qName.equals("filter") ){

    		this.filters.add( new Filter(this.name, this.arg) );
    		this.sb = new StringBuffer();
    	}

        this.stack.pop();
    }
}
