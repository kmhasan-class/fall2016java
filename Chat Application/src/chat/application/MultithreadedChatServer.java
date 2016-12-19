/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class MultithreadedChatServer extends Thread {

    private Socket clientSocket;
    private ChatServer mainServer;
    
    public MultithreadedChatServer(ChatServer mainServer, Socket clientSocket) {
        this.mainServer = mainServer;
        this.clientSocket = clientSocket;
        
    }

    @Override
    public void run() {
        try {
            while (true) {
                InputStream inputStream = null;
                byte messageBytes[] = new byte[1000];
                inputStream = clientSocket.getInputStream();
                inputStream.read(messageBytes);
                String messageString = new String(messageBytes).trim();
                System.out.println("[" + messageString + "]");
                if (messageString.equals("QUIT")) {
                    break;
                }
                mainServer.addMessage(messageString);
                OutputStream outputStream = clientSocket.getOutputStream();
                String dateTime = LocalDate.now() + " " + LocalTime.now();
                messageString = dateTime + " " + messageString;
                outputStream.write(messageString.getBytes());
            }
        } catch (IOException ioe) {
            System.err.println(ioe.toString());
        }
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

}
