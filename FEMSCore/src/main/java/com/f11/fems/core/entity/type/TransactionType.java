package com.f11.fems.core.entity.type;

public enum TransactionType {
	
	CHEQUE("Cheque",TransactionGroup.EXPENSE),
	CASH("Cash",TransactionGroup.EXPENSE), 
	ONLINE("Online",TransactionGroup.EXPENSE), 
	PLAN("Plan",TransactionGroup.PLAN);
	
	private String description;
	private TransactionGroup transactionGroup;
	
	TransactionType(String desc, TransactionGroup g){
		this.description = desc;
		this.transactionGroup = g;
	}
	
	public String getDescription(){
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TransactionGroup getTransactionGroup() {
		return transactionGroup;
	}

	public void setTransactionGroup(TransactionGroup transactionGroup) {
		this.transactionGroup = transactionGroup;
	}	

}
