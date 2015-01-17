import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;

/**
 * AddressBook class contains the main API methods needed for the
 * AddressBook.
 * You can create an empty address book, add an entry, remove an entry, 
 * search for an entry, save the address book to an XML file and read 
 * the address book from an XML file.
 * 
 * In order for the saving and reading to and from XML to work the
 * Contact class and all its properties must be a JavaBean.
 * 
 * @author Darren Levy
 * @version 1.0
 * 
 */
public final class AddressBook {
  private List<Contact> contacts = new ArrayList<Contact>();
  private final String name;
  
  /**
   * A constructor for AddressBook
   * 
   * @param name a way to identify the address book.
   * The name is used in the file name when the address book is saved.
   */
  public AddressBook(String name) {
    this.name = name;
  }
  
  /**
   * Item 1 in Effective Java is: "Consider static factory methods 
   * instead of constructors."
   * This is one such method. By writing a static factory method,
   * the method name is much more descriptive.
   * Here we create a new empty address book with name passed as
   * a parameter.
   * 
   * @param name a way to identify the address book.
   * The name is used in the file name when the
   * address book is saved.
   * @return an empty address book
   */
  public static AddressBook emptyAddressBookWithName(String name) {
    return new AddressBook(name);
  }
  
  /** 
   * This method adds a contact to the address,
   * unless the contact is already in the address book.
   * 
   * @param contact the contact to be added to the address book.
   * @return true if the contact was added otherwise false
   * because the contact was not valid for this address book.
   */
  public boolean addContact(Contact contact) {
    if (this.validContactToAddToAddressBook(contact)) {
      this.contacts.add(contact);
      return true;
    }
    else {
      this.contacts.add(contact);
      return false;
    }
  }
  
  /**
   * This method validates if the contact can be added to this
   * address book or not.
   * 
   * @param contact the contact to test if it can be added
   * @return true if it can be added and false if it cannot be added
   */
  private boolean validContactToAddToAddressBook(Contact contact) {
    if (this.contacts.contains(contact) ||
        contact.getName().equals(null) || contact.getName().equals("")) {
      return false;
    }
    else {
      return true;
    }
  }
  
  /**
   * This method removes a contact from the address book if
   * it is in the address book.
   * 
   * @param contact the contact to be removed from the address book.
   * @return true if the contact was removed, otherwise false
   * because the contact was not in the address book.
   */
  public boolean removeContact(Contact contact) {
    if (this.contacts.contains(contact)) {
      this.contacts.remove(contact);
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * This method searches for a contact by a query string.
   * We check if any contact in the address book contains the query
   * string. If so, we add that contact to the list of contacts
   * we will return.
   * 
   * @param query a string containing the search query for
   * the address book.
   * @return a list of contacts containing the query string.
   */
  public List<Contact> searchForContactContaining(String query) {
    List<Contact> contactResults = new ArrayList<Contact>();
    for (Contact contact : this.contacts) {
      if (contact.toString().toLowerCase().contains(query)){
        contactResults.add(contact);
      }        
    }
    return contactResults;
  }

  /**
   * This method saves the address book to an XML file.
   * The filename uses the name of the address book.
   */
  public void saveAddressBook() {
    try {
      XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
          new FileOutputStream(name + ".xml")));
      encoder.writeObject(this.contacts);
      encoder.close();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * This static method retrieves the address book by its name.
   * @param name the name of the address book to retrieve.
   * @return the AddressBook that was saved on disk and is now
   * being retrieved.
   */
  public static AddressBook retrieveAddressBookByName(String name) {
    try {
      FileInputStream fileInput = new FileInputStream(name + ".xml"); 
      XMLDecoder xmlDecoder = new XMLDecoder(fileInput);
      List<Contact> contacts = (List<Contact>) xmlDecoder.readObject();
      xmlDecoder.close();
      AddressBook addressBook = AddressBook.emptyAddressBookWithName(name);
      addressBook.setContacts(contacts);
      return addressBook;
    } catch(Exception e) {
      e.printStackTrace();
      return null;
    } 
  }
  
  /**
   * This private method is used to set the contacts of the
   * address book.
   * 
   * @param contacts the contacts to set as this address book's
   * contacts.
   */
  private void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }
  
  /**
   * Returns the name of the address book.
   * 
   * The name can be used to retrieve the address book at a later
   * date as it is the filename on disk that contains the last version
   * of the address book that was saved.
   */
  @Override public String toString() {
    return this.name;
  }
}
