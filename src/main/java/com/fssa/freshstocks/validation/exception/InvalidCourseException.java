package com.fssa.freshstocks.validation.exception;

public class InvalidCourseException extends Exception {

	/**
	 * This Exception Should thrown only When Course Object is Invalid
	 */
	private static final long serialVersionUID = -1098196194788863135L;

	public InvalidCourseException(String msg) {
		super(msg);
	}
	
	public InvalidCourseException(Throwable msg) {
		super(msg);
	}
}
