/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Tamarica
 */
public class Liability implements Serializable {
    
    private Long liabilityID;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Member member;
    private Publication publication;

    public Liability() {
    }

    public Liability(Long liabilityID, LocalDate dateFrom, LocalDate dateTo, Member member, Publication publication) {
        this.liabilityID = liabilityID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.member = member;
        this.publication = publication;
    }

    public Liability(Long memberID, Long publicationID, LocalDate dateFrom, LocalDate dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.member = new Member(memberID);
        this.publication = new Publication(publicationID);
        
    }

    public Long getLiabilityID() {
        return liabilityID;
    }

    public void setLiabilityID(Long liabilityID) {
        this.liabilityID = liabilityID;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public Member getMember() {
        return member;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.liabilityID);
        hash = 59 * hash + Objects.hashCode(this.dateFrom);
        hash = 59 * hash + Objects.hashCode(this.dateTo);
        hash = 59 * hash + Objects.hashCode(this.member);
        hash = 59 * hash + Objects.hashCode(this.publication);
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
        final Liability other = (Liability) obj;
        if (!Objects.equals(this.liabilityID, other.liabilityID)) {
            return false;
        }
        if (!Objects.equals(this.dateFrom, other.dateFrom)) {
            return false;
        }
        if (!Objects.equals(this.dateTo, other.dateTo)) {
            return false;
        }
        if (!Objects.equals(this.member, other.member)) {
            return false;
        }
        return Objects.equals(this.publication, other.publication);
    }

    @Override
    public String toString() {
        return "Liability{" + "liabilityID=" + liabilityID + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", member=" + member + ", publication=" + publication + '}';
    }



    
    
    
}
