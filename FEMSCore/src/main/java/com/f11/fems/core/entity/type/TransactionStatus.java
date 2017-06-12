package com.f11.fems.core.entity.type;

public enum TransactionStatus {
	
	INITIATED("Initiated",TransactionGroup.EXPENSE), 
	PROCESSED("Processed",TransactionGroup.EXPENSE),
	PLANNED("Planned",TransactionGroup.PLAN),
	EXECUTED("Executed",TransactionGroup.PLAN);
	
	private String description;
	private TransactionGroup transactionGroup;
	
	TransactionStatus(String desc, TransactionGroup transactionGroup){
		this.description = desc;
		this.transactionGroup = transactionGroup;
	}
	
	public String getDescription(){
		return description;
	}

	public TransactionGroup getTransactionGroup() {
		return transactionGroup;
	}

	public void setTransactionGroup(TransactionGroup transactionGroup) {
		this.transactionGroup = transactionGroup;
	}

}
