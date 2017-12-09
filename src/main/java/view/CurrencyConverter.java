/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;

/**
 *
 * @author Bernardo
 */
@Named(value = "currencyConverter")
@ConversationScoped
public class CurrencyConverter implements Serializable {
    @EJB
    private Controller controller;
    private String from;
    private String to;
    private float amountFrom;
    private float amountTo;
    private List<String> currencies;

    /**
     * Creates a new instance of CurrencyConverter
     */
    public CurrencyConverter() {
    }
    
    
    /**
     * @return the controller
     */


    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return the amountFrom
     */
    public float getAmountFrom() {
        return amountFrom;
    }

    /**
     * @param amountFrom the amountFrom to set
     */
    public void setAmountFrom(float amountFrom) {
        this.amountFrom = amountFrom;
    }

    /**
     * @return the amountTo
     */
    public float getAmountTo() {
        return amountTo;
    }

    /**
     * @param amountTo the amountTo to set
     */
    public void setAmountTo(float amountTo) {
        this.amountTo = amountTo;
    }

    /**
     * @return the currencies
     */
    public List<String> getCurrencies() {
        currencies = new ArrayList<String>();
        currencies.add("euros");
        currencies.add("sek");
        return currencies;
    }

    /**
     * @param currencies the currencies to set
     */
    public void setCurrencies(List<String> currencies) {
        this.currencies = currencies;
    }
    
}
