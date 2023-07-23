
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    FileWriter out = null;

    public void write(Employee e) {
        try {
            out = new FileWriter("op.csv", true);
            String str = e.getId() + "," + e.getName() + "," + e.getAge() + "," + e.getPosition() + ","
                    + e.getSalary() + "\n";
            System.out.println(str);
            out.append(str);
            System.out.println("Write files");
            out.close();
        } catch (IOException exp) {
        }

    }

    public void update(Employee e) {
        try {
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader("op.csv"));
            String outLine = "";

            while ((line = br.readLine()) != null) {
                String[] employee = line.split(",");

                if (Integer.parseInt(employee[0]) == e.getId()) {
                    String str = e.getId() + "," + e.getName() + "," + e.getAge() + "," + e.getPosition() + ","
                            + e.getSalary() + "\n";
                    outLine += str;
                } else {
                    outLine += line + "\n";
                }
            }
            br.close();
            out = new FileWriter("op.csv", false);
            out.write(outLine);
            out.close();

        } catch (IOException exp) {
            exp.printStackTrace();
        }

    }

    public void delete(int id) {
        try {
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader("op.csv"));
            String outLine = "";

            while ((line = br.readLine()) != null) {
                String[] employee = line.split(",");

                if (Integer.parseInt(employee[0]) == id) {
                    continue;
                } else {
                    outLine += line + "\n";
                }
            }
            br.close();
            out = new FileWriter("op.csv", false);
            out.write(outLine);
            out.close();

        } catch (IOException exp) {
            exp.printStackTrace();
        }

    }
}
