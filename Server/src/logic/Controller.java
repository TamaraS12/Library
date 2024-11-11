/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import logic.so.GetAllPublishers;
import domain.Member;
import domain.Employee;
import domain.Publication;
import domain.Publisher;
import java.util.List;
import logic.so.AddMember;
import logic.so.AddPublication;
import logic.so.DeleteMember;
import logic.so.GetAllMembers;
import logic.so.Login;
import logic.so.UpdateMember;

/**
 *
 * @author Tamarica
 */
public class Controller {

    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            return new Controller();
        }
        return instance;
    }

    public Employee login(Employee employee) throws Exception {

        Login so = new Login();
        so.execute(employee);
        return (Employee) so.getResult();

    }

    public List<Member> getAllMembers() throws Exception {

        GetAllMembers so = new GetAllMembers();
        so.execute(null);
        return (List<Member>) so.getResult();
    }

    public Member addMember(Member member) throws Exception {
        AddMember so = new AddMember();
        so.execute(member);
        return (Member) so.getResult();
    }

    public void updateMember(Member member) throws Exception {
        UpdateMember so = new UpdateMember();
        so.execute(member);
    }

    public void deleteMember(Member member) throws Exception {
        DeleteMember so = new DeleteMember();
        so.execute(member);
    }

    public List<Publisher> getAllPublishers() throws Exception {
        GetAllPublishers so = new GetAllPublishers();
        so.execute(null);
        return (List<Publisher>) so.getResult();
    }

    public Publication addPublication(Publication publication) throws Exception {
        AddPublication so = new AddPublication();
        so.execute(publication);
        return (Publication) so.getResult();
    }

    
}
