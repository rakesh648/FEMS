package com.f11.fems.core.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@DiscriminatorValue(value = "CASH")
@XmlRootElement
public class CashTransaction extends Transaction{
	
}
