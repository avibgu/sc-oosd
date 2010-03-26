package main;

import java.io.FileInputStream;
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
import exception.FatalErrorException;

public class SimpleXMLReader {

	/**
	 *  the xml file
	 */
	private FileInputStream file;

	/**
	 *  the rss feed
	 */
	private Feed feed;

	/**
	 *  the handler we use
	 */
	private DefaultHandler handler;

	/**
	 * first ctor
	 *
	 * @param _file the file to parse from
	 * @param _handler the handler
	 * @throws FatalErrorException 
	 */
	public SimpleXMLReader(FileInputStream _file, DefaultHandler _handler){

		this.handler = _handler;
		this.file = _file;
		this.feed = null;
	}

	/**
	 * second ctor
	 *
	 * @param _feed the feed to parse from
	 * @param _handler the handler
	 * @throws FatalErrorException 
	 */
	public SimpleXMLReader(Feed _feed, DefaultHandler _handler){

		this.handler = _handler;
		this.file = null;
		this.feed = _feed;
	}

	/**
	 * this method read information from XML file
	 * 
	 * @throws FatalErrorException if a fatal error occurred
	 */
	public void read() throws FatalErrorException {

		try{

			SAXParserFactory spf = SAXParserFactory.newInstance();

			SAXParser saxParser = spf.newSAXParser();

			// if there is a file - perform this
			if (this.file != null){

				XMLReader rdr;

				rdr = saxParser.getXMLReader();

				rdr.setContentHandler( this.handler );

				InputSource src1 = new InputSource( this.file );

				rdr.parse( src1 );

			}
			// if there is a remote rss feed - perform this
			else {

				InputStream src2 = this.feed.getStream();
				saxParser.parse( src2 , this.handler );
			}
		}
		catch (IOException e) {

			throw new FatalErrorException();
		}
		catch (SAXException e) {

			System.out.println("can't read form - " + this.feed.getAddress().toString() );
		}
		catch (ParserConfigurationException e) {

			System.out.println("can't read form - " + this.feed.getAddress().toString() );
		}
	}
}
