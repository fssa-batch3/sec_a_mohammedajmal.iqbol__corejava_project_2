package com.fssa.freshstocks.utils.exception;

public class DatabaseException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5798217198944437621L;

	public DatabaseException(String msg) {
		super(msg);
	}

	public DatabaseException(Throwable ex) {
		super(ex);
	}

	public DatabaseException(String msg, Throwable ex) {
		super(msg, ex);
	}

}