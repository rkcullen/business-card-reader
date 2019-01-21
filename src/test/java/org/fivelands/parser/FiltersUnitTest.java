package org.fivelands.parser;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.fivelands.parser.enums.Filters;

/**
 * Filters Unit Tests
 * @author rkcullen
 * @version 1.0
 */
public class FiltersUnitTest {
	
	private List<String> tokens1 = Arrays.asList("John Doe", "Foo Tech" , "jdoe@footech.com", "Tel: 301-555-2029");
	private List<String> tokens2 = Arrays.asList("Dave Navarro", "FooBar Tech" , "david_navarro@gmail.com", "cell: 301-555-0987");
	
	
	@Test
	public void testEmailFilterTokens() {
		assertEquals("jdoe@footech.com", Filters.filterEmail(tokens1));
		assertEquals("david_navarro@gmail.com", Filters.filterEmail(tokens2));
	}
	
	@Test
	public void testPhoneFilterTokens() {
		assertEquals("3015552029", Filters.filterPhone(tokens1));
		assertEquals("3015550987", Filters.filterPhone(tokens2));
	}
	
	@Test
	public void testNameFilterTokens() {
		assertEquals("Dave Navarro", Filters.filterFullName(tokens2, getCorrectedRegex(tokens2).get()));
		assertEquals("John Doe", Filters.filterFullName(tokens1, getCorrectedRegex(tokens1).get()));
	}
	
	private Optional<String> getCorrectedRegex(List<String> tokens) {
		String emailAddress = Filters.filterEmail(tokens);
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
