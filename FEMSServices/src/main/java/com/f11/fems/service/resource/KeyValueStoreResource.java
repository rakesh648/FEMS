package com.f11.fems.service.resource;

import org.springframework.hateoas.ResourceSupport;

public class KeyValueStoreResource extends ResourceSupport{

	private String key;
	private String value;
	
	public KeyValueStoreResource(String k, String v){
		this.key =k;
		this.value = v;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
