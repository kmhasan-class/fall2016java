/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class ChatServer {

    public ChatServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("Started the chat server at port 9999");

            
                        
            while (true) {
                System.out.println("Waiting on clients ...");
                Socket clientSocket = serverSocket.accept();
                System.out.println(clientSocket);

                byte messageBytes[] = new byte[1000];
                InputStream inputStream = clientSocket.getInputStream();
                inputStream.read(messageBytes);
                String messageString = new String(messageBytes);
                System.out.println(messageString);
                
                OutputStream outputStream = clientSocket.getOutputStream();
                String dateTime = LocalDate.now() + " " + LocalTime.now();
                messageString = dateTime + " " + messageString;
                outputStream.write(messageString.getBytes());
            }

        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
