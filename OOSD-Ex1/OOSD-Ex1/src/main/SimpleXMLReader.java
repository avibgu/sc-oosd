package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

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
	 * @param _fn the file name to parse from
	 * @param _handler the handler
	 */
	public SimpleXMLReader(File _file, DefaultHandler _handler){

		this.handler = _handler;
		this.file = _file;
		this.feed = null;

		this.read();
	}

	/**
	 * second ctor
	 *
	 * @param _feed the feed to parse from
	 * @param _handler the handler
	 */
	public SimpleXMLReader(Feed _feed, DefaultHandler _handler){

		this.handler = _handler;
		this.file = null;
		this.feed = _feed;

		this.read();
	}

	private void read() {

		try{

			SAXParserFactory spf = SAXParserFactory.newInstance();

			SAXParser saxParser = spf.newSAXParser();

			if (this.file != null){

				XMLReader rdr;

				rdr = saxParser.getXMLReader();

				rdr.setContentHandler( this.handler );

				InputSource src1 = new InputSource( new FileInputStream( this.file ) );

				rdr.parse( src1 );

			}
			else {

				InputStream src2 = this.feed.getStream();
				saxParser.parse( src2 , this.handler );
			}
		}
	    catch (FileNotFoundException e) {

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
		catch (ParserConfigurationException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
