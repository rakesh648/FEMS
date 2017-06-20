
package com.f11.fems.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Owner   {
	
	@Id
	@GeneratedValue
	private Long id;	
	@Column (nullable=false)
	private String name;
	
	@Column (nullable=false)
	private String phone;	
	
	@Column (nullable=false)
	private String email;
	
	@ManyToOne(optional = false)
	@JoinColumn(nullable = false)
	OwnerGroup group;
	
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public OwnerGroup getGroup() {
		return group;
	}

	public void setGroup(OwnerGroup group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Owners [ownerId=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}

	
	
}
