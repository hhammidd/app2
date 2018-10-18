package com.hamidApp1.model.reportTiming;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReportMontlyListBean {

    @Id
    private String fiyear;
    //private String Refweek;
    private String month;
    private String counter;

    public ReportMontlyListBean() {
    }

    public ReportMontlyListBean(String fiyear, String month, String counter) {
        this.fiyear = fiyear;
        this.month = month;
        this.counter = counter;
    }

    public String getFiyear() {
        return fiyear;
    }

    public void setFiyear(String fiyear) {
        this.fiyear = fiyear;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "ReportMontlyListBean{" +
                "fiyear='" + fiyear + '\'' +
                ", month='" + month + '\'' +
                ", counter='" + counter + '\'' +
                '}';
    }
}
