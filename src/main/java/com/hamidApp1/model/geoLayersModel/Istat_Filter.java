package com.hamidApp1.model.geoLayersModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Istat_Filter {
    @Id
    @Column(name = "id")
    private int istat_id;

    public Istat_Filter() {
    }

    public Istat_Filter(int istat_id) {
        this.istat_id = istat_id;
    }

    public int getIstat_id() {
        return istat_id;
    }

    public void setIstat_id(int istat_id) {
        this.istat_id = istat_id;
    }

    @Override
    public String toString() {
        return "Istat_Filter{" +
                "istat_id=" + istat_id +
                '}';
    }
}
