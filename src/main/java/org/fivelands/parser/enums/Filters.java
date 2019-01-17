package org.fivelands.parser.enums;

import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.List;

public enum Filters {
	
	EMAIL(Pattern.compile("^(.*@.*)$").asPredicate()),
	PHONE(Pattern.compile("(\\(\\d{3}\\)|\\d{3}-)\\s?\\d{3}-\\d{4}").asPredicate());
	
	private Predicate<String> predicate;
	
	private Filters(Predicate<String> predicate){
		this.predicate = predicate;
	}
	
	private Predicate<String> getPredicate(){
		return this.predicate;
	}
	
	/**
	 * 
	 * @param List tokens
	 * @return String emailAddress
	 */
	public static String filterEmail(List<String> tokens) {
		
		return tokens
				.stream()
				.filter(EMAIL.getPredicate())
				.findFirst()
				.get();
	}

	/**
	 * 
	 * @param List tokens
	 * @return String phoneNumber
	 */
	public static String filterPhone(List<String> tokens) {
	
	    return tokens
	            .stream()
	            .filter(PHONE.getPredicate())
	            .filter(s -> s.matches("(?!Fax|fax|FAX).*"))
	            .findFirst()
	            .get()
	            .replaceAll("[^\\d.]", "");
	
	}

	/**
	 * 
	 * @param List tokens
	 * @param String regex
	 * @return String name
	 */
	public static String filterFullName(List<String> tokens, String regex) {
	
	    return tokens
	            .stream()
	            .filter(s -> s.matches("(?i)" + regex))
	            .findFirst()
	            .get();
	
	}

}
