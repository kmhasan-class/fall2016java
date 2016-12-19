/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class ChatClient {

    public ChatClient() {
        
        try {
            Socket serverSocket = new Socket("172.17.0.134", 9999);
            MultithreadedChatClientWriter writerThread = new MultithreadedChatClientWriter(serverSocket);
            MultithreadedChatClientReader readerThread = new MultithreadedChatClientReader(serverSocket);
            
            writerThread.start();
            readerThread.start();
        } catch (IOException ex) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        new ChatClient();
    }

}
