/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domain.Liability;

/**
 *
 * @author Tamarica
 */
public class AddLiability extends AbstractSO {

    public AddLiability() throws Exception {
    }

    @Override
    protected void validate(Object liability) throws Exception {
         if (liability == null) {
            throw new Exception("Liability is null!");
        }
    }

    @Override
    protected void executeOperation(Object liability) throws Exception {
        dbbr.addLiability((Liability) liability);
        result = liability;
    }
    
}
