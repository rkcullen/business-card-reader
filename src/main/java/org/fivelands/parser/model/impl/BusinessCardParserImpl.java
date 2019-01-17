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
 *
 */
public class BusinessCardParserImpl implements BusinessCardParser {

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
		
		String filter = emailAddress.substring(0, emailAddress.indexOf("@"));
		Optional<String> regex = Optional.empty();
		if(filter.indexOf(".") > 0) {
		    String[] emailTokens = filter.trim().split("\\.");
		    regex = Optional.of(emailTokens[0] + "\\s" + emailTokens[1]);
		} else {
		    regex = Optional.of(filter.substring(0,1) + ".*\\s" + filter.substring(1, filter.length()));
		}

		String firstLastName = Filters.filterFullName(tokens, regex.get());

		return new ContactInfoImpl(firstLastName, phoneNumber, emailAddress);
	}
}
