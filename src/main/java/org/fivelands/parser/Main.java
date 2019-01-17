package org.fivelands.parser;

import org.fivelands.parser.model.ContactInfo;
import org.fivelands.parser.model.BusinessCardParser;
import org.fivelands.parser.model.impl.BusinessCardParserImpl;
import org.fivelands.parser.model.impl.ContactInfoImpl;

/**
 * Entry point for application
 * @author rkcullen
 * @version 1.0
 *
 */
public class Main {
	
    public static void main( String[] args ){
    	ContactInfo info = parseDocument(args[0], p -> new BusinessCardParserImpl().getContactInfo(p));
    	
    	System.out.println("Name: " + info.getName() + "\n" 
    			+ "Phone: " + info.getPhoneNumber() + "\n" 
    			+ "Email: " + info.getEmailAddress());
    }
    
    private static ContactInfo parseDocument(String text, BusinessCardParser parser) {
        try {
			return parser.getContactInfo(text);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ContactInfoImpl("<missing>", "<missing>", "<missing>");
		}
    }
    
    
}
