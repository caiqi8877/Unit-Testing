/**
 * This code was taken almost directly from our textbook,
 * "Effective Java" pages 45-52. Changes were made to make the
 * class a JavaBean.
 * It is a class for a United States phone number.
 * Area code is the first 3 digits of a phone number.
 * Prefix is the next 3 digits after the area code.
 * Line number is the last 4 digits of the phone number.
 * 
 * @author Joshua Block ("Effective Java: Second Edition")
 * 
 */
public final class PhoneNumber {
  private short areaCode;
  private short prefix;
  private short lineNumber;
  
  /**
   * A simple empty constructor is required to make this class a JavaBean.
   */
  public PhoneNumber() {
    super();
  }
  
  /**
   * A constructor for a phone number.
   * 
   * @param areaCode a positive integer less than 1,000
   * @param prefix a positive integer less than 1,000
   * @param lineNumber a positive integer less than 10,000
   */
  public PhoneNumber(int areaCode, int prefix, int lineNumber) {
    this.setAreaCode(areaCode);
    this.setPrefix(prefix);
    this.setLineNumber(lineNumber);
  }
  
  /**
   * @return the phone number's area code
   */
  public int getAreaCode() {
    return (int) areaCode;
  }
  
  /**
   * @param areaCode the phone number's area code
   */
  public void setAreaCode(int areaCode) {
    rangeCheck(areaCode,   999,  "area code");
    this.areaCode = (short) areaCode;
  }
  
  /**
   * @return the phone number's prefix
   */
  public int getPrefix() {
    return (int) prefix;
  }
  
  /**
   * @param areaCode the phone number's prefix
   */
  public void setPrefix(int prefix) {
    rangeCheck(prefix,     999,  "prefix");
    this.prefix = (short) prefix;
  }
  
  /**
   * @return the phone number's line number
   */
  public int getLineNumber() {
    return (int) lineNumber;
  }

  /**
   * @param areaCode the phone number's line number
   */
  public void setLineNumber(int lineNumber) {
    rangeCheck(lineNumber, 9999, "line number");
    this.lineNumber = (short) lineNumber;
  }
  
  /**
   * This method ensures the numbers saved are valid phone number properties
   * 
   * @param arg the property of the phone number
   * @param max the maximum value of the property
   * @param name the name of the property in case an error needs to be thrown
   */
  private static void rangeCheck(int arg, int max, String name) {
    if (arg < 0 || arg > max) {
      throw new IllegalArgumentException(name + ": " + arg);
    }
  }
  
  /**
   * As noted in Item 8 of "Effective Java" you should override
   * equals when "a class has a notion of logical equality that 
   * differs from mere object identify and a superclass has
   * not already overridden equals to implement the desired behavior."
   * 
   * @param an object to check equality to this PhoneNumber
   * @return true if the objects are equal and false if they are not
   */
  @Override public boolean equals (Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof PhoneNumber)) {
      return false;
    }
    PhoneNumber phoneNumber = (PhoneNumber)o;
    return phoneNumber.getAreaCode() == areaCode &&
        phoneNumber.getLineNumber() == lineNumber &&
        phoneNumber.getPrefix() == prefix;
  }
  
  /**
   * Overriding hashcode to ensure equal objects have equal hashcodes.
   * This is Item 9 in "Effective Java."
   * 
   * @return the hashcode result
   */
  @Override public int hashCode() {
    int result = 17;
    result = 31 * result + areaCode;
    result = 31 * result + prefix;
    result = 31 * result + lineNumber;
    return result;
  }
  
  /**
   * Overriding the toString method to show the phone number
   * in a standard way.
   * Zeros are added to the front of the properties if needed.
   */
  @Override public String toString() {
    return String.format("(%03d) %03d-%04d", areaCode, prefix, lineNumber);
  }
}
