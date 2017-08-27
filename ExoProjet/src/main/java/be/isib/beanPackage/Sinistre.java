/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isib.beanPackage;

import java.util.Date;

/**
 *
 * @author Gagui
 */
public class Sinistre {
    private String nsin,lieu_acc,descr;
    private Date date_acc;

    public Sinistre() {
    }

    public String getNsin() {
        return nsin;
    }

    public void setNsin(String nsin) {
        this.nsin = nsin;
    }

    public String getLieu_acc() {
        return lieu_acc;
    }

    public void setLieu_acc(String lieu_acc) {
        this.lieu_acc = lieu_acc;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getDate_acc() {
        return date_acc;
    }

    public void setDate_acc(Date date_acc) {
        this.date_acc = date_acc;
    }
    
    
}
