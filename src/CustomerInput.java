import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class CustomerInput {

    public List<Customer> generateCustomerList(Path path) throws Exception{
        List<Customer> customerList = new ArrayList<>();
        String initialRow;
        Customer customer;

        try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
            while((initialRow = br.readLine()) != null) {
                String[] splitter = initialRow.split(",");

                String personalIdNumber = splitter[0];
                String name = splitter[1].strip();

                String date = br.readLine();
                customer = new Customer(personalIdNumber, name ,date);
                customerList.add(customer);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ingen fil hittad. Vänligen undersök så att den angivna sökvägen är korrekt.");
            throw e;
        } catch (DateTimeParseException e) {
            System.out.println("Data i filen behöver rengöras för att kunna läsas. Kontrollera poster med datum");
            throw e;
        } catch (NumberFormatException e) {
            System.out.println("Fel format på data. Kontrollera att du valt korrekt fil.");
            throw e;
        }
        return customerList;
    }
}
