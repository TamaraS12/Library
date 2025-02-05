/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import domain.Liability;
import domain.OrderItem;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tamarica
 */
public class TableModelOrder extends AbstractTableModel {

    private String[] columnNames = new String[]{"No", "Publication", "Author", "Price", "Quantity", "Total"};
    List<OrderItem> orderItems;

    public TableModelOrder(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public int getRowCount() {
        if (orderItems == null) {
            return 0;
        } else {
            return orderItems.size();
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
        OrderItem orderItem = orderItems.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> rowIndex + 1;
            case 1 -> orderItem.getPublication().getTitle();
            case 2 -> orderItem.getPublication().getAuthor();
            case 3 -> orderItem.getPublication().getPrice();
            case 4 -> orderItem.getQuantity();
            case 5 -> orderItem.getTotalAmount();
            default -> "columnIndex does not exist!";
        };
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void refreshTable() {
        fireTableDataChanged();
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
        fireTableDataChanged();
    }

}
