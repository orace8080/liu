package com.sand.api.exception;

public class LookupException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LookupException() {
		super();
	}

	public LookupException(String message) {
		super(message);
	}

	public LookupException(Throwable cause) {
		super(cause);
	}

	public LookupException(String message, Throwable cause) {
		super(message, cause);
	}

}
