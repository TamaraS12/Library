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
public class Publication implements Serializable {

    private Long publicationID;
    private String title;
    private String author;
    private Long quantity;
    private double price;

    public Publication(Long publicationID, String title, String author, Long quantity, double price) {
        this.publicationID = publicationID;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getPublicationID() {
        return publicationID;
    }

    public void setPublicationID(Long publicationID) {
        this.publicationID = publicationID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.publicationID);
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + Objects.hashCode(this.author);
        hash = 97 * hash + Objects.hashCode(this.quantity);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
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
        final Publication other = (Publication) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Publication{" + "publicationID=" + publicationID + ", title=" + title + ", author=" + author + ", quantity=" + quantity + ", price=" + price + '}';
    } 
    
}
