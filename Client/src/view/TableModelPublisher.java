/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import domain.Publisher;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tamarica
 */
public class TableModelPublisher extends AbstractTableModel {

    private String[] columnNames = new String[]{"Name", "Address", "Email", "Phone"};
    List<Publisher> publishers;

    public TableModelPublisher(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    @Override
    public int getRowCount() {
        if (publishers == null) {
            return 0;
        } else {
            return publishers.size();
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
                Publisher publisher = publishers.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return publisher.getName();
            case 1:
                return publisher.getAddress();
            case 2:
                return publisher.getEmail();
            case 3:
                return publisher.getPhone();
            default:
                return "columnIndex does not exist!";
        }
    }
    
      public List<Publisher> getPublishers() {
        return publishers;
    }

    public void refreshTable() {
        fireTableDataChanged();
    }

}
