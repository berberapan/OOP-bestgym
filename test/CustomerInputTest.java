import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerInputTest {

    CustomerInput c = new CustomerInput();
    Path path = Paths.get("test/test_data/test.txt");
    Path incorrectPath = Paths.get("test/test_data/test.zip");
    Path dirtyData = Paths.get("test/test_data/testtext.txt");
    Path incorrectFile = Paths.get("test/test_data/incorrecttest.txt");

    @Test
    public void generateCustomerListTest() throws Exception{

        List<Customer> testList = c.generateCustomerList(path);
        LocalDate date1 = LocalDate.of(2018,3,12);

        assertEquals("alhambra aromes", testList.get(0).getName());
        assertEquals(7608021234L, testList.get(3).getPersonalIdNumber());
        assertEquals(date1, testList.get(2).getMembershipDate());
        assertEquals("Elmer Ekorrsson", testList.get(4).getName());
        assertEquals(5, testList.size());
        assertEquals("Chamade Coriola", testList.get(2).getName());
    }

    @Test
    public void generateCustomerListExceptionTest() {
        assertThrows(FileNotFoundException.class,
                () -> c.generateCustomerList(incorrectPath));
        assertThrows(DateTimeParseException.class,
                () -> c.generateCustomerList(dirtyData));
        assertThrows(NumberFormatException.class,
                () -> c.generateCustomerList(incorrectFile));
    }
}