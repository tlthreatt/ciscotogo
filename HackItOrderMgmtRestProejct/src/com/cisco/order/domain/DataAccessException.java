package com.cisco.order.domain;

public class DataAccessException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	public DataAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public DataAccessException(String msg) {
        super(msg);
    }

	public DataAccessException() {
		// TODO Auto-generated constructor stub
	}
}
