import java.util.List;
import java.util.Scanner;

public class UserInput {
    Compare c = new Compare();

    public Customer search(boolean test, String sValue, long lValue, List<Customer> customers) {
        if (test && lValue == -1) {
            return c.isNameInCustomerList(sValue, customers);
        } else if(test && lValue > -1) {
            return c.isPINInCustomerList(lValue, customers);
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Sök på för- och efternamn eller personnummer (10 siffror) : ");
        if(input.hasNextLong()) {
            long PIN = input.nextLong();
            return c.isPINInCustomerList(PIN, customers);
        } else if (input.hasNext()) {
            String name = input.nextLine();
            return c.isNameInCustomerList(name.toLowerCase().strip(), customers);
        } else {
            return null;
        }
    }
}
