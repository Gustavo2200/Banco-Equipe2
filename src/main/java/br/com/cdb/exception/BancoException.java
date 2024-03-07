package br.com.cdb.exception;

import org.springframework.http.HttpStatus;

public class BancoException extends RuntimeException {
	private HttpStatus status;
	private String message;
	
	public BancoException(HttpStatus badRequest, String message) {
		super();
		this.status = badRequest;
		this.message = message;
	}

}
