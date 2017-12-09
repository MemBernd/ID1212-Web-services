/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bernardo
 */
@Entity
@Table(name = "conversionrate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conversionrate.findAll", query = "SELECT c FROM Conversionrate c")
    , @NamedQuery(name = "Conversionrate.findByFromCurrency", query = "SELECT c FROM Conversionrate c WHERE c.conversionratePK.fromCurrency = :fromCurrency")
    , @NamedQuery(name = "Conversionrate.findByToCurrency", query = "SELECT c FROM Conversionrate c WHERE c.conversionratePK.toCurrency = :toCurrency")
    , @NamedQuery(name = "Conversionrate.findByRate", query = "SELECT c FROM Conversionrate c WHERE c.rate = :rate")})
public class Conversionrate implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConversionratePK conversionratePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate")
    private Float rate;
    @JoinColumn(name = "fromCurrency", referencedColumnName = "name", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Currency currency;
    @JoinColumn(name = "toCurrency", referencedColumnName = "name", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Currency currency1;

    public Conversionrate() {
    }

    public Conversionrate(ConversionratePK conversionratePK) {
        this.conversionratePK = conversionratePK;
    }

    public Conversionrate(String fromCurrency, String toCurrency) {
        this.conversionratePK = new ConversionratePK(fromCurrency, toCurrency);
    }

    public ConversionratePK getConversionratePK() {
        return conversionratePK;
    }

    public void setConversionratePK(ConversionratePK conversionratePK) {
        this.conversionratePK = conversionratePK;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Currency getCurrency1() {
        return currency1;
    }

    public void setCurrency1(Currency currency1) {
        this.currency1 = currency1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conversionratePK != null ? conversionratePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conversionrate)) {
            return false;
        }
        Conversionrate other = (Conversionrate) object;
        if ((this.conversionratePK == null && other.conversionratePK != null) || (this.conversionratePK != null && !this.conversionratePK.equals(other.conversionratePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Conversionrate[ conversionratePK=" + conversionratePK + " ]";
    }
    
}
