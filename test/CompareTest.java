import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompareTest {

    Compare c = new Compare();
    CustomerInput i = new CustomerInput();
    Path path = Paths.get("test/test_data/test.txt");
    List<Customer> testList = i.generateCustomerList(path);

    CompareTest() throws Exception {
    }
    @Test
    public void isNameInCustomerListTest()  {
        Customer c1 = c.isNameInCustomerList("diamanda djedi", testList);
        Customer c2 = c.isNameInCustomerList("testman testsson", testList);

        assertEquals("Diamanda Djedi", c1.getName());
        assertNull(c2);
    }
    @Test
    public void isPINInCustomerListTest() {
        Customer c1 = c.isPINInCustomerList(7703021234L, testList);
        Customer c2 = c.isPINInCustomerList(1L, testList);

        assertEquals(7703021234L, c1.getPersonalIdNumber());
        assertNull(c2);
    }
    @Test
    public void isCustomerACurrentMember() {
        Customer c1 = testList.get(0);
        Customer c2 = testList.get(2);
        Customer c3 = new Customer("6502136845", "Sten Sture", LocalDate.now().minusYears(1).toString());

        assertTrue(c.isCustomerACurrentMember(c1));
        assertFalse(c.isCustomerACurrentMember(c2));
        assertTrue(c.isCustomerACurrentMember(c3));
    }
}