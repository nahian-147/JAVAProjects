import org.apache.log4j.Logger;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public  static Logger logger = Logger.getLogger(Client.class.getName());

    public static void main(String args[]){
        DataOutputStream out;
        Scanner scanner = new Scanner(System.in);
        try {
            String line;
            out = new DataOutputStream(System.out);
            while (true) {
                line = scanner.nextLine();
                out.writeUTF(line);
                if (line.equalsIgnoreCase("shutdown")) break;
            }
            out.close();
        } catch (IOException e) {
            logger.fatal(e);
        }
    }
}
