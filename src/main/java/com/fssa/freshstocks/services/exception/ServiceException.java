package com.fssa.freshstocks.services.exception;

public class ServiceException extends Exception {
	
	/**
	 * This Exception Should thrown only in Service File
	 */
	private static final long serialVersionUID = -915118433667030428L;

	public ServiceException(String msg) {
		super(msg);
	}
	
	public ServiceException(Throwable msg) {
		super(msg);
	}
}
