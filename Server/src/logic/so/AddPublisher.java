/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domain.Member;
import domain.Publisher;

/**
 *
 * @author Tamarica
 */
public class AddPublisher extends AbstractSO {

    public AddPublisher() throws Exception {
    }

    
    @Override
    protected void validate(Object publisher) throws Exception {
         if (publisher == null) {
            throw new Exception("Publisher is null!");
        }
    }

    @Override
    protected void executeOperation(Object publisher) throws Exception {
        dbbr.addPublisher((Publisher) publisher);
        result = publisher;
    }
    
}
