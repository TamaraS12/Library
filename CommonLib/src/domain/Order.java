/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Tamarica
 */
public class Order implements Serializable {
    
    private Long orderID;
    private List<OrderItem> orderItems;
    private LocalDate date;
    private Employee employee;

    public double getTotalAmount() {
        double suma = 0.0;
        
        for (OrderItem item: orderItems) {
            suma += item.getTotalAmount();
        }
        
        return suma;
    }

    public Order() {
    }

    public Order(Long orderID, List<OrderItem> orderItems, LocalDate date, Employee employee) {
        this.orderID = orderID;
        this.orderItems = orderItems;
        this.date = date;
        this.employee = employee;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.orderID);
        hash = 41 * hash + Objects.hashCode(this.orderItems);
        hash = 41 * hash + Objects.hashCode(this.date);
        hash = 41 * hash + Objects.hashCode(this.employee);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (!Objects.equals(this.orderID, other.orderID)) {
            return false;
        }
        if (!Objects.equals(this.orderItems, other.orderItems)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return Objects.equals(this.employee, other.employee);
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", orderItems=" + orderItems + ", date=" + date + ", employee=" + employee + '}';
    }
    
    
    
}
