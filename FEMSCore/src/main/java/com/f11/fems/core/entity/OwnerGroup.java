package com.f11.fems.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class OwnerGroup {

	@Id
	@GeneratedValue
	private Long id;	
	
	@Column (nullable=false)
	private String name;
	
	@Column (nullable=false)
	@Type(type="yes_no")
	private boolean isGiftContributor;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean getIsGiftContributor() {
		return isGiftContributor;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIsGiftContributor(boolean isGiftContributor) {
		this.isGiftContributor = isGiftContributor;
	}

}
