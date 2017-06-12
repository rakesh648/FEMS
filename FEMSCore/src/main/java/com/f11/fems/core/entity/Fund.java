package com.f11.fems.core.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.f11.fems.core.entity.type.FundSource;

@Entity	
public class Fund {
	
	@Id
	@GeneratedValue
	Long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(nullable = false)
	Owner owner;
	
	@Enumerated(EnumType.STRING)
	@Column (nullable=false)
	FundSource fundSource;
	
	Date availableFrom;
	String remarks;
	
	@Column (nullable=false)
	Double amount;
	
	@Column (nullable=false)
	Double consumed;
	
	@Column (nullable=false)
	Double available;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	

	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public FundSource getFundSource() {
		return fundSource;
	}
	public void setFundSource(FundSource fundSource) {
		this.fundSource = fundSource;
	}
	public Date getAvailableFrom() {
		return availableFrom;
	}
	public void setAvailableFrom(Date availableFrom) {
		this.availableFrom = availableFrom;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public Double getConsumed() {
		return consumed;
	}
	
	public Double getAvailable() {
		return available;
	}
	
	public void  setConsumed(Double consumed) {
		this.consumed = consumed;
	}
	
	public void setAvailable(Double available) {
		this.available = available;
	}
	
	public void consumeFund(Double amount){
		this.available -= amount;
		this.consumed  += amount;
	}
	
	@Override
	public String toString() {
		return "Fund [fundId=" + id + ", owner=" + owner + ", fundSource=" + fundSource + ", availableFrom="
				+ availableFrom + ", remarks=" + remarks + ", amount=" + amount + "]";
	}

}
