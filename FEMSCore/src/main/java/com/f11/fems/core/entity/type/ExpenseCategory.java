package com.f11.fems.core.entity.type;

public enum ExpenseCategory {
	
	DEMOLITION("Demolition"),CONSTRUCTION("Construction"),INTERIOR("Interior");
	
	private String description;
	
	ExpenseCategory(String desc){
		this.description = desc;
	}
	
	public String getDescription(){
		return description;
	}
	

}
