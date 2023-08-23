package com.fssa.freshstocks.validation.exception;

public class InvalidUserException extends Exception {
	/**
	 * This Exception Should thrown only When User Object is Invalid
	 */
	private static final long serialVersionUID = 8571072783282245242L;

	public InvalidUserException(String msg) {
		super(msg);
	}
	
	public InvalidUserException(Throwable msg) {
		super(msg);
	}
}
