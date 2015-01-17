import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * TestPhoneNumber Class is a class for testing PhoneNumber object. 
 * It could test getAreaCode, getPrefix, getLineNumber and setAreaCode, setPrefix, setLineNumber methods
 * It also could test the toString, hashCode, equals methods
 * 
 * @author Qi Cai
 * 
 */

public class TestPhoneNumber {
	private PhoneNumber phoneNumber;
	private PhoneNumber onePhoneNumber;
	private short areaCode = 609;
	private short prefix = 613;
	private short lineNumber = 7026;
	
	/**
	 * build two phoneNumber objects
	 * 
	 */
	@Before
	public void setUp(){
		phoneNumber = new PhoneNumber(areaCode, prefix, lineNumber);
		onePhoneNumber = new PhoneNumber(areaCode,prefix,lineNumber);
	}
	
	@After
	public void tearDown(){
		
	}
	
	/**
	 * test Whether the getAreaCode method can get excepted result
	 */
	@Test
	public void testgetAreaCode(){
		assertEquals(areaCode,phoneNumber.getAreaCode());
	}
	
	/**
	 * test Whether the getPrefix method can get excepted result
	 */
	@Test
	public void testgetPrefix(){
		assertEquals(prefix,phoneNumber.getPrefix());
	}
	
	/**
	 * test Whether the getLineNumber method can get excepted result
	 */
	@Test
	public void testgetLineNumber(){
		assertEquals(lineNumber,phoneNumber.getLineNumber());
	}
	
	/**
	 * test Whether the setAreaCode method can get excepted result
	 */
	@Test 
	public void testsetAreaCode(){
		phoneNumber.setAreaCode(111);
		assertEquals(111,phoneNumber.getAreaCode());
	}
	
	/**
	 * test Whether the setPrefix method can get excepted result
	 */
	@Test 
	public void testsetPrefix(){
		phoneNumber.setPrefix(222);
		assertEquals(222,phoneNumber.getPrefix());
	}
	
	/**
	 * test Whether the setLineNumber method can get excepted result
	 */
	@Test 
	public void testsetLineNumber(){
		phoneNumber.setLineNumber(2200);
		assertEquals(2200,phoneNumber.getLineNumber());
	}
	
	/**
	 * Here we consider 4 conditions which are displayed below
	 */
	@Test
	public void testEquals(){
		Assert.assertTrue(new PhoneNumber(areaCode,prefix,lineNumber).equals(onePhoneNumber));
		Assert.assertTrue(onePhoneNumber.equals(phoneNumber));
	//"5" not instance of PhoneNumber class
		Assert.assertFalse(onePhoneNumber.equals("5"));
		phoneNumber.setLineNumber(7722);
		Assert.assertFalse(onePhoneNumber.equals(phoneNumber));
	}
	
	/**
	 * test Whether the hashCode method can get excepted result, test both for true condition and false condition
	 */
	@Test
	public void testHashCode(){
		Assert.assertTrue(new PhoneNumber(areaCode,prefix,lineNumber).hashCode() == (onePhoneNumber).hashCode() );
		Assert.assertFalse(new PhoneNumber(areaCode,prefix,lineNumber - 1).hashCode() == (onePhoneNumber).hashCode() );
	}
	
	/**
	 * test Whether the toString method can get excepted result
	 */
	@Test
	public void testToString(){
		assertEquals("(" + areaCode + ") " + prefix + "-" + lineNumber, onePhoneNumber.toString());
	}
	
}
