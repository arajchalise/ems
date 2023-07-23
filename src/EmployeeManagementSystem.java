import java.util.Scanner;

public class EmployeeManagementSystem {

    void getInputFromUser(Scanner sc) {
        Reader r = new Reader(sc);

        r.getInput();

        sc.close();
    }
}
