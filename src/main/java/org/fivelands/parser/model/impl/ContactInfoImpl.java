package org.fivelands.parser.model.impl;

import org.fivelands.parser.model.ContactInfo;

/**
 * ContactInfo Implementation class
 * @author rkcullen
 * @version 1.0
 */
public class ContactInfoImpl implements ContactInfo {

	private String name;
	private String phoneNumber;
	private String emailAddress;
	
	public ContactInfoImpl(String name, String phoneNumber, String emailAddress) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public String getEmailAddress() {
		return emailAddress;
	}

}
