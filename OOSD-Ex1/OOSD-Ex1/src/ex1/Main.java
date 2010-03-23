package ex1;


import java.io.FileNotFoundException;
import java.util.Vector;

import rss.*;
import config.*;

public class Main {

	public static void main(String[] args) {

		try {

			if (args.length < 1) throw new FileNotFoundException("Usage: ex1 <conf-file>");
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// parsing the configuration file
		ConfigHandler confHandler = new ConfigHandler();

		SimpleXMLReader reader = new SimpleXMLReader(args[0], confHandler);

		// parsing the rss feeds
		RssHandler rssHandler = new RssHandler();

		Vector<Feed> urlFeeds = confHandler.getFeed();

		Vector<RSSFeed> rssFeeds = new Vector<RSSFeed>( urlFeeds.size() );

		for (int i=0; i < urlFeeds.size(); i++){

			reader = new SimpleXMLReader(urlFeeds.get(i), rssHandler );
			rssFeeds.add( rssHandler.getRssFeed() );
		}

		// filterring the feeds
		for (int i=0; i < rssFeeds.size(); i++){

			//TODO filterrrrrrr...
		}

		// creating output...



	}
}
