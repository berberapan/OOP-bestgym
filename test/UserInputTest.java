import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    UserInput i = new UserInput();
    CustomerInput c = new CustomerInput();
    Path path = Paths.get("test/test_data/test.txt");

    @Test
    public void searchTest() throws Exception{

        List<Customer> testList = c.generateCustomerList(path);
        boolean test = true;
        assertEquals(testList.get(4), i.search(test, "elmer ekorrsson", -1L, testList));
        assertEquals(testList.get(2), i.search(test, "",8512021234L,testList));
        assertNull(i.search(test, "testman testsson", -1L, testList));
        assertNull(i.search(test, "", 15L, testList));
    }
}