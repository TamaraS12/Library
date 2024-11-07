/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domain.Employee;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tamarica
 */
public class Login extends AbstractSO {

    public Login() throws Exception {
    }

    @Override
    protected void validate(Object employee) throws Exception {
        if (employee == null) {
            throw new Exception("Employee is null");
        }
    }

    @Override
    protected void executeOperation(Object employee) throws Exception {
            result = dbbr.getUser((Employee) employee);
    }

}
