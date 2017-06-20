package com.f11.fems.core.util;

import com.f11.fems.core.entity.type.ExpenseCategory;

public class PlanSummaryVo {
	
	ExpenseCategory category;
	Double amount;
	
	public PlanSummaryVo(ExpenseCategory category, Double amount){
		this.category= category;
		this.amount = amount;
	}

	public ExpenseCategory getCategory() {
		return category;
	}

	public void setCategory(ExpenseCategory category) {
		this.category = category;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
