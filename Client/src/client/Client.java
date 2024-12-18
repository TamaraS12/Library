/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package client;

import communication.Response;
import communication.Receiver;
import controller.Controller;
import domain.Member;
import domain.Employee;
import domain.Publication;
import domain.Publisher;
import form.FrmLogin;
import form.FrmMain;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Tamarica
 */
public class Client {

    private FrmLogin frmLogin;
    private FrmMain frmMain;
    private Receiver receiver;
    private Socket socket;
    private Employee employee;
    private List<Member> members;

    public Client() throws IOException {
        frmLogin = new FrmLogin("Login");
        frmLogin.setVisible(true);
        socket = Controller.getInstance().getSocket();
        receiver = new Receiver(socket);
    }

    public void startClient() {

        while (true) {
            try {
                Object r = receiver.receive();
                if (r instanceof Response) {
                    Response response = (Response) r;
                    System.out.println("Response: " + response);
                    switch (response.getOperation()) {
                        case Login:
                            if (response.getException() == null) {
                                setEmployee((Employee) response.getResult());
                            } else {
                                throw response.getException();
                            }
                            break;
                        case GetAllMembers:
                            members = (List<Member>) response.getResult();
                            frmMain.getFrmReviewMembers().addMembers(members);
                            break;
                        case AddMember:
                            // Clan clan = (Clan) response.getResult();
                            if (response.getException() == null) {
                                JOptionPane.showMessageDialog(frmMain.getFrmAddMember(), "New member successfully added!", "Enrollment", JOptionPane.INFORMATION_MESSAGE);
                                frmMain.getFrmAddMember().dispose();
                                frmMain.getFrmReviewMembers().refreshTable();
                            } else {
                                throw response.getException();
                            }
                            break;
                        case UpdateMember:
                            if (response.getException() == null) {
                                frmMain.getFrmReviewMembers().getFrmAddMember().dispose();
                                JOptionPane.showMessageDialog(frmMain.getFrmReviewMembers().getFrmAddMember(), "Successful update! ", "Update", JOptionPane.INFORMATION_MESSAGE);
                                Controller.getInstance().getAllMembers();
                            } else {
                                throw response.getException();
                            }
                            break;
                        case DeleteMember:
                            if (response.getException() == null) {
                                JOptionPane.showMessageDialog(frmMain.getFrmReviewMembers(), "Member successfully deleted! ", "Delete", JOptionPane.INFORMATION_MESSAGE);
//                                frmMain.getFrmReviewMembers().refreshTable();
                                Controller.getInstance().getAllMembers();
                            } else {
                                throw response.getException();
                            }
                            break;
                        case GetAllPublishers:
                            List<Publisher> publishers = (List<Publisher>) response.getResult();
                            if (frmMain.getFrmAddPublication() != null) {
                                frmMain.getFrmAddPublication().setPublisherComboBox(publishers);
                            } else if (frmMain.getFrmReviewPublications().getFrmAddPublication() != null) {
                                frmMain.getFrmReviewPublications().getFrmAddPublication().setSelectedPublisher(publishers);
                                frmMain.getFrmReviewPublications().getFrmAddPublication().setForm();
                            }
                            
                            
                            break;
                        case AddPublication:
                            if (response.getException() == null) {
                                JOptionPane.showMessageDialog(frmMain.getFrmAddPublication(), "New publication successfully added!", "Enrollment", JOptionPane.INFORMATION_MESSAGE);
                                frmMain.getFrmAddPublication().dispose();
                            } else {
                                throw response.getException();
                            }
                            break;
                        case GetAllPublications:
                            List<Publication> publications = (List<Publication>) response.getResult();
                            frmMain.getFrmReviewPublications().addPublications(publications);
                            break;
                        case DeletePublication:
                            if (response.getException() == null) {
                                JOptionPane.showMessageDialog(frmMain.getFrmReviewPublications(), "Publication successfully deleted! ", "Delete", JOptionPane.INFORMATION_MESSAGE);
                                Controller.getInstance().getAllPublications();
                            } else {
                                throw response.getException();
                            }
                            break;
                        case UpdatePublication:
                            if (response.getException() == null) {
                                frmMain.getFrmReviewPublications().getFrmAddPublication().dispose();
                                JOptionPane.showMessageDialog(frmMain.getFrmReviewPublications().getFrmAddPublication(), "Successful update! ", "Update", JOptionPane.INFORMATION_MESSAGE);
                                Controller.getInstance().getAllPublications();
                            } else {
                                throw response.getException();
                            }
                            break;
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void setEmployee(Employee employee) {

        this.employee = employee;
        if (employee == null) {
            JOptionPane.showMessageDialog(frmLogin, "User does not exist!", "Login", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frmLogin, employee.getName() + " is logged in!", "Login", JOptionPane.INFORMATION_MESSAGE);
            frmLogin.dispose();
            frmMain = new FrmMain();
            frmMain.setVisible(true);
        }
    }

}
