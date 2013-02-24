package com.reversewait.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserSite implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;

	private String siteName;
	private String contactUserName;
	private String contactPassword;
	private String contactName;
	private String contactAddress1;
	private String contactAddress2;
	private String contactCity;
	private String contactState;
	private String contactZip;
	private String contactEmail;
	private String contactPhone1;
	private String contactPhone2;
	
	
	public UserSite() {}
	
	public UserSite (String siteName, String contactUserName, String contactPassword) {
		this.siteName = siteName;
		this.contactUserName = contactUserName;
		this.contactPassword = contactPassword;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getContactUserName() {
		return contactUserName;
	}

	public void setContactUserName(String contactUserName) {
		this.contactUserName = contactUserName;
	}

	public String getContactPassword() {
		return contactPassword;
	}

	public void setContactPassword(String contactPassword) {
		this.contactPassword = contactPassword;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactAddress1() {
		return contactAddress1;
	}

	public void setContactAddress1(String contactAddress1) {
		this.contactAddress1 = contactAddress1;
	}

	public String getContactAddress2() {
		return contactAddress2;
	}

	public void setContactAddress2(String contactAddress2) {
		this.contactAddress2 = contactAddress2;
	}

	public String getContactCity() {
		return contactCity;
	}

	public void setContactCity(String contactCity) {
		this.contactCity = contactCity;
	}

	public String getContactState() {
		return contactState;
	}

	public void setContactState(String contactState) {
		this.contactState = contactState;
	}

	public String getContactZip() {
		return contactZip;
	}

	public void setContactZip(String contactZip) {
		this.contactZip = contactZip;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone1() {
		return contactPhone1;
	}

	public void setContactPhone1(String contactPhone1) {
		this.contactPhone1 = contactPhone1;
	}

	public String getContactPhone2() {
		return contactPhone2;
	}

	public void setContactPhone2(String contactPhone2) {
		this.contactPhone2 = contactPhone2;
	}

}
