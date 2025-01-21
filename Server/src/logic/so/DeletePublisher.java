/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domain.Publisher;

/**
 *
 * @author Tamarica
 */
public class DeletePublisher extends AbstractSO {

    public DeletePublisher() throws Exception {
    }
    
    @Override
    protected void validate(Object publisher) throws Exception {
         if(publisher == null){
            throw new Exception("Publisher is null!");
        }
    }

    @Override
    protected void executeOperation(Object publisher) throws Exception {
        dbbr.deletePublisher((Publisher) publisher);
    }
    
}
