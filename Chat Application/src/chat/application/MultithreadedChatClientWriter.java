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
public class MultithreadedChatClientWriter extends Thread {

    private Socket serverSocket;

    public MultithreadedChatClientWriter(Socket serverSocket) {
        super();
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        OutputStream outputStream = null;
        try {
            String message = null;
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            outputStream = serverSocket.getOutputStream();
            while (true) {
                message = input.readLine();
                outputStream.write(message.getBytes());
                if (message.equals("QUIT")) {
                    break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MultithreadedChatClientWriter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                outputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(MultithreadedChatClientWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
