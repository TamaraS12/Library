/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

/**
 *
 * @author Tamarica
 */
public class GetAllMembers extends AbstractSO {

    public GetAllMembers() throws Exception {
    }

     
    @Override
    protected void validate(Object argument) throws Exception {
    }

    @Override
    protected void executeOperation(Object argument) throws Exception {
        result = dbbr.getAllMembers();
    }
    
}
