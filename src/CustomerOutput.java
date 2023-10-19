import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;

public class CustomerOutput {
    public void exportCustomerVisit(Customer customer, Path path) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path.toString(), true))) {
            String output = String.format("%s %d %s%n",
                    customer.getName(), customer.getPersonalIdNumber(), LocalDate.now());
            bw.write(output);
        } catch (IOException e) {
            System.out.println("Kunde inte spara kundens besök. Kontrollera att sökvägen för output är korrekt");
            throw e;
        }
    }
}
