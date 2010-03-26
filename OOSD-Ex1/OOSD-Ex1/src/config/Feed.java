package config;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class holds information about a feed
 */
public class Feed extends ConfImpl {

	/**
	 * the feed address
	 */
	private URL feedAddress;

	/**
	 * ctor
	 *
	 * @param address the address of the feed
	 */
	public Feed(String address){

		this.feedAddress = null;

		try {

			this.feedAddress = new URL(address);
		}
		catch (MalformedURLException e) {

			System.out.println("an error occurred when tried to open url - "
					+ address );
		}
	}

	/**
	 * @return the address of the feed
	 */
	public URL getAddress(){

		return this.feedAddress;
	}

	/**
	 * @return the input stream of the feed
	 * @throws IOException if there is a problem to open a stream
	 */
	public InputStream getStream() throws IOException{

		if (this.feedAddress == null) return null;
		
		InputStream is = this.feedAddress.openStream();
		
		return is;
	}
}
