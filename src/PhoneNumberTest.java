import static org.junit.Assert.*;

import org.junit.Test;

public class PhoneNumberTest {

  @Test
  public void testPhoneNumber() {
    PhoneNumber phoneNumber = new PhoneNumber(555, 44, 1234);
    assertTrue(phoneNumber.equals(phoneNumber));
    assertEquals(555, phoneNumber.getAreaCode());
    assertEquals(44, phoneNumber.getPrefix());
    assertEquals(1234, phoneNumber.getLineNumber());
    assertEquals("(555) 044-1234", phoneNumber.toString());
  }
}
