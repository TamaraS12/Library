/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Tamarica
 */
public class OrderItem implements Serializable {
    private Long itemID;
    private Publication publication;
    private int quantity;
    
    public double getTotalAmount() {
        return quantity * this.publication.getPrice();
    }

    public OrderItem() {
    }

    public OrderItem(Long itemID, Publication publication, int quantity) {
        this.itemID = itemID;
        this.publication = publication;
        this.quantity = quantity;
    }

    public Long getItemID() {
        return itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.itemID);
        hash = 89 * hash + Objects.hashCode(this.publication);
        hash = 89 * hash + this.quantity;
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
        final OrderItem other = (OrderItem) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.itemID, other.itemID)) {
            return false;
        }
        return Objects.equals(this.publication, other.publication);
    }

    @Override
    public String toString() {
        return "OrderItem{" + "itemID=" + itemID + ", publication=" + publication + ", quantity=" + quantity + '}';
    }
    
    
    
    
}
