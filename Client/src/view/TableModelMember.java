/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import domain.Member;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tamarica
 */
public class TableModelMember extends AbstractTableModel {

    private String[] columnNames = new String[]{"Name", "Last name", "Email", "Phone", "Address"};
    List<Member> members;

    public TableModelMember(List<Member> members) {
        this.members = members;
    }

    @Override
    public int getRowCount() {
        if (members == null) {
            return 0;
        } else {
            return members.size();
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        if (column >= columnNames.length) {
            return "n/a";
        } else {
            return columnNames[column];
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Member member = members.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return member.getName();
            case 1:
                return member.getLastName();
            case 2:
                return member.getEmail();
            case 3:
                return member.getPhoneNumber();
            case 4:
                return member.getAddress();
            default:
                return "columnIndex does not exist!";
        }
    }

    public List<Member> getMembers() {
        return members;
    }

    public void refreshTable() {
        fireTableDataChanged();
    }
}
