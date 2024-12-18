/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domain.Publication;

/**
 *
 * @author Tamarica
 */
public class DeletePublication extends AbstractSO {

    public DeletePublication() throws Exception {
    }

    
    @Override
    protected void validate(Object publication) throws Exception {
        if(publication == null){
            throw new Exception("Publication is null!");
        }
    }

    @Override
    protected void executeOperation(Object publication) throws Exception {
        dbbr.deletePublication((Publication) publication);
    }
    
}
