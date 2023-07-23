import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Reader {
    protected Scanner sc;

    Reader(Scanner sc) {
        this.sc = sc;
    }

    public void getInput() {
        this.getAction();
    }

    private void getAction() {
        System.out.println(
                "Enter Action, A => Add, B => Edit, C => Delete D => Display Information By ID L => List Information");
        System.out.println("Press Control + C to exit terminal\n");
        switch (sc.next()) {
            case "A":
                this.getEmployeeInformation();
            case "B":
                this.updateEmployeeInformation();
            case "C":
                this.deleteEmployeeInformation();
            case "D":
                this.displayEmployeeInformationByID();
            case "L":
                this.listEmployeeInformation();
        }
    }

    private Employee getInputFromConsole() {
        System.out.println("Enter Employee ID:");
        int ID = sc.nextInt();
        System.out.println("Enter Employee name:");
        String name = sc.next();
        System.out.println("Enter Employee age: ");
        int age = sc.nextInt();
        System.out.println("Enter Employee position: ");
        String position = sc.next();
        System.out.println("Enter Employee salary: ");
        float sal = sc.nextInt();

        Employee e = new Employee(ID, name, age, position, sal);
        return e;
    }

    private void getEmployeeInformation() {
        Employee e = this.getInputFromConsole();
        Writer wr = new Writer();
        wr.write(e);

        this.getAction();
    }

    private void updateEmployeeInformation() {
        Employee e = this.getInputFromConsole();

        Writer wr = new Writer();
        wr.update(e);

        this.getAction();
    }

    private void deleteEmployeeInformation() {
        System.out.println("Enter Employee ID:");
        int ID = sc.nextInt();

        Writer wr = new Writer();
        wr.delete(ID);

        this.getAction();
    }

    private void displayEmployeeInformationByID() {
        System.out.println("Enter Employee ID:");
        int ID = sc.nextInt();
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("op.csv"));

            while ((line = br.readLine()) != null) {
                String[] employee = line.split(",");

                if (Integer.parseInt(employee[0]) == ID) {
                    System.out.println("Employee Information: \n");
                    System.out.println(line);
                } else {
                    continue;
                }
            }
            br.close();

        } catch (IOException exp) {
            exp.printStackTrace();
        }

        this.getAction();
    }

    private void listEmployeeInformation() {
        String line = "";
        System.out.println("Employee Information:\n");
        try {
            BufferedReader br = new BufferedReader(new FileReader("op.csv"));

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException exp) {
            exp.printStackTrace();
        }

        this.getAction();
    }
}
