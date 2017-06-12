package com.f11.fems.core.entity.type;

public enum BuildingArea {
	COMMON("Common"), FL_0("Ground Floor"), FL_1("First Floor"),FL_2("Second Floor"),FL_3("3rd Floor");
	
	private String description;
	
	BuildingArea(String desc){
		this.description = desc;
	}
	
	public String getDescription(){
		return description;
	}	

}
