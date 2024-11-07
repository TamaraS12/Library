/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.db.DbBroker;
import repository.db.DbConnection;

/**
 *
 * @author Tamarica
 */
public abstract class AbstractSO {

    protected DbBroker dbbr;
    protected Object result;

    public AbstractSO() throws Exception {
        dbbr = new DbBroker(DbConnection.getInstance().pop());
    }

    public void execute(Object argument) throws Exception {

        try {
            validate(argument);
            executeOperation(argument);
            commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            rollback();
        } finally {
            DbConnection.getInstance().push(dbbr.getConnection());
        }
    }

    protected abstract void validate(Object argument) throws Exception;

    protected abstract void executeOperation(Object argument) throws Exception;

    private void commit() throws Exception {
        dbbr.getConnection().commit();
    }

    private void rollback() throws Exception {
        dbbr.getConnection().rollback();
    }

    public Object getResult() {
        return result;
    }

}
