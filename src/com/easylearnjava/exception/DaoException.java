package com.easylearnjava.exception;

public class DaoException extends RuntimeException {

	/**
	 * This is auto generated
	 */
	private static final long serialVersionUID = -3371478545556037594L;

	public DaoException(){
		super();
	}
	
	public DaoException(Throwable cause){
		super(cause);
	}
	
	public DaoException(String message){
		super(message);
	}
	
	public DaoException(String message, Throwable cause){
		super(message, cause);
	}
	
	public void errorResponce(String message, int code){
		
	}
	
}
