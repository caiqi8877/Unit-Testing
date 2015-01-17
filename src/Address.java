/**
 * A class method for an address in the United States.
 * 
 * @author Darren Levy
 *
 */
public final class Address {
  private String address1;
  private String address2;
  private String city;
  private String state;
  private String zipCode;
  
  /**
   * A simple empty constructor is required to make this class a
   * JavaBean.
   */
  public Address() {
    super();
  }

  /**
   * A constructor of an address.
   * 
   * @param address1 street number of the address
   * @param address2 apartment or suite number of the address
   * @param city the city of the address
   * @param state the state of the address
   * @param zipCode the zip code of the address
   */
  public Address(String address1, String address2, String city,
      String state, String zipCode) {
    this.setAddress1(address1);
    this.setAddress2(address2);
    this.setCity(city);
    this.setState(state);
    this.setZipCode(zipCode);
  }

  /**
   * @return the address's address1
   */
  public String getAddress1() {
    return address1;
  }

  /**
   * @param address1 the address's address1
   */
  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  /**
   * @return the address's address2
   */
  public String getAddress2() {
    return address2;
  }

  /**
   * @param address2 the address's address2
   */
  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  /**
   * @return the address's city
   */
  public String getCity() {
    return city;
  }

  /**
   * @param city the address's city
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @return the address's state
   */
  public String getState() {
    return state;
  }

  /** 
   * @param state the address's state
   */
  public void setState(String state) {
    this.state = state;
  }

  /** 
   * @return the address's zip code
   */
  public String getZipCode() {
    return zipCode;
  }

  /**
   * @param zipCode the address's zip code
   */
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }
  
  /**
   * As noted in Item 8 of "Effective Java" you should override
   * equals when "a class has a notion of logical equality that
   * differs from mere object identify and a superclass has
   * not already overridden equals to implement the desired behavior."
   * 
   * @param an object to check equality to this Address
   * @return true if the objects are equal and false if they are not
   */
  @Override public boolean equals (Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Address)){
      return false;
    }
    Address address = (Address)o;
    return address.getAddress1().equals(address1) &&
        address.getAddress2().equals(address2) &&
        address.getCity().equals(city) &&
        address.getState().equals(state) &&
        address.getZipCode().equals(zipCode);
  }
  
  /**
   * Overriding hashcode to ensure equal objects have equal hashcodes.
   * This is Item 9 in "Effective Java."
   * 
   * @return the hashcode result
   */
  @Override public int hashCode() {
    int result = 17;
    result = 31 * result + this.address1.hashCode();
    result = 31 * result + this.address2.hashCode();
    result = 31 * result + this.city.hashCode();
    result = 31 * result + this.state.hashCode();
    result = 31 * result + this.state.hashCode();
    return result;
  }
  
  /**
   * Overriding the toString method to include the entire address
   * 
   * @return a human readable form of the address
   */
  @Override public String toString() {
    return this.address1 + " " + this.address2 + "\n" +
           this.city + ", " + this.state + " " + this.zipCode;
  }
}
