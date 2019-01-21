package org.fivelands.parser.model.impl;

import org.fivelands.parser.model.ContactInfo;

/**
 * ContactInfo Implementation class
 * Entity class to store contact info
 * @author rkcullen
 * @version 1.0
 */
public class ContactInfoImpl implements ContactInfo {

	private String name;
	private String phoneNumber;
	private String emailAddress;
	
	/**
	 * Constructor
	 * @param String name
	 * @param String phoneNumber
	 * @param String emailAddress
	 */
	public ContactInfoImpl(String name, String phoneNumber, String emailAddress) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	
	/**
	 * Gets the full name
	 * @return String name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Gets the phone number
	 * @return String phoneNumber
	 */
	@Override
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Gets the email address
	 * @return String emailAddress
	 */
	@Override
	public String getEmailAddress() {
		return emailAddress;
	}

}
