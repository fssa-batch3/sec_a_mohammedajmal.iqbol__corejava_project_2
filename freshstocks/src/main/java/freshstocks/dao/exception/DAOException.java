package freshstocks.dao.exception;

public class DAOException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8728677066630606611L;

	public DAOException(String msg) {
		super(msg);
	}
	
	public DAOException(Throwable msg) {
		super(msg);
	}
}
