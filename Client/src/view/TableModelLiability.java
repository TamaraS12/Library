/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import domain.Liability;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tamarica
 */
public class TableModelLiability extends AbstractTableModel {

    private String[] columnNames = new String[]{"Name", "Last name", "Publication", "Author", "Date from", "Date to"};
    List<Liability> liabilities;

    public TableModelLiability(List<Liability> liabilities) {
        this.liabilities = liabilities;
    }

    @Override
    public int getRowCount() {
        if (liabilities == null) {
            return 0;
        } else {
            return liabilities.size();
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
         Liability liability = liabilities.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return liability.getMember().getName();
            case 1:
                return liability.getMember().getLastName();
            case 2:
                return liability.getPublication().getTitle();
            case 3:
                return liability.getPublication().getAuthor();
            case 4:
                return liability.getDateFrom();
            case 5:
                return liability.getDateTo();
            default:
                return "columnIndex does not exist!";
        }
    }
    
    public List<Liability> getLiabilities() {
        return liabilities;
    }
    
       public void refreshTable() {
        fireTableDataChanged();
    }

}
