import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class KServer {

    Logger logger = Logger.getLogger(KServer.class.getName());
    private int PORT = 1381;
    private ServerSocket socket = null;

    public KServer() throws IOException {

    }

    public void startServer(){
        logger.info("Starting KServer 1.0");
        try {
            socket = new ServerSocket(PORT);
        } catch (IOException e) {
            logger.fatal(e);
        }
        logger.info("KServer Started at port "+socket.getLocalPort());
    }

    public void shutDownServer(){
        logger.info("Shutting Down kServer.");
        try {
            socket.close();
        } catch (IOException e) {
            logger.fatal(e);
        }
    }

    String[] getInput(){
        String[] inputs = null;
        Socket s = null;
        try {
            s = socket.accept();
        } catch (IOException e) {
            logger.fatal(e);
        }
        try {
            DataInputStream in = new DataInputStream(new BufferedInputStream(s.getInputStream()));
            inputs = in.readUTF().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputs;
    }

}
