package com.example.demo.services.exceptions;

import java.io.Serializable;

public class AuthorizationException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public AuthorizationException(String msg) {
		super(msg);
	}
	
	public AuthorizationException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
