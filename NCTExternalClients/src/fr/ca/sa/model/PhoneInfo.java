package fr.ca.sa.model;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

public class PhoneInfo implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private String phone;
	private String phoneCountryCode;
	private String phoneCallNumber;
	private String phoneNumber;
	
	public PhoneInfo() {
		
	}
			
	public PhoneInfo(String phone, String phoneCountryCode, String phoneCallNumber, String phoneNumber) {
		super();
		this.phone = phone;
		this.phoneCountryCode = phoneCountryCode;
		this.phoneCallNumber = phoneCallNumber;
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPhoneCountryCode() {
		return phoneCountryCode;
	}
	
	public void setPhoneCountryCode(String phoneCountryCode) {
		this.phoneCountryCode = phoneCountryCode;
	}
	
	public String getPhoneCallNumber() {
		return phoneCallNumber;
	}
	
	public void setPhoneCallNumber(String phoneCallNumber) {
		this.phoneCallNumber = phoneCallNumber;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "PhoneInfo [phone=" + phone + ", phoneCountryCode=" + phoneCountryCode + ", phoneCallNumber="
				+ phoneCallNumber + ", phoneNumber=" + phoneNumber + "]";
	}
}
