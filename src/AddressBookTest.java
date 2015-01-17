import static org.junit.Assert.*;

import org.junit.Test;

public class AddressBookTest {

  @Test
  public void testAddressBook() {
    AddressBook addressBook = AddressBook.emptyAddressBookWithName("test");
    Address address = new Address("1 East 1 St.", "",
        "New York", "NY", "10001");
    PhoneNumber phoneNumber = new PhoneNumber(555, 44, 1234);
    Contact contact = new Contact("Darren Levy", "",
       phoneNumber, "test", address);
    Address address2 = new Address("5 West 5 St.", "",
        "New York", "NY", "10001");
    PhoneNumber phoneNumber2 = new PhoneNumber(555, 34, 3224);
    Contact contact2 = new Contact("Ed Stark", "",
       phoneNumber2, "test", address2);
    addressBook.addContact(contact);
    addressBook.addContact(contact2);
    assertEquals(contact,
        addressBook.searchForContactContaining("darren").get(0));
    addressBook.removeContact(contact);
    assertTrue(addressBook.searchForContactContaining("darren").size() == 0);
    assertEquals("test", addressBook.toString());
  }
}
