package com.iliass.app.webServices.Responses;

import java.util.List;

import com.iliass.app.webServices.Requests.AdresseRequest;

public class UserResponse {

	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private Boolean admin;
	private List<AdresseRequest> addresses;
	private ContactResponse contact;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<AdresseRequest> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AdresseRequest> addresses) {
		this.addresses = addresses;
	}
	public ContactResponse getContact() {
		return contact;
	}
	public void setContact(ContactResponse contact) {
		this.contact = contact;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	
	
	
}
