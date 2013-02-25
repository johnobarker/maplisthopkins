package com.reversewait.domain;

public enum BusinessSize {
	BUSINESS_SIZE_1_5 ("1 to 5 Locations"),
	BUSINESS_SIZE_6_10 ("6 to 10 Locations"),
	BUSINESS_SIZE_11_20 ("11 to 20 Locations"),
	BUSINESS_SIZE_21_50 ("21 to 50 Locations"),
	BUSINESS_SIZE_51_100 ("51 to 100 Locations"),
	BUSINESS_SIZE_100_PLUS ("100 or more Locations");
	
	private final String type;
	
	private BusinessSize(String type)	{this.type = type;}
	
	public String getType()				{return this.type;}	
}

