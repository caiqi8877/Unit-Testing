import static org.junit.Assert.*;

import org.junit.Test;

public class AddressTest {

  @Test
  public void testAddress() {
    Address address = new Address("1 East 1 St.", "Apt. B", "New York",
        "NY", "10001");
    assertTrue(address.equals(address));
    assertEquals("1 East 1 St.", address.getAddress1());
    assertEquals("Apt. B", address.getAddress2());
    assertEquals("New York", address.getCity());
    assertEquals("NY", address.getState());
    assertEquals("10001", address.getZipCode());
  }
}
