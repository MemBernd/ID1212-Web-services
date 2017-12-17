/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Conversionrate;
import model.ConversionratePK;
import model.Currency;

/**
 *
 * @author Bernardo
 */
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
public class CurrencyDAO {
    @PersistenceContext(unitName = "currencyPU")
    private EntityManager em;
    
    public List<Currency> listCurrencies() {
       try {
            return em.createNamedQuery("Currency.findAll", Currency.class).getResultList();
        } catch (NoResultException e) {
            return new ArrayList<>();
        }
    }
    
    public Conversionrate getRate(ConversionratePK pk) {
        Conversionrate conv = em.find(Conversionrate.class, pk);
        if(conv == null) 
            System.err.println("nothing found");
        return conv;
    }
}
