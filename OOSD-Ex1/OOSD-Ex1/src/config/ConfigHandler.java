
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
	private Vector<Format> formats;

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
		this.formats = new Vector<Format>();

		this.name = null;
		this.arg = null;
	}

	/**
	 * @return the feed
	 */
	public Vector<Feed> getFeeds(){

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
	public Vector<Format> getFormats(){

		return this.formats;
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
    	this.sb = new StringBuffer();
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

    		this.name = this.sb.toString().trim();
    		this.sb = new StringBuffer();
    	}

    	if ( this.stack.peek().equals("arg") ){

    		this.arg = this.sb.toString().trim();
    		this.sb = new StringBuffer();
    	}

    	if ( qName.equals("feed") ){

    		this.feeds.add( new Feed( this.sb.toString() ) );
    		this.sb = new StringBuffer();
    	}

    	if ( qName.equals("format") ){

    		this.formats.add( new Format( this.sb.toString().trim() ) );
    		this.sb = new StringBuffer();
    	}

    	if ( qName.equals("filter") ){

    		Filter newFilter = null;

    		if (this.name == "title")
    			newFilter = new FilterByTitle(this.name, this.arg);

    		if (this.name == "category")
    			newFilter = new FilterByCategory(this.name, this.arg);

    		if (this.name == "content")
    			newFilter = new FilterByContent(this.name, this.arg);

    		if (this.name == "author")
    			newFilter = new FilterByAuthor(this.name, this.arg);

    		this.filters.add( newFilter );

    		this.name = null;
    		this.arg = null;
    		this.sb = new StringBuffer();
    	}

        this.stack.pop();
    }
}
