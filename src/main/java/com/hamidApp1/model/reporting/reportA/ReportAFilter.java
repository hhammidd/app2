package com.hamidApp1.model.reporting.reportA;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReportAFilter {

    @Id
    private String monthReport;
    private String eur;

    public ReportAFilter() {
    }

    public ReportAFilter(String monthReport, String eur) {
        this.monthReport = monthReport;
        this.eur = eur;
    }

    public String getMonthReport() {
        return monthReport;
    }

    public void setMonthReport(String monthReport) {
        this.monthReport = monthReport;
    }

    public String getEur() {
        return eur;
    }

    public void setEur(String eur) {
        this.eur = eur;
    }

    @Override
    public String toString() {
        return "ReportAFilter{" +
                "monthReport='" + monthReport + '\'' +
                ", eur='" + eur + '\'' +
                '}';
    }
}
