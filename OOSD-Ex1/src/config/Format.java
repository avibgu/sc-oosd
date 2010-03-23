package config;

public class Format extends ConfImpl {

	private String format;

	/**
	 * ctor
	 *
	 * @param _format the format of the output
	 */
	public Format(String _format){

		this.format = _format;
	}

	/**
	 * @return the format type
	 */
	public String getFormat(){

		return this.format;
	}
}