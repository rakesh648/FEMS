package com.f11.fems.service.resource;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.f11.fems.core.entity.Owner;

@XmlRootElement
public class OwnerResource extends ResourceSupport  {
	
	OwnerResource(){
		
	}
	
	Owner owner;

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public OwnerResource(Owner owner,Link... links){		
		this.owner = owner;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return owner.toString() +" "+ super.toString();
	}

}
