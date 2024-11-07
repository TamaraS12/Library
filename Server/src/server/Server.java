/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

import domain.Employee;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import server.thread.ClientThread;

/**
 *
 * @author Tamarica
 */
public class Server {

    private List<ClientThread> clientThreads;

    public Server() {
        clientThreads = new ArrayList<>();
    }

    public void startServer() {

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {

                System.out.println("Waiting for connection...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected!");

                ClientThread clientThread = new ClientThread(clientSocket, this);
                clientThread.start();
                clientThreads.add(clientThread);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean isLoggedUser(Employee employee) {
        for (ClientThread clientThread : clientThreads) {
            if (clientThread.isAlive() && clientThread.getEmployee() != null && clientThread.getEmployee().equals(employee)) {
                return true;
            }
        }
        return false;
    }
}
