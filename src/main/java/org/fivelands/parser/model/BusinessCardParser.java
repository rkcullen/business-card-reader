package org.fivelands.parser.model;

@FunctionalInterface
public interface BusinessCardParser {
	
	ContactInfo getContactInfo(String document) throws Exception;
}
