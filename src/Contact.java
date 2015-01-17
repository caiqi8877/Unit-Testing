import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class method for contact.
 * This method can be subclassed to allow for more types
 * of contacts with more properties.
 * 
 * The valid email regex was found online.
 * 
 * @author Darren Levy
 * @version 1.0
 *
 */
public class Contact {
  private String name;
  private String email;
  private PhoneNumber phoneNumber;
  private String note;
  private Address address;
  private static final String VALID_EMAIL_REGEX =
      "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
      + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
  
  /**
   * A simple empty constructor is required to make this class a JavaBean.
   */
  public Contact() {
    super();
  }

  /**
   * A constructor for a contact.
   * 
   * @param name the name of the contact
   * @param email the email address of the contact
   * @param phoneNumber the phone number of the contact
   * @param note a note for the contact
   * @param address an address for the contact
   */
  public Contact(String name, String email,
      PhoneNumber phoneNumber, String note, Address address) {
    this.setName(name);
    this.setEmail(email);
    this.setPhoneNumber(phoneNumber);
    this.setNote(note);
    this.setAddress(address);
  }

  /** 
   * @return the contact's name
   */
  public String getName() {
    return name;
  }

  /** 
   * @param name the contact's name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the contact's email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the contact's email
   */
  public void setEmail(String email) {
    validateEmail(email);
    this.email = email;
  }
  
  /**
   * This method validates an email. Emails have a certain format
   * and should include an at symbol and a domain among other
   * defining characteristics.
   * 
   * @param email an email to validate
   * @return true if the email is valid, false if it is not.
   */
  private static boolean validateEmail(String email) {
    Pattern pattern = Pattern.compile(VALID_EMAIL_REGEX);
    Matcher matcher = pattern.matcher(email);
    if (email.equals(null) || email.equals("") || matcher.matches()) {
      return true;
    }
    else {
      throw new IllegalArgumentException("Invalid email: " + email);
    }
    
  }

  /**
   * @return the contact's phone number as a phone number object
   */
  public PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * @param phoneNumber the contact's phone number
   */
  public void setPhoneNumber(PhoneNumber phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * @return the contact's note
   */
  public String getNote() {
    return note;
  }

  /**
   * @param note the contact's note
   */
  public void setNote(String note) {
    this.note = note;
  }

  /**
   * @return the contact's address as an address object
   */
  public Address getAddress() {
    return address;
  }

  /**
   * @param address the contact's address
   */
  public void setAddress(Address address) {
    this.address = address;
  }
  
  /**
   * As noted in Item 8 of "Effective Java" you should override
   * equals when "a class has a notion of logical equality that
   * differs from mere object identify and a superclass has
   * not already overridden equals to implement the desired behavior."
   * 
   * @param an object to check equality to this Contact
   * @return true if the objects are equal and false if they are not
   */
  @Override public boolean equals (Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Contact)){
      return false;
    }
    Contact contact = (Contact)o;
    return contact.getName().equals(name) &&
        contact.getEmail().equals(email) && 
        contact.getPhoneNumber().equals(phoneNumber) &&
        contact.getNote().equals(note) &&
        contact.getAddress().equals(address);
  }
  
  /**
   * Overriding hashcode to ensure equal objects have equal hashcodes.
   * This is Item 9 in "Effective Java."
   * 
   * @return the hashcode result
   */
  @Override public int hashCode() {
    int result = 17;
    result = 31 * result + this.name.hashCode();
    result = 31 * result + this.email.hashCode();
    result = 31 * result + this.phoneNumber.hashCode();
    result = 31 * result + this.phoneNumber.hashCode();
    result = 31 * result + this.address.hashCode();
    return result;
  }
  
  /**
   * This method overrides the toString method to include all the
   * properties of the contact.
   * 
   * @return a string with all the details of the contact.
   */
  @Override public String toString() {
    return this.name + "\n" +
        this.phoneNumber + "\n" + this.address + "\n" + this.note;
  }
}
