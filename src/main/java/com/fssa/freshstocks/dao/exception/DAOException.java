package com.fssa.freshstocks.dao.exception;

public class DAOException extends Exception {
	
	/**
	 * This Exception Should thrown only in DAO File
	 */
	private static final long serialVersionUID = -8728677066630606611L;

	public DAOException(String msg) {
		super(msg);
	}
	
	public DAOException(Throwable msg) {
		super(msg);
	}
}
