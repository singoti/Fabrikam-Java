package com.fabrikam.common;

public class Customer {
	
	private int id;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public Customer(int id,String firstName,String lastName,
			String street,String city,String state,String zip){
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.street=street;
		this.city=city;
		this.state=state;
		this.zip=zip;
	}
	
	public Customer(String firstName,String lastName,
			String street,String city,String state,String zip){
		this.id=0;
		this.firstName=firstName;
		this.lastName=lastName;
		this.street=street;
		this.city=city;
		this.state=state;
		this.zip=zip;
	}
	
	public Customer(int id,String firstName,String lastName,
			String street){
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.street=street;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

}
