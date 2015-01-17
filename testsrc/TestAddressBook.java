import static org.junit.Assert.*;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * TestAddressBook Class is a class for testing AddressBook object. 
 * It could test emptyAddressBookWithName(), addContact(), removeContact(), searchForContactContaining(),
 * retrieveAddressBookByName(), saveAddressBook() methods
 * It also could test the toString() methods
 * 
 * @author Qi Cai
 * 
 */
public class TestAddressBook {
	private AddressBook addressBook;
	private Contact contact;
  private String name = "QiCai";
  private String email = "qc319@nyu.edu";
	private PhoneNumber phoneNumber;
	private short areaCode = 609;
	private short prefix = 613;
	private short lineNumber = 7206;
	private String note = "Test";
	private Address address;
	private String address1 = "55 River Driver South";
  private String address2 = "Apt 1214";
  private String city = "Jersey City";
  private String state = "New Jersey";
  private String zipCode = "07310";
  private PhoneNumber onePhoneNumber;
  private Address oneAddress;
  private Contact oneContact;
  private List<Contact> contacts;
	
  /**
	 * build two AddressBook objects
	 * and an object of type ArrayList<Contact>
	 */
  @Before
	public void SetUp(){ 
	  phoneNumber = new PhoneNumber(areaCode, prefix, lineNumber);
		address = new Address(address1,address2,city,state,zipCode);
		contact = new Contact(name,email,phoneNumber,note,address);
		
		onePhoneNumber = new PhoneNumber(100,544,2223);
		oneAddress = new Address("4 East 2 St", "Apt 10","New York", "NY", "10001");
		oneContact = new Contact("Lucy","cai@gmail.com",onePhoneNumber,"Text",oneAddress);
		
		contacts = new ArrayList<Contact>();
	}

	@After
	public void tearDown(){
		
	}
	/**
	 * when testing an whether the addressbook is empty or not, we first create one, add a contact, then
	 * calling the method, if the method works, removing the previous added contact would return false
	 */
	
	@Test
	public void testEmptyAddressBookWithName(){
		AddressBook addressBook = new AddressBook("cai");
		addressBook.addContact(contact);
		//addressBook contains "contact", when emptyAddressBookWithName is called, the function empty the addressbook,
		//so addressBook2 does not contains contact
		AddressBook addressBook2 = AddressBook.emptyAddressBookWithName("cai");
		Assert.assertFalse(addressBook2.removeContact(contact));
	}
	
	/**
	 * when test addContact(),
	 * could add a contact twice, the second time it will return false, and will return true if remove the contact
	 */
	@Test
	public void testAddContact(){
		AddressBook addressBook = AddressBook.emptyAddressBookWithName("cai");
		addressBook.addContact(oneContact);
		// can not add the same contact again
		Assert.assertFalse(addressBook.addContact(oneContact));
		// if successfully added, then can be removed
		Assert.assertTrue(addressBook.removeContact(oneContact));
	}
//	
	/**
	 * when testing removeContact, could first add a contact and then remove it twice, first time
	 * will return true(successfully deleted) and second time will return false(nonexisted)
	 */
	@Test
	public void testRemoveContact(){
		AddressBook addressBook = new AddressBook("test");
		addressBook.addContact(oneContact);
		//Add the "oneContact", so when remove "contact", return false
		Assert.assertFalse(addressBook.removeContact(contact));
		Assert.assertTrue(addressBook.removeContact(oneContact));
		Assert.assertFalse(addressBook.removeContact(oneContact));
	}
//	
	/**
	 * when testing searchForContactContaining() method, just add two contacts and then search one phoneNumber
	 * in "oneContact" because it will return a list<contact> which contains only one contact "oneContact";
	 */
	@Test
	public void testSearchForContactContaining(){
		AddressBook addressBook = new AddressBook("qi");
		addressBook.addContact(contact);
		addressBook.addContact(oneContact);
		assertEquals(oneContact,addressBook.searchForContactContaining("544-2223").get(0));
	}
//	
	/**
	 * call the method which write the object to the file and then read it, should return the 
	 * previous object
	 * @throws IOException
	 */
	@Test
	public void testSaveAddressBook() throws IOException{
		AddressBook addressBook = new AddressBook("caiqi");
		addressBook.addContact(this.contact);
		addressBook.saveAddressBook();
		
		FileInputStream fileInput = new FileInputStream("caiqi" + ".xml"); 
    XMLDecoder xmlDecoder = new XMLDecoder(fileInput);
    List<Contact> contacts = (List<Contact>) xmlDecoder.readObject();
    xmlDecoder.close();
    
    Assert.assertTrue(this.contact.equals(contacts.get(0)));
	}
//	
	@Test
	/**
	 * call the method which read the object from the file, then using searchForContactContaining() method
	 * to compare it to the aimed contact "this.contact"; Actually, the test method should be operate after 
	 * testSaveAddressBook() method, because only after that method do the caiqi.xml file existed.
	 * @throws IOException
	 */
	public void testRetrieveAddressBookByName() throws IOException{
		AddressBook addressBook2 = addressBook.retrieveAddressBookByName("caiqi");
		List<Contact> contacts = addressBook2.searchForContactContaining("07310");
		Assert.assertTrue(this.contact.equals(contacts.get(0)));
		
	}
	
	/**
	 * test whether it return the aimed string
	 */
	@Test
	public void testToString(){
		AddressBook addressBook = new AddressBook("caiqi");
		assertEquals("caiqi",addressBook.toString());
	}
}

