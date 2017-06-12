package com.f11.fems.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
	
	String message;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2839430699494736875L;

	public BadRequestException(){
		super();
	}
	
	public BadRequestException(String message){
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message.toString();
	}

}
