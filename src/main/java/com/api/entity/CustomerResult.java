package com.api.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerResult {
	
	private String fullName;
	@JsonFormat(pattern="dd MMM yyyy")
	private Date birthDate;
	private String addressLine1;
	private String postCode;
	private int customerNumber;
	private int storeNumber;
	
	public CustomerResult(Customer customer) {
		this.fullName = customer.getFirstName() + " " + customer.getLastName();
		this.birthDate = customer.getBirthDate();
		this.addressLine1 = customer.getAddressByType("Home").getFirstLine();
		this.postCode = customer.getAddressByType("Home").getPostCode();
		this.storeNumber = customer.getActiveStore().getStoreNumber();
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	public int getStoreNumber() {
		return storeNumber;
	}
	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}
	
	
	

}
