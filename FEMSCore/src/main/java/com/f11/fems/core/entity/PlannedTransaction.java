package com.f11.fems.core.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PLAN")
public class PlannedTransaction extends Transaction {

}
