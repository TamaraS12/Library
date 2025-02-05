/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

/**
 *
 * @author Tamarica
 */
public class GetPublicationsByPublisherId extends AbstractSO {

    public GetPublicationsByPublisherId() throws Exception {
    }

    @Override
    protected void validate(Object publisherID) throws Exception {
           if (publisherID == null) {
            throw new Exception("Publisher is null!");
        }
    }

    @Override
    protected void executeOperation(Object publisherID) throws Exception {
        result = dbbr.getPublicationsByPublisherId(publisherID);
    }
    
    
}
