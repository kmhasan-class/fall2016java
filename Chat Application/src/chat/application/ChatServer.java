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
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class ChatServer {
    private String messageHistory;

    public void addMessage(String message) {
        messageHistory = messageHistory + "\n" + message;
    }
    
    public ChatServer() {
        messageHistory = "";
        
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("Started the chat server at port 9999");

            ArrayList<MultithreadedChatServer> serversList = new ArrayList<>();
            
            while (true) {
                System.out.println("Waiting on clients ...");
                Socket clientSocket = serverSocket.accept();
                System.out.println(clientSocket);
                
                MultithreadedChatServer multithreadedServer;
                multithreadedServer = new MultithreadedChatServer(this, clientSocket);
                serversList.add(multithreadedServer);
                multithreadedServer.start();
                
                System.out.println("-----");
                System.out.println("Printing the list of connected servers");
                for (MultithreadedChatServer server : serversList) {
                    System.out.println(" " + server.getClientSocket());
                    OutputStream output = server.getClientSocket().getOutputStream();
                    output.write(messageHistory.getBytes());
                }
                System.out.println("-----\n");
            }

        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
