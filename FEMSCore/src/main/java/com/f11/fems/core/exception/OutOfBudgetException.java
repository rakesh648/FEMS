package com.f11.fems.core.exception;

public class OutOfBudgetException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Double available, transaction;
	
	public OutOfBudgetException(Double available, Double transaction){
		this.available= available;
		this.transaction = transaction;
	}
	
	@Override
	public String getMessage() {
		return "Transaction ("+ this.transaction+") exceeds fund availability ("+this.available+")";
	}

}
