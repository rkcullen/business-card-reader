package org.fivelands.parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.List;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.junit.Test;
import org.junit.Before;
import org.fivelands.parser.model.BusinessCardParser;
import org.fivelands.parser.model.ContactInfo;
import org.fivelands.parser.model.impl.BusinessCardParserImpl;
import org.fivelands.parser.model.impl.ContactInfoImpl;




/**
 * Unit tests
 * @author rkcullen
 * @version 1.0
 */
public class BusinessCardParserImplUnitTest {
	
	private static final String BUSINESS_CARD_ONE = 
			"ASYMMETRIK LTD\n"
			+ "Mike Smith\n"
			+ "Senior Software Engineer\n"
			+ "(410)555-1234\n"
			+ "msmith@asymmetrik.com";
	
	private static final String BUSINESS_CARD_TWO =
			"Foobar Technologies\n"
			+ "Analytic Developer\n"
			+ "Lisa Haung\n"
			+ "1234 Sentry Road\n"
			+ "Columbia, MD 12345\n"
			+ "Phone: 410-555-1234\n"
			+ "Fax: 410-555-4321\n"
			+ "lisa.haung@foobartech.com";
	
	private static final String BUSINESS_CARD_THREE =
			"Arthur Wilson\n"
			+ "Software Engineer\n"
			+ "Decision & Security Technologies\n"
			+ "ABC Technologies\n"
			+ "123 North 11th Street\n"
			+ "Suite 229\n"
			+ "Arlington, VA 22209\n"
			+ "Tel: +1 (703) 555-1259\n"
			+ "Fax: +1 (703) 555-1200\n"
			+ "awilson@abctech.com";
	
	@Mock
	private ContactInfo contactInfo;
	
	@Mock
	private BusinessCardParserImpl businessCardParser;
	
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void givenReturnOfTypeWhenMocked() throws Exception {
		
		ContactInfo contact = new ContactInfoImpl("John Doe", "301-555-1222", "jdoe@gmail.com");
		
		when(businessCardParser.getContactInfo("John Doe\nSofware Engineer")).thenReturn(contact);
				
		assertEquals(businessCardParser.getContactInfo("John Doe\nSofware Engineer"), contact);
	}
	
	@Test
	public void testSizeOfList() throws Exception {
		
		businessCardParser.getContactInfo("Document");
		
		Mockito.verify(businessCardParser).getContactInfo("Document");
		
		assertEquals(businessCardParser.getContactInfo("Document"), null);
	}
	
	@Test
	public void testBusinessCardTextOne() throws Exception {
		ContactInfo info = parseDocument(BUSINESS_CARD_ONE, p -> new BusinessCardParserImpl().getContactInfo(p));
		assertEquals(info.getName(), "Mike Smith");
		assertEquals(info.getPhoneNumber(),"4105551234");
		assertEquals(info.getEmailAddress(), "msmith@asymmetrik.com");
	}
	
	@Test
	public void testBusinessCardTextTwo() throws Exception {
		ContactInfo info = parseDocument(BUSINESS_CARD_TWO, p -> new BusinessCardParserImpl().getContactInfo(p));
		assertEquals(info.getName(), "Lisa Haung");
		assertEquals(info.getPhoneNumber(),"4105551234");
		assertEquals(info.getEmailAddress(), "lisa.haung@foobartech.com");
	}
	
	@Test
	public void testBusinessCardTextThree() throws Exception {
		ContactInfo info = parseDocument(BUSINESS_CARD_THREE, p -> new BusinessCardParserImpl().getContactInfo(p));
		assertEquals(info.getName(), "Arthur Wilson");
		assertEquals(info.getPhoneNumber(),"17035551259");
		assertEquals(info.getEmailAddress(), "awilson@abctech.com");
	}
	
	
	private ContactInfo parseDocument(String text, BusinessCardParser parser) throws Exception {
		return parser.getContactInfo(text);
	}

}
