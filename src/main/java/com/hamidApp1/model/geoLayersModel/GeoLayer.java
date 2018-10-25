package com.hamidApp1.model.geoLayersModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class GeoLayer implements Serializable {
    @Id
    private ArrayList<String> reg;
    private ArrayList<String> pro;
    private ArrayList<String> com;

    public GeoLayer() {
    }

    public GeoLayer(ArrayList<String> reg, ArrayList<String> pro, ArrayList<String> com) {
        this.reg = reg;
        this.pro = pro;
        this.com = com;
    }

    public ArrayList<String> getReg() {
        return reg;
    }

    public void setReg(ArrayList<String> reg) {
        this.reg = reg;
    }

    public ArrayList<String> getPro() {
        return pro;
    }

    public void setPro(ArrayList<String> pro) {
        this.pro = pro;
    }

    public ArrayList<String> getCom() {
        return com;
    }

    public void setCom(ArrayList<String> com) {
        this.com = com;
    }

    @Override
    public String toString() {
        return "GeoLayer{" +
                "reg=" + reg +
                ", pro=" + pro +
                ", com=" + com +
                '}';
    }
}
