package com.edu.udea.iw.exception;

public class MyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1197875376566470821L;

	public MyException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public MyException(Throwable cause) {
		super(cause);
		
	}

}