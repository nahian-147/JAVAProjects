package com.nahian.continum;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class KServer {

    Logger logger = LoggerFactory.getLogger(KServer.class.getName());
    private int PORT = 8080;
    private ServerSocket socket = null;

    public KServer() throws IOException {

    }

    public void startServer(){
        String host = "localhost";
        logger.info("Starting KServer 1.0");
        try {
            socket = new ServerSocket(PORT);
        } catch (IOException e) {
            logger.debug(""+e);
        }
        logger.info("KServer Started at port "+socket.getLocalPort());
    }

    public void shutDownServer(){
        logger.info("Shutting Down KServer.");
        try {
            socket.close();
        } catch (IOException e) {
            logger.debug(""+e);
        }
    }

    String[] getInput(){
        String[] inputs = null;
        Socket s = null;
        try {
            s = socket.accept();
        } catch (IOException e) {
            logger.debug(""+e);
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

