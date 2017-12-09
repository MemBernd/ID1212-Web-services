/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    @Column(name = "fromCurrency")
    private String fromCurrency;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "toCurrency")
    private String toCurrency;

    public ConversionratePK() {
    }

    public ConversionratePK(String fromCurrency, String toCurrency) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fromCurrency != null ? fromCurrency.hashCode() : 0);
        hash += (toCurrency != null ? toCurrency.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConversionratePK)) {
            return false;
        }
        ConversionratePK other = (ConversionratePK) object;
        if ((this.fromCurrency == null && other.fromCurrency != null) || (this.fromCurrency != null && !this.fromCurrency.equals(other.fromCurrency))) {
            return false;
        }
        if ((this.toCurrency == null && other.toCurrency != null) || (this.toCurrency != null && !this.toCurrency.equals(other.toCurrency))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ConversionratePK[ fromCurrency=" + fromCurrency + ", toCurrency=" + toCurrency + " ]";
    }
    
}
