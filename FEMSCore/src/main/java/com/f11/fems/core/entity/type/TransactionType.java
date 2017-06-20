package com.f11.fems.core.entity.type;

public enum TransactionType {
	
	CHEQUE("Cheque"),
	CASH("Cash"), 
	ONLINE("Online");
	
	private String description;
	
	TransactionType(String desc){
		this.description = desc;
	}
	
	public String getDescription(){
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
