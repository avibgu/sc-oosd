package main;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Vector;

import rss.*;
import config.*;

public class Main {

	/**
	 * the main function of the program
	 *
	 * @param args the arguments from the command line
	 * @throws Exception TODO remove it...
	 */
	public static void main(String[] args) throws Exception {

		try {

			if (args.length < 1) throw new FileNotFoundException("Usage: ex1 <conf-file>");
		}
		catch (FileNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

		// parsing the configuration file
		ConfigHandler confHandler = new ConfigHandler();

		SimpleXMLReader reader = new SimpleXMLReader(args[0], confHandler);

		reader = new SimpleXMLReader(args[0], confHandler);

		// parsing the rss feeds
		RssHandler rssHandler = new RssHandler();

		Vector<Feed> urlFeeds = confHandler.getFeeds();

		Vector<RSSFeed> rssFeeds = new Vector<RSSFeed>( urlFeeds.size() );

		for (int i=0; i < urlFeeds.size(); i++){

			reader = new SimpleXMLReader( urlFeeds.get(i), rssHandler );
			rssFeeds.add( rssHandler.getRssFeed() );
		}

		// filterring the feeds
		
		Vector<Filter> filters = confHandler.getFilters();
		
		for (int i=0; i < filters.size(); i++){

			//TODO filterrrrrrr...
			Vector<RSSFeed> rssFeeds = filters.get(i).filter( rssFeeds );
		}

		// creating output

		Vector<Format> formats = confHandler.getFormats();

		Vector<BufferedWriter> outputFiles = new Vector<BufferedWriter>();

		for (int i=0; i < formats.size(); i++){

			if ( formats.get(i).getFormat().equals("rss") ){

				for (int j=0; j < rssFeeds.size(); j++){

					FileWriter file = new FileWriter("output" + j + ".xml");
					BufferedWriter out = new BufferedWriter(file);

					rssFeeds.get(j).toRss(out);	//out.write("text");

					outputFiles.add(out);
					out.close();
				}
			}
			else{

				for (int j=0; j < rssFeeds.size(); j++){

					FileWriter file = new FileWriter("output" + j + ".txt");
					BufferedWriter out = new BufferedWriter(file);

					rssFeeds.get(j).toTxt(out);	//out.write("text");

					outputFiles.add(out);
					out.close();
				}
			}
		}
	}
}
