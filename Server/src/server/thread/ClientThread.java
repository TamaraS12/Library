/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.thread;

import communication.*;
import static communication.Operation.AddMember;
import domain.Member;
import domain.Employee;
import domain.Liability;
import domain.Publication;
import domain.Publisher;
import java.net.Socket;
import java.util.List;
import logic.Controller;
import server.Server;

/**
 *
 * @author Tamarica
 */
public class ClientThread extends Thread {

    private Socket socket;
    private Server server;
    private Receiver receiver;
    private Sender sender;
    private Employee employee;

    public ClientThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        receiver = new Receiver(socket);
        sender = new Sender(socket);
    }

    @Override
    public void run() {

        while (!socket.isClosed()) {
            try {
                Response response = new Response();
                Request request = (Request) receiver.receive();
                try {
                    switch (request.getOperation()) {
                        case Login:
                            Employee employee = (Employee) request.getArgument();

                            if (!server.isLoggedUser(employee)) {
                                response.setResult(Controller.getInstance().login(employee));
                                response.setOperation(Operation.Login);
                                this.employee = employee;
                                System.out.println("Employee saved on the server is:" + employee);
                            } else {
                                throw new Exception("Employee is already logged in!");
                            }
                            break;
                        case GetAllMembers:
                            List<Member> members = Controller.getInstance().getAllMembers();
                            response.setResult(members);
                            response.setOperation(Operation.GetAllMembers);
                            break;
                        case AddMember:
                            Member member = Controller.getInstance().addMember((Member) request.getArgument());
                            response.setResult(member);
                            response.setOperation(Operation.AddMember);
                            break;
                        case UpdateMember:
                            Controller.getInstance().updateMember((Member) request.getArgument());
                            response.setResult(null);
                            response.setOperation(Operation.UpdateMember);
                            break;
                        case DeleteMember:
                            Controller.getInstance().deleteMember((Member) request.getArgument());
                            response.setResult(null);
                            response.setOperation(Operation.DeleteMember);
                            break;
                        case GetAllPublishers:
                            List<Publisher> publishers = Controller.getInstance().getAllPublishers();
                            response.setResult(publishers);
                            response.setOperation(Operation.GetAllPublishers);
                            break;
                        case AddPublication:
                            Publication publication = Controller.getInstance().addPublication((Publication) request.getArgument());
                            response.setResult(publication);
                            response.setOperation(Operation.AddPublication);
                            break;
                        case GetAllPublications:
                            List<Publication> publications = Controller.getInstance().getAllPublications();
                            response.setResult(publications);
                            response.setOperation(Operation.GetAllPublications);
                            break;
                        case DeletePublication:
                            Controller.getInstance().deletePublication((Publication) request.getArgument());
                            response.setResult(null);
                            response.setOperation(Operation.DeletePublication);
                            break;
                        case UpdatePublication:
                            Controller.getInstance().updatePublication((Publication) request.getArgument());
                            response.setResult(null);
                            response.setOperation(Operation.UpdatePublication);
                            break;
                        case AddPublisher:
                            Publisher publisher = Controller.getInstance().addPublisher((Publisher) request.getArgument());
                            response.setResult(publisher);
                            response.setOperation(Operation.AddPublisher);
                            break;
                        case UpdatePublisher:
                            Controller.getInstance().updatePublisher((Publisher) request.getArgument());
                            response.setResult(null);
                            response.setOperation(Operation.UpdatePublisher);
                            break;
                        case DeletePublisher:
                            Controller.getInstance().deletePublisher((Publisher) request.getArgument());
                            response.setResult(null);
                            response.setOperation(Operation.DeletePublisher);
                            break;
                        case GetAllLiabilities:
                            List<Liability> liabilities = Controller.getInstance().getAllLiabilities();
                            response.setResult(liabilities);
                            response.setOperation(Operation.GetAllLiabilities);
                            break;
                        case DeleteLiability:
                            Controller.getInstance().deleteLiability((Liability) request.getArgument());
                            response.setResult(null);
                            response.setOperation(Operation.DeleteLiability);
                            break;
                        case AddLiability:
                            Liability liability = Controller.getInstance().addLiability((Liability) request.getArgument());
                            response.setResult(liability);
                            response.setOperation(Operation.AddLiability);
                            break;
                        case UpdateLiability:
                            Controller.getInstance().updateLiability((Liability) request.getArgument());
                            response.setResult(null);
                            response.setOperation(Operation.UpdateLiability);
                            break;
                        case GetPublicationsByPublisherId:
                            List<Publication> publisherPublications = Controller.getInstance().getPublicationsByPublisherId((Long) request.getArgument());
                            response.setResult(publisherPublications);
                            response.setOperation(Operation.GetPublicationsByPublisherId);
                            break;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    response.setException(ex);
                }
                sender.send(response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public Employee getEmployee() {
        return employee;
    }
}
