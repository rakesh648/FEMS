package com.f11.fems.core.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.f11.fems.core.entity.type.BuildingArea;
import com.f11.fems.core.entity.type.ExpenseCategory;
import com.f11.fems.core.entity.type.TransactionGroup;
import com.f11.fems.core.entity.type.TransactionStatus;
import com.f11.fems.core.entity.type.TransactionType;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name="TRANSACTION_TYPE",  discriminatorType=DiscriminatorType.STRING )
public abstract class Transaction {
	
	@Id
	@GeneratedValue
	@Column (nullable=false)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column (name ="TRANSACTION_TYPE", insertable = false, updatable = false,nullable=false)
	private TransactionType transactionType;
	
	@Column (nullable=false)
	@Enumerated(EnumType.STRING)
	private TransactionGroup transactionGroup;

	@Enumerated(EnumType.STRING)
	@Column (nullable=false)
	private ExpenseCategory category;
	
	@Enumerated(EnumType.STRING)
	@Column (nullable=false)
	private BuildingArea buildingArea;
	
	@ManyToOne(optional = false)
	@JoinColumn(nullable = false)
	private Fund fund;
	
	@Column (nullable=false)
	private Date transactionDate;
		
	@Column (nullable=false)
	private Double amount;
	
	@Column (nullable=false)
	private String receiver;
	
	@ManyToOne
	private Owner authorizedBy;
	
	@Column (nullable=false)
	@Enumerated(EnumType.STRING)
	private TransactionStatus status;
	
	private String remarks;		
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public Owner getAuthorizedBy() {
		return authorizedBy;
	}

	public void setAuthorizedBy(Owner authorizedBy) {
		this.authorizedBy = authorizedBy;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}
	
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
		this.transactionGroup = transactionType.getTransactionGroup();
	}

	public final TransactionGroup getTransactionGroup() {
		return transactionGroup;
	}	
	
}
