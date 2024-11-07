/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domain.Member;

/**
 *
 * @author Tamarica
 */
public class AddMember extends AbstractSO {

    public AddMember() throws Exception {
    }

    @Override
    protected void validate(Object member) throws Exception {
        if (member == null) {
            throw new Exception("Member is null!");
        }
    }

    @Override
    protected void executeOperation(Object member) throws Exception {
        dbbr.addMember((Member) member);
        result = member;
    }

}
