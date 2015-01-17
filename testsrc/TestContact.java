import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * TestContace Class is a class for testing Contact object. 
 * It could test getName(), getPhoneNumber(), getNote(), getAddress(), getEmail() and
 * setName(), setPhoneNumber(), setNote(), setAddress(), setEmail() methods
 * It also could test the toString(), hashCode(), equals() methods
 * 
 * @author Qi Cai
 * 
 */
public class TestContact {
	private Contact contact;
	private Contact oneContact;
  private String name = "QiCai";
  private String email = "qc319@nyu.edu";
  private PhoneNumber phoneNumber ;
  private String note = "Test";
  private Address address;

  /**
	 * build two Contact objects
	 * 
	 */
	@Before
	public void setUp(){
		phoneNumber = new PhoneNumber(609,613,7206);
		address = new Address("55 River Drive South", "Apt 1214",
        "Jersey City", "New Jersey", "07310");
		contact = new Contact(name,email,phoneNumber,note,address);
		oneContact = new Contact(name,email,phoneNumber,note,address);
  
	}
	
	@After
	public void tearDown(){
		
	}
	
	@Test
	public void testgetName(){
		assertEquals(this.name,contact.getName());
	}
	
	/**
	 * test Whether the testgetPhoneNumber() method can get excepted result
	 */
	@Test
	public void testgetPhoneNumber(){
		assertEquals(this.phoneNumber,contact.getPhoneNumber());
	}
	
	/**
	 * test Whether the GetNote() method can get excepted result
	 */
	@Test
	public void testgetNote(){
		assertEquals(this.note,contact.getNote());
	}
	
	/**
	 * test Whether the GetAddress() method can get excepted result
	 */
	@Test
	public void testgetAddress(){
		assertEquals(this.address,contact.getAddress());
	}
	
	/**
	 * test Whether the GetEmail() method can get excepted result
	 */
	@Test
	public void testgetEmail(){
		assertEquals(this.email,contact.getEmail());
	}
	
	/**
	 * test Whether the SetName() method can get excepted result
	 */
	@Test
	public void testsetName(){
		contact.setName("limengyao");
		assertEquals("limengyao",contact.getName());
	}
	
	/**
	 * test Whether the SetEmail() method can get excepted result
	 */
	@Test
	public void testsetEmail(){
		contact.setEmail("caiqi8877@gmail.com");
		assertEquals("caiqi8877@gmail.com",contact.getEmail());
	}
	
	/**
	 * test Whether the SetPhoneNumber() method can get excepted result
	 */
	@Test
	public void testsetPhoneNumber(){
		contact.setPhoneNumber(new PhoneNumber(900,900,9060));
		assertEquals(new PhoneNumber(900,900,9060),contact.getPhoneNumber());
	}
	
	/**
	 * test Whether the setNote() method can get excepted result
	 */
	@Test
	public void testsetNote(){
		contact.setNote("NotTest");
		assertEquals("NotTest",contact.getNote());
	}
	
	/**
	 * test Whether the setAddress() method can get excepted result
	 */
	@Test
	public void testsetAddress(){
		contact.setAddress(new Address("5 East 6 St.", "Apt 1003","New York", "NY", "10001"));
		assertEquals(new Address("5 East 6 St.", "Apt 1003","New York", "NY", "10001"),contact.getAddress());
	}
	
	/**
	 * Here we consider 4 conditions which are displayed below
	 */
	
	@Test
	public void testEquals(){
		Assert.assertTrue(oneContact.equals(contact));
		Assert.assertTrue(contact.equals(contact));
		Assert.assertFalse(contact.equals("4"));
		contact.setAddress(new Address("100 West 5 St.", "Apt 1003","New York", "NY", "10043"));
		Assert.assertFalse(contact.equals(oneContact));
	}
	
	/**
	 * test Whether the hashCode method can get excepted result, test both for true condition and false condition
	 */
	@Test
	public void testHashCode(){
		phoneNumber = new PhoneNumber(609,613,7206);
		address = new Address("55 River Drive South", "Apt 1214",
        "Jersey City", "New Jersey", "07310");
		contact = new Contact(name,email,phoneNumber,note,address);
		Contact secContact = new Contact("Yao",email,phoneNumber,note,address);
		Assert.assertTrue(contact.hashCode() == (oneContact).hashCode() );
		Assert.assertFalse(secContact.hashCode() == (contact).hashCode() );
	}
	
	/**
	 * test Whether the toString method can get excepted result
	 */
	@Test
	public void testToString(){
		assertEquals(this.name + "\n" + this.phoneNumber + "\n" + this.address 
				                   + "\n" + this.note, oneContact.toString());
	}
	
}
