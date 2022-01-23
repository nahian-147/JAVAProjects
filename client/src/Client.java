import org.apache.log4j.Logger;
import java.io.IOException;
import java.net.Socket;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Client{

	public static void main(String args[]){
		Logger logger = Logger.getLogger(Client.class.getName());
		Socket s;
		DataOutputStream out;
		try {
			String line;
			Scanner scanner = new Scanner(System.in);
			ArrayList<String> params = new ArrayList<>();
			while (true) {
				s = new Socket("localhost",1381);
				out = new DataOutputStream(s.getOutputStream());
				line = scanner.nextLine();
				out.writeUTF(line);
				params.add(line);
				if (line.equalsIgnoreCase("shutdown")) break;
			}
			out.close();
			s.close();
			logger.info(params);
		} catch (IOException e) {
			logger.fatal(e);
		}
	}
}
