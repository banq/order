package com.jdon.ecomm.order.domain;


import org.springframework.data.annotation.Id;

/**
 * @author banq
 * @version 1.0
 * @created 14-12��-2018 14:40:26
 */
public class Address {

	@Id
	private String id;
	private String street;
	private String zip;

	public Address() {

	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}