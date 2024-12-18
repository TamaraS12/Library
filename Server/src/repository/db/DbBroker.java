/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;

import domain.Member;
import domain.Employee;
import domain.Publication;
import domain.Publisher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tamarica
 */
public class DbBroker {

    Connection connection;

    public DbBroker(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public Object getUser(Employee employee) throws SQLException {

        try {
            String query = "SELECT employeeID, name, last_name, username, password, email FROM employee WHERE username=? AND password=?";
            System.out.println("Query: " + query);

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, employee.getUsername());
            statement.setString(2, employee.getPassword());
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                employee.setEmployeeID(rs.getLong("employeeID"));
                employee.setName(rs.getString("name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setEmail(rs.getString("email"));
            } else {
                System.out.println("ResultSet is empty!");
                employee = null;
            }
            rs.close();
            statement.close();
            System.out.println("Successful loading of employee from the database!");
            return employee;
        } catch (SQLException ex) {
            System.out.println("Employee was not successfully loaded from the database!");
            ex.printStackTrace();
            throw ex;
        }
    }

    public Object getAllMembers() {
        try {
            List<Member> members = new ArrayList<>();
            String query = "SELECT * FROM member";
            System.out.println("Query:" + query);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Member member = new Member();
                member.setMemberID(rs.getLong("memberID"));
                member.setName(rs.getString("name"));
                member.setLastName(rs.getString("last_name"));
                member.setEmail(rs.getString("email"));
                member.setPhoneNumber(rs.getString("phone_number"));
                member.setAddress(rs.getString("address"));
                members.add(member);
            }
            rs.close();
            statement.close();
            System.out.println("Successful loading of members from the database!");
            return members;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Members were not successfully loaded from the database!");

        }
        return null;
    }

    public void addMember(Member member) {
        try {
            String query = "INSERT INTO member (name, last_name, email, phone_number, address) VALUES (?,?,?,?,?)";
            System.out.println("Query:" + query);

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, member.getName());
            statement.setString(2, member.getLastName());
            statement.setString(3, member.getEmail());
            statement.setString(4, member.getPhoneNumber());
            statement.setString(5, member.getAddress());

            statement.executeUpdate();
            statement.close();
            System.out.println("Member successfully added to the database!");
        } catch (SQLException ex) {
            System.out.println("Member was not added to the database!");
            ex.printStackTrace();
        }
    }

    public void updateMember(Member member) {
        try {
            String query = "UPDATE member SET name=?, last_name=?, email=?, phone_number=?, address=? WHERE memberID=? ";
            System.out.println("Query:" + query);

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, member.getName());
            statement.setString(2, member.getLastName());
            statement.setString(3, member.getEmail());
            statement.setString(4, member.getPhoneNumber());
            statement.setString(5, member.getAddress());
            statement.setLong(6, member.getMemberID());
            statement.executeUpdate();
            statement.close();
            System.out.println("Member successfully updated!");

        } catch (SQLException ex) {
            System.out.println("Member was not updated!");
            ex.printStackTrace();

        }

    }

    public void deleteMember(Member member) {
        try {
            String query = "DELETE FROM member WHERE memberID=? ";
            System.out.println("Query:" + query);

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, member.getMemberID());
            statement.executeUpdate();
            statement.close();
            System.out.println("Member successfully deleted!");
        } catch (SQLException ex) {
            System.out.println("Member was not deleted!");
            ex.printStackTrace();
        }
    }

    public Object getAllPublishers() {
        try {
            List<Publisher> publishers = new ArrayList<>();
            String query = "SELECT * FROM publisher";
            System.out.println("Query:" + query);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Publisher publisher = new Publisher();
                publisher.setPublisherID(rs.getLong("publisherID"));
                publisher.setName(rs.getString("name"));
                publisher.setAddress(rs.getString("address"));
                publisher.setEmail(rs.getString("email"));
                publishers.add(publisher);
            }
            rs.close();
            statement.close();
            System.out.println("Successful loading of publishers from the database!");
            return publishers;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Publishers were not successfully loaded from the database!");

        }
        return null;
    }

    public void addPublication(Publication publication) {
        try {
            String query = "INSERT INTO publication (title, author, quantity, price, publisherID) VALUES (?,?,?,?,?)";
            System.out.println("Query:" + query);

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, publication.getTitle());
            statement.setString(2, publication.getAuthor());
            statement.setLong(3, publication.getQuantity());
            statement.setDouble(4, publication.getPrice());
            statement.setLong(5, publication.getPublisherID());

            statement.executeUpdate();
            statement.close();
            System.out.println("Publication successfully added to the database!");
        } catch (SQLException ex) {
            System.out.println("Publication was not added to the database!");
            ex.printStackTrace();
        }
    }

    public Object getAllPublications() {
               try {
            List<Publication> publications = new ArrayList<>();
            String query = "SELECT * FROM publication";
            System.out.println("Query:" + query);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Publication publication = new Publication();
                publication.setPublicationID(rs.getLong("publicationID"));
                publication.setTitle(rs.getString("title"));
                publication.setAuthor(rs.getString("author"));
                publication.setQuantity(rs.getLong("quantity"));
                publication.setPrice(rs.getDouble("price"));
                publication.setPublisherID(rs.getLong("publisherID"));
                publications.add(publication);
            }
            rs.close();
            statement.close();
            System.out.println("Successful loading of publications from the database!");
            return publications;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Publications were not successfully loaded from the database!");

        }
        return null;
    }

    public void deletePublication(Publication publication) {
        try {
            String query = "DELETE FROM publication WHERE publicationID=? ";
            System.out.println("Query:" + query);

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, publication.getPublicationID());
            statement.executeUpdate();
            statement.close();
            System.out.println("Publication successfully deleted!");
        } catch (SQLException ex) {
            System.out.println("Publication was not deleted!");
            ex.printStackTrace();
        }
    }

    public void updatePublication(Publication publication) {
             try {
            String query = "UPDATE publication SET title=?, author=?, quantity=?, price=?, publisherID=? WHERE publicationID=? ";
            System.out.println("Query:" + query);

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, publication.getTitle());
            statement.setString(2, publication.getAuthor());
            statement.setLong(3, publication.getQuantity());
            statement.setDouble(4, publication.getPrice());
            statement.setLong(5, publication.getPublisherID());
            statement.setLong(6, publication.getPublicationID());
            statement.executeUpdate();
            statement.close();
            System.out.println("Publication successfully updated!");

        } catch (SQLException ex) {
            System.out.println("Publication was not updated!");
            ex.printStackTrace();

        }
    }
}
