package com.f11.fems.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Q_SUMMARY_CONTRIBUTION")
public class ContributionSummary {
	
	@Id
	@Column(name="id")
	String id;
	
	@Column(name="key")
	String key;
	
	@Column(name="group_name")
	String groupName;
	
	@Column(name="val")
	Double value;

	public String getKey() {
		return key;
	}

	public String getGroupName() {
		return groupName;
	}

	public Double getValue() {
		return value;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
