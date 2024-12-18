/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

/**
 *
 * @author Tamarica
 */
public class GetAllPublications extends AbstractSO {

    public GetAllPublications() throws Exception {
    }
    

    @Override
    protected void validate(Object argument) throws Exception {
    }

    @Override
    protected void executeOperation(Object argument) throws Exception {
         result = dbbr.getAllPublications();
    }
    
}
