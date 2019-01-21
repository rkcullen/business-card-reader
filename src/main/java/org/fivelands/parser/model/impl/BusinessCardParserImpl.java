package org.fivelands.parser.model.impl;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;

import org.fivelands.parser.model.BusinessCardParser;
import org.fivelands.parser.model.ContactInfo;
import org.fivelands.parser.enums.Filters;

/**
 * Business Card Implementation class
 * @author rkcullen
 * @version 1.0
 */
public class BusinessCardParserImpl implements BusinessCardParser {

	/**
	 * Main logic to extract contact information from business card text
	 * @param String document -- entire business card text
	 * @return ContactInfo contactInfo
	 * @throws Exception
	 */
	@Override
	public ContactInfo getContactInfo(String document) throws Exception {

		List<String> tokens = Arrays.asList(document.split("\n"));
		
		String emailAddress = "<?email address>";
		try {
			emailAddress = Filters.filterEmail(tokens);
		} catch (Exception e) {
			System.out.println("Your business card is missing an email address!");
			throw new Exception("Business card is incomplete!");
		}
		
		String phoneNumber = "<?phone number>";
		try {
			phoneNumber = Filters.filterPhone(tokens);
		} catch (Exception e) {
			System.out.println("Your business card is missing a phone number!");
		}
		
		String firstLastName = Filters.filterFullName(tokens, getCorrectedNameRegexFromEmail(emailAddress).get());

		return new ContactInfoImpl(firstLastName, phoneNumber, emailAddress);
	}
	
	/**
	 * Logic to construct regular expression depending on name of email address
	 * @param String emailAddress
	 * @return Optional<String> regex
	 */
	private Optional<String> getCorrectedNameRegexFromEmail(String emailAddress) {
		String name = emailAddress.substring(0, emailAddress.indexOf("@"));
		String[] nameTokens = name.trim().split("[_.]");
		if(nameTokens.length == 1){
			//This is a first initial last name email address
			return Optional.of(name.substring(0,1) + ".*\\s" + name.substring(1, name.length()));
		} else {
			return Optional.of(nameTokens[0].substring(0,1) + ".*\\s" +  nameTokens[1]);
		}
	}
}
