package com.f11.fems.core.entity.type;

public enum TransactionGroup {
	
	PLAN("Plan"), EXPENSE("Expense");
	
	private String description;
	
	TransactionGroup(String desc){
		this.description = desc;
	}
	
	public String getDescription(){
		return description;
	}

}
