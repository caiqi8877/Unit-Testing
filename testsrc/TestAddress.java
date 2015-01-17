import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * TestAddress Class is a class for testing Address object. 
 * It could test getaddress1(), getaddress2(), getCity(), getState(), getZipCode and
 * setaddress1(), setaddress2(), setCity(), setState(), setZipCode() methods
 * It also could test the toString(), hashCode(), equals() methods
 * 
 * @author Qi Cai
 * 
 */
public class TestAddress {
	private Address address;
  private String address1 = "55 River Driver South";
  private String address2 = "Apt 1214";
  private String city = "Jersey City";
  private String state = "New Jersey";
  private String zipCode = "07310";
	private Address oneAddress ;
	
	/**
	 * build two address object
	 * 
	 */
	@Before
	public void setUp(){
		address = new Address(address1,address2,city,state,zipCode);
		oneAddress = new Address(address1,address2,city,state,zipCode);
	}
	
	@After
	public void tearDown(){
		
	}
	/**
		* test Whether the getAddress1() method can get excepted result
		*/
	@Test
	public void testgetAddress1(){
		assertEquals(this.address1,address.getAddress1());
	}

	/**
	* test Whether the getAddress2() method can get excepted result
	*/	
	@Test
	public void testgetAddress2(){
		assertEquals(this.address2,address.getAddress2());
	}
	
	/**
	* test Whether the getCity() method can get excepted result
	*/
	@Test
	public void testgetCity(){
		assertEquals(this.city,address.getCity());
	}

	/**
	* test Whether the getState() method can get excepted result
	*/
	@Test
	public void testgetState(){
		assertEquals(this.state,address.getState());
	}
	
	/**
	* test Whether the getZipCode() method can get excepted result
	*/
	@Test
	public void testgetZipCode(){
		assertEquals(this.zipCode,address.getZipCode());
	}
	
	/**
	* test Whether the setAddress1() method can get excepted result
	*/
	@Test
	public void testSetAddress1(){
		address.setAddress1("100 River");
		assertEquals("100 River",address.getAddress1());
	}
	
	/**
	* test Whether the setAddress2() method can get excepted result
	*/
	@Test
	public void testSetAddress2(){
		address.setAddress2("Apt 1990");
		assertEquals("Apt 1990",address.getAddress2());
	}
	
	/**
	* test Whether the setCity() method can get excepted result
	*/
	@Test
	public void testSetCity(){
		address.setCity("New York");
		assertEquals("New York",address.getCity());
	}
	
	/**
	* test Whether the setState() method can get excepted result
	*/
	@Test
	public void testSetState(){
		address.setState("California");
		assertEquals("California",address.getState());
	}
	
	/**
	* test Whether the setZipCode() method can get excepted result
	*/
	@Test
	public void testSetZipCode(){
		address.setZipCode("10009");
		assertEquals("10009",address.getZipCode());
	}
	
	/**
	 * Here we consider 4 conditions which are displayed below
	 */
	@Test
	public void testEquals(){
		Assert.assertTrue(new Address(address1,address2,city,state,zipCode).equals(oneAddress));
		Assert.assertTrue(oneAddress.equals(address));
		//"66" not instance of Address class
		Assert.assertFalse(oneAddress.equals("66"));
		address.setZipCode("32324");
		Assert.assertFalse(oneAddress.equals(address));
	}
	
	/**
	 * test Whether the hashCode method can get excepted result, test both for true condition and false condition
	 */
	@Test
	public void testHashCode(){
		Assert.assertTrue(new Address(address1,address2,city,state,zipCode).hashCode() == (oneAddress).hashCode() );
		Assert.assertFalse(new Address(address2,address1,city,state,zipCode).hashCode() == (oneAddress).hashCode() );
	}
	
	/**
	 * test Whether the toString method can get excepted result
	 */
	@Test
	public void testToString(){
		assertEquals(this.address1 + " " + this.address2 + "\n" +
        this.city + ", " + this.state + " " + this.zipCode, oneAddress.toString());
	}
	
}
