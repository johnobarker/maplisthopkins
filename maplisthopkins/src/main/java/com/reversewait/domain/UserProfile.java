package com.reversewait.domain;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserProfile  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private ObjectId id;
	
	private BusinessSize businessSize;
	private int numberOfSites;
	private String imageUrl;
	
	
	public UserProfile() {this.id = ObjectId.get();}

	
	public BusinessSize getBusinessSize() {
		return businessSize;
	}
	public void setBusinessSize(BusinessSize businessSize) {
		this.businessSize = businessSize;
	}
	public int getNumberOfSites() {
		return numberOfSites;
	}
	public void setNumberOfSites(int numberOfSites) {
		this.numberOfSites = numberOfSites;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
