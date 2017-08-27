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
public class Dossier {
    private String ndos;
    private Date date_eng, date_ferm;

    public Dossier() {
    }

    public String getNdos() {
        return ndos;
    }

    public void setNdos(String ndos) {
        this.ndos = ndos;
    }

    public Date getDate_eng() {
        return date_eng;
    }

    public void setDate_eng(Date date_eng) {
        this.date_eng = date_eng;
    }

    public Date getDate_ferm() {
        return date_ferm;
    }

    public void setDate_ferm(Date date_ferm) {
        this.date_ferm = date_ferm;
    }

    
    
    
}
