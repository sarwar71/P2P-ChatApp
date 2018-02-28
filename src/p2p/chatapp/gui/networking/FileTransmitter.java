package p2p.chatapp.gui.networking;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileTransmitter extends Thread {

    String hostname;
    int port;
    byte[] file;

    public FileTransmitter() {

    }

    public FileTransmitter(byte[] file, String hostname, int port) {
        this.file = file;
        this.hostname = hostname;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            Socket s = new Socket(hostname, port);
            s.getOutputStream().write(file);
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(MessageTransmitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
