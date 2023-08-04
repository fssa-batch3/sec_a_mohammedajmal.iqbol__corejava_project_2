package freshstocks.services.exception;

public class ServiceException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -915118433667030428L;

	public ServiceException(String msg) {
		super(msg);
	}
	
	public ServiceException(Throwable msg) {
		super(msg);
	}
}
