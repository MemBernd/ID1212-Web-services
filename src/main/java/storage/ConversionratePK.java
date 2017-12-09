/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Bernardo
 */
@Embeddable
public class ConversionratePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "from")
    private String from;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "to")
    private String to;

    public ConversionratePK() {
    }

    public ConversionratePK(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (from != null ? from.hashCode() : 0);
        hash += (to != null ? to.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConversionratePK)) {
            return false;
        }
        ConversionratePK other = (ConversionratePK) object;
        if ((this.from == null && other.from != null) || (this.from != null && !this.from.equals(other.from))) {
            return false;
        }
        if ((this.to == null && other.to != null) || (this.to != null && !this.to.equals(other.to))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "storage.ConversionratePK[ from=" + from + ", to=" + to + " ]";
    }
    
}
