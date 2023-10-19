import java.time.LocalDate;
import java.util.List;

public class Compare {

    public Customer isNameInCustomerList(String name, List<Customer> customers) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name))
                return customer;
        }
        System.out.println("Ingen träff i listan.");
        return null;
    }

    public Customer isPINInCustomerList(long PIN, List<Customer> customers) {
        for (Customer customer : customers) {
            if (customer.getPersonalIdNumber() == PIN)
                return customer;
        }
        System.out.println("Ingen träff i listan.");
        return null;
    }

    public boolean isCustomerACurrentMember(Customer customer) {
        if (customer.getMembershipDate().isBefore(LocalDate.now().minusYears(1))) {
            System.out.println("Medlemskapet har gått ut. Gick ut " + customer.getMembershipDate().plusYears(1));
            return false;
        } else
            System.out.println("Giltigt medlemskap.");
            return true;
    }
}