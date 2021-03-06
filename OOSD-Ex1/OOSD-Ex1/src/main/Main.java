package main;

import java.io.FileInputStream;
import java.util.Vector;

import rss.*;
import config.*;
import config.filter.Filter;
import config.format.Format;
import exception.FatalErrorException;
import exception.GiveUpException;

/**
 * The main class of the program
 */
public class Main {

	/**
	 * the main function of the program
	 *
	 * @param args the arguments from the command line
	 */
	public static void main(String[] args){

		FileHandling fh = new FileHandling();
		FileInputStream file = null;

		try {
				
			if (args.length < 1) file = fh.openFileForReading(null);
			else file = fh.openFileForReading(args[0]);
	
			// parsing the configuration file
			ConfigHandler confHandler = new ConfigHandler();
	
			SimpleXMLReader reader = new SimpleXMLReader(file, confHandler);
			reader.read();
			
			// parsing the rss feeds
			RssHandler rssHandler = new RssHandler();
	
			Vector<Feed> urlFeeds = confHandler.getFeeds();
	
			Vector<RSSFeed> rssFeeds = new Vector<RSSFeed>( urlFeeds.size() );
	
			for (int i=0; i < urlFeeds.size(); i++){
	
				reader = new SimpleXMLReader( urlFeeds.get(i), rssHandler );
				reader.read();
				rssFeeds.add( rssHandler.getRssFeed() );
			}
	
			// filtering the feeds
	
			Vector<Filter> filters = confHandler.getFilters();
	
			for (int i=0; i < filters.size(); i++){
	
				rssFeeds = filters.get(i).filter( rssFeeds );
			}
	
			// creating output
	
			Vector<Format> formats = confHandler.getFormats();
	
			
			for (int i=0; i < formats.size(); i++){
	
				String toWrite = formats.get(i).convertToMyFormat(rssFeeds);
				String end = (formats.get(i).getFormat().equals("rss") ? "xml" : "txt");
				fh.writeToFile("output" + i + "." + end , toWrite);
				
				System.out.println(toWrite);
			}
			
		}
		catch (GiveUpException e) {
			
			System.out.println("exiting..");
		}
		catch (FatalErrorException e) {
			
			System.out.println("a fatal error occurred.. exiting..");
		}
	}
}
