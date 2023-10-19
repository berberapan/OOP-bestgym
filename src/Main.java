import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    Path customerDB = Paths.get("src/data/customers.txt");
    Path output = Paths.get("src/data/pt_data.txt");

    CustomerInput readFile = new CustomerInput();
    UserInput user = new UserInput();
    Compare comp = new Compare();
    CustomerOutput writeToFile = new CustomerOutput();

    public void runProgram() {
        try {
            List<Customer> db = readFile.generateCustomerList(customerDB);
            Customer searchObject = user.search(false, null, -1L, db);
            if (searchObject != null) {
                boolean member = comp.isCustomerACurrentMember(searchObject);
                if (member)
                    writeToFile.exportCustomerVisit(searchObject, output);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Main start = new Main();
        start.runProgram();
    }
}