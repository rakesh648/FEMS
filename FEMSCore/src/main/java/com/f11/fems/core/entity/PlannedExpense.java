
package com.f11.fems.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.f11.fems.core.entity.type.BuildingArea;
import com.f11.fems.core.entity.type.ExpenseCategory;

@Entity
public class PlannedExpense   {
	
	@Id
	@GeneratedValue
	private Long id;	
	
	@Column (nullable=false)
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column (nullable=false)
	private ExpenseCategory category;
	
	@Enumerated(EnumType.STRING)
	@Column (nullable=false)
	private BuildingArea buildingArea;
	
	@Column (nullable=false)
	private Double amount;
	
	private String remarks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "PlannedExpense [id=" + id + ", name=" + name + ", category=" + category + ", buildingArea="
				+ buildingArea + ", amount=" + amount + ", remarks=" + remarks + "]";
	}	
}
