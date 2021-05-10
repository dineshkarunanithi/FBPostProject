package com.socialmediapost.fb.dto;

import java.util.List;

public class PostHomeListingCommerceManagerRequest {

	private String access_token;
	private String item_type;
	private String home_listing_id;
	private Address address;
	private List<Images> images;
	private String availability;
	private String name;
	private String currency;
	private String price;
	private String url;
	private String year_built;
	
	public PostHomeListingCommerceManagerRequest() {
		super();
	}

	public PostHomeListingCommerceManagerRequest(String access_token, String item_type, String home_listing_id,
			Address address, List<Images> images, String availability, String name, String currency, String price,
			String url, String year_built) {
		super();
		this.access_token = access_token;
		this.item_type = item_type;
		this.home_listing_id = home_listing_id;
		this.address = address;
		this.images = images;
		this.availability = availability;
		this.name = name;
		this.currency = currency;
		this.price = price;
		this.url = url;
		this.year_built = year_built;
	}



	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getItem_type() {
		return item_type;
	}

	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}

	public String getHome_listing_id() {
		return home_listing_id;
	}

	public void setHome_listing_id(String home_listing_id) {
		this.home_listing_id = home_listing_id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Images> getImages() {
		return images;
	}

	public void setImages(List<Images> images) {
		this.images = images;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getYear_built() {
		return year_built;
	}

	public void setYear_built(String year_built) {
		this.year_built = year_built;
	}

}
