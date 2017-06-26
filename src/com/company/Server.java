package com.company;

// File Name Server.java
import com.tictactoe.Model.Game;
import com.tictactoe.View.Printer;

import java.net.*;
import java.io.*;

public class Server extends Thread {
    private ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
//        serverSocket.setSoTimeout(10000);
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Waiting for client on port " +
                        serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();

                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));

                System.out.println(in.readLine());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeBytes("Thank you for connecting to " + server.getLocalSocketAddress() + "\n");
                Game game = new Game();
                Printer printer = new Printer();
                game.createField();
                out.writeBytes(printer.changeToString(game.getField()));
                //System.out.println(in.readLine());
                server.close();

            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}