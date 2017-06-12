package com.f11.fems.service.exceptions;

public class MandatoryFieldsMissingException extends BadRequestException{
	
	String fieldName;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2839430699494736875L;

	public MandatoryFieldsMissingException(){
		super();
	}
	
	public MandatoryFieldsMissingException(String fieldName){
		this.fieldName = fieldName;
	}
	
	@Override
	public String getMessage() {
		StringBuilder message = new StringBuilder("");
		if(fieldName!=null){
			message.append("Missing field <").append(fieldName).append(">");
		}else{
			message =message.append("Not all mandatory fields are filled");
		}
		return message.toString();
	}

}
