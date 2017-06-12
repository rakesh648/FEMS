package com.f11.fems.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	Object resourceName,resourceIdentifier;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2839430699494736875L;

	public ResourceNotFoundException(){
		super();
	}
	
	public ResourceNotFoundException(Object resourceName, Object resourceIdentifier){
		this.resourceName = resourceName;
		this.resourceIdentifier = resourceIdentifier;
	}
	
	@Override
	public String getMessage() {
		StringBuilder message = new StringBuilder("Resource not found.");
		if(resourceName!=null){
			message.append(" Resource Name: ").append(resourceName).append(".");
		}
		if(resourceIdentifier!=null){
			message.append(" Resource Identifier: ").append(resourceIdentifier).append(".");
		}
		return message.toString();
	}

}
