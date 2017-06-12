package com.f11.fems.service.resource;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.hateoas.ResourceSupport;

import com.f11.fems.core.entity.CashTransaction;
import com.f11.fems.core.entity.ChequeTransaction;
import com.f11.fems.core.entity.Fund;
import com.f11.fems.core.entity.OnlineTransaction;
import com.f11.fems.core.entity.Owner;
import com.f11.fems.core.entity.PlannedTransaction;
import com.f11.fems.core.entity.Transaction;
import com.f11.fems.core.entity.type.BuildingArea;
import com.f11.fems.core.entity.type.ExpenseCategory;
import com.f11.fems.core.entity.type.TransactionGroup;
import com.f11.fems.core.entity.type.TransactionStatus;
import com.f11.fems.core.entity.type.TransactionType;

public class TransactionResource extends ResourceSupport{	

	Long transactionId;
	
	@NotNull
	TransactionType transactionType;
	
	TransactionGroup transactionGroup;
	
	@NotNull
	ExpenseCategory category;
	
	@NotNull
	BuildingArea buildingArea;
	
	@NotNull
	Fund fund;
	
	@NotNull
	Date transactionDate;
	
	@NotNull
	Double amount;
	
	@NotNull
	@Size(max=30)
	String receiver;
	
	
	Owner authorizedBy;
	
	@NotNull
	TransactionStatus status;
	
	@Size(max=200)
	String remarks;		
	
	@Size(max=30)
	String chequeNumber;
	
	@Size(max=30)
	String chequeTo;
	
	Date chequeDate;
	
	@Size(max=30)
	String bank;
	
	Date deductedOn;
	
		
	public void addCommonElements(Transaction transaction){
		this.transactionId = transaction.getId();
		this.transactionType = transaction.getTransactionType();
		this.transactionGroup = transaction.getTransactionGroup();
		this.category = transaction.getCategory();
		this.buildingArea = transaction.getBuildingArea();
		this.fund = transaction.getFund();
		this.transactionDate = transaction.getTransactionDate();
		this.amount = transaction.getAmount();
		this.receiver= transaction.getReceiver();
		this.authorizedBy = transaction.getAuthorizedBy();
		this.status = transaction.getStatus();
		this.remarks = transaction.getRemarks();		
	}
	
	public TransactionResource(CashTransaction transaction){
		addCommonElements(transaction);
	}	
	
	public TransactionResource(ChequeTransaction transaction){
		addCommonElements(transaction);
		this.chequeNumber = transaction.getChequeNumber();
		this.chequeTo = transaction.getChequeTo();
		this.chequeDate = transaction.getChequeDate();
		this.bank = transaction.getBank();
		this.deductedOn = transaction.getDeductedOn();
	}

	public TransactionResource(PlannedTransaction transaction){
		addCommonElements(transaction);
	}
	
	public TransactionResource(OnlineTransaction transaction){
		addCommonElements(transaction);
	}
	
	TransactionResource(){
		
	}
	
	public Transaction fetchTransactionInstancess(){
		Transaction transaction = null;
		
		switch(transactionType){
			case CHEQUE : ChequeTransaction chequeTransaction = new ChequeTransaction(); 
							chequeTransaction.setChequeNumber( this.chequeNumber);
							chequeTransaction.setChequeTo(this.chequeTo);;
							chequeTransaction.setChequeDate(this.chequeDate);
							chequeTransaction.setBank(this.bank);
							chequeTransaction.setDeductedOn(this.deductedOn);
							transaction = chequeTransaction;
							break;
			case CASH : CashTransaction cashTransaction = new CashTransaction(); 
						 transaction = cashTransaction;
						  break;
			case ONLINE : OnlineTransaction onlineTransaction = new OnlineTransaction(); 
			 				transaction = onlineTransaction;
			 				break;
			case PLAN : PlannedTransaction plannedTransaction = new PlannedTransaction(); 
							transaction = plannedTransaction;
							break;
			default:
				break;
		}	
		
		transaction.setId(this.transactionId);
		transaction.setTransactionType(this.transactionType);
		transaction.setCategory(this.category);
		transaction.setBuildingArea(this.buildingArea);
		transaction.setFund(fund);
		transaction.setTransactionDate(this.transactionDate);
		transaction.setAmount(this.amount);
		transaction.setReceiver(this.receiver);
		transaction.setAuthorizedBy(this.authorizedBy);
		transaction.setStatus(this.status);
		transaction.setRemarks(this.remarks);	
		
		return transaction;
		
	}
	
	
	public String getChequeNumber() {
		return chequeNumber;
	}
	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	public String getChequeTo() {
		return chequeTo;
	}
	public void setChequeTo(String chequeTo) {
		this.chequeTo = chequeTo;
	}
	public Date getChequeDate() {
		return chequeDate;
	}
	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public Date getDeductedOn() {
		return deductedOn;
	}
	public void setDeductedOn(Date deductedOn) {
		this.deductedOn = deductedOn;
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

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
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
	}

	public TransactionGroup getTransactionGroup() {
		return transactionGroup;
	}

}