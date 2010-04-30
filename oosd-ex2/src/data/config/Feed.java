package data.config;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class Feed extends ConfImpl {

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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	 */
	public InputStream getStream(){

		InputStream is = null;

		try{

			is = this.feedAddress.openStream();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return is;
	}
}
