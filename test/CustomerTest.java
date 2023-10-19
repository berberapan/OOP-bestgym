import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer c = new Customer("8905270312", "Testman Testsson", "2021-01-15");

    @Test
    public void getPnTest() {
        assertEquals(8905270312L, c.getPersonalIdNumber());
        assertNotEquals(0, c.getPersonalIdNumber());
    }
    @Test
    public void getNameTest() {
        assertEquals("Testman Testsson", c.getName());
        assertEquals(16, c.getName().length());
    }
    @Test
    public void getMembershipDateTest() {
        assertEquals(LocalDate.of(2021,1,15), c.getMembershipDate());
    }
}