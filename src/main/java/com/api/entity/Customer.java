package com.api.entity;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	@JsonFormat(pattern="dd MMM yyyy")
	private Date birthDate;
	private String gender;
	@OneToMany(mappedBy = "customer")
	private List<CustomerStore> customerStores;
	private String salutation;
	//Possible unneeded
	private String status;
	@JsonFormat(pattern="dd MMM yyyy")
	private Date nextPackIssueDate;
	@JsonFormat(pattern="dd MMM yyyy")
	private Date clensCheckDate;
	@OneToMany(mappedBy = "customer")
	private List<Address> address;
	@OneToOne(mappedBy = "customer")
	private Email email;
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public Email getEmail() {
		return email;
	}
	public String getEmailAsString() {
		if (email != null)
			return email.getEmailAddress();
		return "";
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	public List<Telephone> getTelephone() {
		return telephone;
	}
	public void setTelephone(List<Telephone> telephone) {
		this.telephone = telephone;
	}
	@OneToMany(mappedBy = "customer")
	private List<Telephone> telephone;
	
	public List<CustomerStore> getCustomerStores() {
		return customerStores;
	}
	public Store getActiveStore() {
		for(CustomerStore customerStore: customerStores) {
			if(customerStore.getType().equalsIgnoreCase("Active"))
					return customerStore.getStore();
		}
		return new Store();
	}
	public void setCustomerStores(List<CustomerStore> customerStores) {
		this.customerStores = customerStores;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getNextPackIssueDate() {
		return nextPackIssueDate;
	}
	public String getNextPackIssueDateAsString() {
		return formatDate(nextPackIssueDate);
	}
	public void setNextPackIssueDate(Date nextPackIssueDate) {
		this.nextPackIssueDate = nextPackIssueDate;
	}
	public Date getclensCheckDate() {
		return clensCheckDate;
	}
	public String getclensCheckDateAsString() {
		return formatDate(clensCheckDate);
	}
	public void setclensCheckDate(Date clensCheckDate) {
		this.clensCheckDate = clensCheckDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public String getBirthDateAsString() {
		return formatDate(birthDate);
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	private String formatDate(Date date) {
		if(date != null)
			return date.toInstant().atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
		return "";
	}
	public Telephone getTelephoneByType(int type) {
		for(Telephone phone: telephone)
			if (phone.getType() == type)
				return phone;
		return new Telephone();
	}
	public Address getAddressByType(String addressType) {
		for(Address addr: address)
			if (addr.getAddressType().equalsIgnoreCase(addressType))
				return addr;
		return new Address();
	}

	
	
	

}
