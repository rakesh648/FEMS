package com.f11.fems.core.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@DiscriminatorValue(value = "ONLINE")
@XmlRootElement
public class OnlineTransaction extends Transaction{
	
}
