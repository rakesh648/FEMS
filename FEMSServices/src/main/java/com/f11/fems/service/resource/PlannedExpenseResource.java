package com.f11.fems.service.resource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.hateoas.ResourceSupport;

import com.f11.fems.core.entity.PlannedExpense;
import com.f11.fems.core.entity.type.BuildingArea;
import com.f11.fems.core.entity.type.ExpenseCategory;

public class PlannedExpenseResource extends ResourceSupport{	

	private Long planId;
	
	@NotNull
	private String name;
	
	@NotNull
	private ExpenseCategory category;
	
	@NotNull
	private BuildingArea buildingArea;
	
	@NotNull
	private Double amount;
	
	@Size(max=200)
	String remarks;		
	
	public PlannedExpenseResource(PlannedExpense expense){
		this.amount = expense.getAmount();
		this.buildingArea = expense.getBuildingArea();
		this.category = expense.getCategory();
		this.planId = expense.getId();
		this.name = expense.getName();
		this.remarks = expense.getRemarks();
	}

	
	PlannedExpenseResource(){
		
	}


	public Long getPlanId() {
		return planId;
	}


	public void setPlanId(Long planId) {
		this.planId = planId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ExpenseCategory getCategory() {
		return category;
	}


	public void setCategory(ExpenseCategory category) {
		this.category = category;
	}


	public BuildingArea getBuildingArea() {
		return buildingArea;
	}


	public void setBuildingArea(BuildingArea buildingArea) {
		this.buildingArea = buildingArea;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public PlannedExpense buildPlannedExpenseEntity() {
		PlannedExpense expense = new PlannedExpense();
		expense.setId(this.planId);
		expense.setName(this.name);
		expense.setCategory(this.category);
		expense.setBuildingArea(this.buildingArea);
		expense.setAmount(this.amount);
		expense.setRemarks(this.remarks);	
		return expense;
	}
	
}