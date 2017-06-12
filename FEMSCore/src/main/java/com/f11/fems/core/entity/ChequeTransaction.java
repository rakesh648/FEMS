package com.f11.fems.core.entity;

import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHEQUE")

public class ChequeTransaction extends Transaction{

	String chequeNumber;
	String chequeTo;
	Date chequeDate;
	String bank;
	Date deductedOn;
	
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
}
