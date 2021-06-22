package com.yrrhelp.exception;

public class CustomerException extends Exception {

	public CustomerException() {
		super();
		
	}

	public CustomerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CustomerException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerException(String message) {
		super(message);
	}

	public CustomerException(Throwable cause) {
		super(cause);
	}

}
