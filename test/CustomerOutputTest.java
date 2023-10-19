import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

class CustomerOutputTest {
    CustomerOutput c = new CustomerOutput();
    @Test
    public void exportCustomerVisitTest() throws IOException {
        Customer c1 = new Customer("7310080130", "Ma Baker", "2020-11-11");
        Customer c2 = new Customer("6901210013", "Grigori Rasputin", "2020-12-12");
        Path path = Paths.get("test/test_data/output.txt");
        Path incorrectPath = Paths.get("test/test_data2/output.txt");

        c.exportCustomerVisit(c1, path);
        c.exportCustomerVisit(c2, path);

        String nextRow;
        int sum = 0;
        String today = LocalDate.now().toString();
        String test = "";
        try(BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
            while((nextRow = br.readLine()) != null ) {
                test = nextRow;
                sum++;
            }
            assertEquals(2, sum);
            assertEquals("Grigori Rasputin 6901210013 "+ today, test);
        }
        Files.delete(path);
        assertThrows(IOException.class,
                ()-> c.exportCustomerVisit(c1, incorrectPath));
    }
}