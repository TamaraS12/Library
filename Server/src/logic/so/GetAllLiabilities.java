/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

/**
 *
 * @author Tamarica
 */
public class GetAllLiabilities extends AbstractSO {

    public GetAllLiabilities() throws Exception {
    }
    

    @Override
    protected void validate(Object liability) throws Exception {
    }

    @Override
    protected void executeOperation(Object liability) throws Exception {
         result = dbbr.getAllLiabilities();
    }
    
}
