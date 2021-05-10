package com.socialmediapost.fb.dto;

public class Address {
	private String city;
	private String latitude;
	private String longitude;
	private String region;
	private String country;
	private String street_address;
	
	
	public Address() {
		super();
	}
	public Address(String city, String latitude, String longitude, String region, String country,
			String street_address) {
		super();
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
		this.region = region;
		this.country = country;
		this.street_address = street_address;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	
	
}
