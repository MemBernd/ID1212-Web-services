/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import model.ConversionratePK;
import model.Currency;
import storage.CurrencyDAO;

/**
 *
 * @author Bernardo
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class Controller {
    @EJB CurrencyDAO storage;
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<String> listCurrencies() {
        List<String> currencies = new ArrayList();
        for(Currency cur : storage.listCurrencies()) {
            currencies.add(cur.getName());
        }
        return currencies;
    }
    
    public float convert(String from, String to, float amount){
        try {
        float rate = storage.getRate(new ConversionratePK(from, to)).getRate();
        return amount * rate;
        } catch (Exception e) {
            return -1;
        }
    }
}
