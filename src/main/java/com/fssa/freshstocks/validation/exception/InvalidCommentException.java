package com.fssa.freshstocks.validation.exception;

public class InvalidCommentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3707366413599615484L;

	public InvalidCommentException(String msg) {
		super(msg);
	}
	
	public InvalidCommentException(Throwable msg) {
		super(msg);
	}
}
