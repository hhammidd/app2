package com.hamidApp1.model.ExportImportModel.csvExam1.tables;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "importcsv1")

public class Importcsv1 {

    @EmbeddedId
    private ImpCsvPrim id;

    private LocalDate sourceDate;
    private String operator;
    private String city;
    private String mcc;
    private String type_fraud;
    private double amount;
    private String ica;
    private String issuer_bin;
    private Date date_movi;
    private String pan;
    private String movie;
    private String pos_enter_mod;
    private String source_code;
    private String card_present;
    private String ch_present;
    private String pos_type;
    private String term_cat;
    private String cod_eser;
    private BigDecimal code_scart;
    private BigDecimal elaborate;
    private Date date_abb;
    private String user_abb;

    public Importcsv1() {
    }

    public Importcsv1(ImpCsvPrim id, LocalDate sourceDate, String operator, String city, String mcc, String type_fraud, double amount, String ica, String issuer_bin, Date date_movi, String pan, String movie, String pos_enter_mod, String source_code, String card_present, String ch_present, String pos_type, String term_cat, String cod_eser, BigDecimal code_scart, BigDecimal elaborate, Date date_abb, String user_abb) {
        this.id = id;
        this.sourceDate = sourceDate;
        this.operator = operator;
        this.city = city;
        this.mcc = mcc;
        this.type_fraud = type_fraud;
        this.amount = amount;
        this.ica = ica;
        this.issuer_bin = issuer_bin;
        this.date_movi = date_movi;
        this.pan = pan;
        this.movie = movie;
        this.pos_enter_mod = pos_enter_mod;
        this.source_code = source_code;
        this.card_present = card_present;
        this.ch_present = ch_present;
        this.pos_type = pos_type;
        this.term_cat = term_cat;
        this.cod_eser = cod_eser;
        this.code_scart = code_scart;
        this.elaborate = elaborate;
        this.date_abb = date_abb;
        this.user_abb = user_abb;
    }

    public ImpCsvPrim getId() {
        return id;
    }

    public void setId(ImpCsvPrim id) {
        this.id = id;
    }

    public LocalDate getSourceDate() {
        return sourceDate;
    }

    public void setSourceDate(LocalDate sourceDate) {
        this.sourceDate = sourceDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getType_fraud() {
        return type_fraud;
    }

    public void setType_fraud(String type_fraud) {
        this.type_fraud = type_fraud;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getIca() {
        return ica;
    }

    public void setIca(String ica) {
        this.ica = ica;
    }

    public String getIssuer_bin() {
        return issuer_bin;
    }

    public void setIssuer_bin(String issuer_bin) {
        this.issuer_bin = issuer_bin;
    }

    public Date getDate_movi() {
        return date_movi;
    }

    public void setDate_movi(Date date_movi) {
        this.date_movi = date_movi;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getPos_enter_mod() {
        return pos_enter_mod;
    }

    public void setPos_enter_mod(String pos_enter_mod) {
        this.pos_enter_mod = pos_enter_mod;
    }

    public String getSource_code() {
        return source_code;
    }

    public void setSource_code(String source_code) {
        this.source_code = source_code;
    }

    public String getCard_present() {
        return card_present;
    }

    public void setCard_present(String card_present) {
        this.card_present = card_present;
    }

    public String getCh_present() {
        return ch_present;
    }

    public void setCh_present(String ch_present) {
        this.ch_present = ch_present;
    }

    public String getPos_type() {
        return pos_type;
    }

    public void setPos_type(String pos_type) {
        this.pos_type = pos_type;
    }

    public String getTerm_cat() {
        return term_cat;
    }

    public void setTerm_cat(String term_cat) {
        this.term_cat = term_cat;
    }

    public String getCod_eser() {
        return cod_eser;
    }

    public void setCod_eser(String cod_eser) {
        this.cod_eser = cod_eser;
    }

    public BigDecimal getCode_scart() {
        return code_scart;
    }

    public void setCode_scart(BigDecimal code_scart) {
        this.code_scart = code_scart;
    }

    public BigDecimal getElaborate() {
        return elaborate;
    }

    public void setElaborate(BigDecimal elaborate) {
        this.elaborate = elaborate;
    }

    public Date getDate_abb() {
        return date_abb;
    }

    public void setDate_abb(Date date_abb) {
        this.date_abb = date_abb;
    }

    public String getUser_abb() {
        return user_abb;
    }

    public void setUser_abb(String user_abb) {
        this.user_abb = user_abb;
    }

    @Override
    public String toString() {
        return "Importcsv1{" +
                "id=" + id +
                ", sourceDate=" + sourceDate +
                ", operator='" + operator + '\'' +
                ", city='" + city + '\'' +
                ", mcc='" + mcc + '\'' +
                ", type_fraud='" + type_fraud + '\'' +
                ", amount=" + amount +
                ", ica='" + ica + '\'' +
                ", issuer_bin='" + issuer_bin + '\'' +
                ", date_movi=" + date_movi +
                ", pan='" + pan + '\'' +
                ", movie='" + movie + '\'' +
                ", pos_enter_mod='" + pos_enter_mod + '\'' +
                ", source_code='" + source_code + '\'' +
                ", card_present='" + card_present + '\'' +
                ", ch_present='" + ch_present + '\'' +
                ", pos_type='" + pos_type + '\'' +
                ", term_cat='" + term_cat + '\'' +
                ", cod_eser='" + cod_eser + '\'' +
                ", code_scart=" + code_scart +
                ", elaborate=" + elaborate +
                ", date_abb=" + date_abb +
                ", user_abb='" + user_abb + '\'' +
                '}';
    }
}
