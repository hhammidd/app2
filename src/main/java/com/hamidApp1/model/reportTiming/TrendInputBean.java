package com.hamidApp1.model.reportTiming;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TrendInputBean {

    @Id
    private String period;

    public TrendInputBean() {
    }

    public TrendInputBean(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "TrendInputBean{" +
                "period='" + period + '\'' +
                '}';
    }
}
