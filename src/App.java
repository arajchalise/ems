import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        EmployeeManagementSystem es = new EmployeeManagementSystem();

        es.getInputFromUser(sc);

    }
}
