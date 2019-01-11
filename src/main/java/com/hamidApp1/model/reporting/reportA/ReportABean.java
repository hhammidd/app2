package com.hamidApp1.model.reporting.reportA;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class ReportABean {
    @Id
    private String day;
    private LocalDate date;
    private String produtto;

    public ReportABean() {
    }

    public ReportABean(String day, LocalDate date, String produtto) {
        this.day = day;
        this.date = date;
        this.produtto = produtto;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getProdutto() {
        return produtto;
    }

    public void setProdutto(String produtto) {
        this.produtto = produtto;
    }

    @Override
    public String toString() {
        return "ReportABean{" +
                "day='" + day + '\'' +
                ", date=" + date +
                ", produtto='" + produtto + '\'' +
                '}';
    }
}
