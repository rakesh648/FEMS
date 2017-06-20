package com.f11.fems.core.entity.type;

public enum TransactionStatus {
	
	INITIATED("Initiated"), 
	PROCESSED("Processed"),
	PLANNED("Planned"),
	EXECUTED("Executed");
	
	private String description;
	
	TransactionStatus(String desc){
		this.description = desc;
	}
	
	public String getDescription(){
		return description;
	}


}
