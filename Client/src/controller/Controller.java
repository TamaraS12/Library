/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Member;
import domain.Employee;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Tamarica
 */
public class Controller {

    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    private static Controller instance;

    private Controller() throws IOException {
        socket = new Socket("127.0.0.1", 8080);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public static Controller getInstance() throws IOException {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void login(Employee employee) throws Exception {

        Request request = new Request(Operation.Login, employee);
        sender.send(request);

    }

    public Socket getSocket() {
        return socket;
    }

    public void getAllMembers() {
        Request request = new Request(Operation.GetAllMembers, null);
        sender.send(request);
    }

    public void addMember(Member member) {
        Request request = new Request(Operation.AddMember, member);
        sender.send(request);
    }

//    public void pronadjiClana(Clan clan) {
//        Request request = new Request(Operation.FindMember, clan);
//        sender.send(request);
//    }
    public void updateMember(Member member) {
        Request request = new Request(Operation.UpdateMember, member);
        sender.send(request);
    }

    public void deleteMember(Member member) {
        Request request = new Request(Operation.DeleteMember, member);
        sender.send(request);
    }

}