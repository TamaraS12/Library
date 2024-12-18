/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import domain.Publication;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tamarica
 */
public class TableModelPublication extends AbstractTableModel {

    private String[] columnNames = new String[]{"Title", "Author", "Quantity", "Price", "Publisher"};
    List<Publication> publications;

    public TableModelPublication(List<Publication> publications) {
        this.publications = publications;
    }

    @Override
    public int getRowCount() {
        if (publications == null) {
            return 0;
        } else {
            return publications.size();
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
        Publication publication = publications.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return publication.getTitle();
            case 1:
                return publication.getAuthor();
            case 2:
                return publication.getQuantity();
            case 3:
                return publication.getPrice();
            case 4:
                return publication.getPublisherID();
            default:
                return "columnIndex does not exist!";
        }
    }

    public List<Publication> getPublications() {
        return publications;
    }
    
    public void refreshTable() {
        fireTableDataChanged();
    }
}
