import java.time.LocalDate;

public class Customer {

    private final long personalIdNumber;
    private final String name;
    private final LocalDate membershipDate;

    public Customer(String personalIdNumber, String name, String membershipDate) {
        this.personalIdNumber = Long.parseLong(personalIdNumber);
        this.name = name;
        this.membershipDate = LocalDate.parse(membershipDate);
    }

    public long getPersonalIdNumber() {
        return personalIdNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }
}
