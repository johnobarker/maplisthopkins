package com.reversewait.domain;

import java.io.Serializable;

public class UserProfile  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private BusinessSize businessSize;
	private String imageUrl;	
	
	public BusinessSize getBusinessSize() {
		return businessSize;
	}
	public void setBusinessSize(BusinessSize businessSize) {
		this.businessSize = businessSize;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
