package exceptions;

/**
 * this class represent an abort exception
 */
public class GiveUpException extends Exception {

	/**
	 * ctor
	 * 
	 * @param arg0 a given string
	 * @param arg1 a given throwable
	 */
	public GiveUpException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * ctor
	 * 
	 * @param arg0 a given string
	 */
	public GiveUpException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * ctor
	 * 
	 * @param arg0 a given throwable
	 */
	public GiveUpException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * ctor
	 */
	public GiveUpException(){
		
		super();
	}
	
	/**
	 * the serial Version UID
	 */
	private static final long serialVersionUID = 1L;

}
