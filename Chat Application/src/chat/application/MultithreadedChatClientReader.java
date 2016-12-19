/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.application;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class MultithreadedChatClientReader extends Thread {
    private Socket serverSocket;
    
    public MultithreadedChatClientReader(Socket serverSocket) {
        super();
        this.serverSocket = serverSocket;
    }
    
    @Override
    public void run() {
        try {
            byte[] messageBytes = new byte[1000];
            
            InputStream inputStream = serverSocket.getInputStream();
            while (true) {
                inputStream.read(messageBytes);
                String messageString = new String(messageBytes).trim();
                if (messageString.equals("QUIT"))
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(MultithreadedChatClientReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
