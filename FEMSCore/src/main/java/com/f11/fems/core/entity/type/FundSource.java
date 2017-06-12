package com.f11.fems.core.entity.type;

public enum FundSource {
	
	LOAN("Loan"),SAVING("Saving"),OTHER("Other");
	
	private String description;
	
	FundSource(String desc){
		this.description = desc;
	}
	
	public String getDescription(){
		return description;
	}

}
