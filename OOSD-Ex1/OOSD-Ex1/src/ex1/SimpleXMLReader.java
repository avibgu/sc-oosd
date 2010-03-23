package ex1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import config.Feed;

public class SimpleXMLReader {

	// the xml file name
	private File file;

	// the rss feed
	private Feed feed;

	// the handler we use
	private DefaultHandler handler;

	/**
	 * first ctor
	 *
	 * @param _fn the file name
	 * @param _handler the handler
	 */
	public SimpleXMLReader(String _fn, DefaultHandler _handler){

		this.handler = _handler;
		this.file = new File( _fn );
		this.feed = null;

		this.read();
	}

	/**
	 * second ctor
	 *
	 * @param _feed
	 * @param _handler
	 */
	public SimpleXMLReader(Feed _feed, DefaultHandler _handler){

		this.handler = _handler;
		this.file = null;
		this.feed = _feed;

		this.read();
	}

	private void read() {

		File file = null;

		InputSource src = null;

		try{

			if (this.file != null){

			     src = new InputSource( new FileInputStream( file ) );
			}
			else {

				src = this.feed.getStream();
			}

			SAXParserFactory spf = SAXParserFactory.newInstance();

			SAXParser saxParser = spf.newSAXParser();

			XMLReader rdr;

			rdr = saxParser.getXMLReader();

			rdr.setContentHandler( this.handler );

			rdr.parse( src );

		}
	    catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
