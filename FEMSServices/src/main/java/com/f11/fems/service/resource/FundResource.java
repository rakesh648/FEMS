package com.f11.fems.service.resource;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.f11.fems.core.entity.Fund;

@XmlRootElement
public class FundResource extends ResourceSupport{

	FundResource(){
		
	}
	
	Fund fund;

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public FundResource(Fund fund,Link... links){		
		this.fund = fund;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return fund.toString() +" "+ super.toString();
	}


}



