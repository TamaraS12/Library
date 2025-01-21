/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Tamarica
 */
public class Liabilities implements Serializable {
    
    private Long liabilitiesID;
    private Date dateFrom;
    private Date dateTo;

    public Liabilities() {
    }

    public Liabilities(Long liabilitiesID, Date dateFrom, Date dateTo) {
        this.liabilitiesID = liabilitiesID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public Long getLiabilitiesID() {
        return liabilitiesID;
    }

    public void setLiabilitiesID(Long liabilitiesID) {
        this.liabilitiesID = liabilitiesID;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.liabilitiesID);
        hash = 71 * hash + Objects.hashCode(this.dateFrom);
        hash = 71 * hash + Objects.hashCode(this.dateTo);
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
        final Liabilities other = (Liabilities) obj;
        if (!Objects.equals(this.liabilitiesID, other.liabilitiesID)) {
            return false;
        }
        if (!Objects.equals(this.dateFrom, other.dateFrom)) {
            return false;
        }
        return Objects.equals(this.dateTo, other.dateTo);
    }

    @Override
    public String toString() {
        return "Liabilities{" + "liabilitiesID=" + liabilitiesID + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + '}';
    }
    
    
}
