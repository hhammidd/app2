package com.hamidApp1.model.geoLayersModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class GeoPvFilter {
    @Id
    private int id_pv;
    private String cod_cliente;
    private String code_mgis;
    private String region_social;
    private String address;
    private int cap;
    private String comune;
    private String province;
    private String telephone;
    private String telephone2;
    private String telephone3;
    private String codice_fiscale;
    private  String title;
    private String fax;
    private String email;
    private String site;
    private String cliente;
    private Date mod_date;
    private String note;
    private String coords;

    public GeoPvFilter() {
    }

    public GeoPvFilter(int id_pv, String cod_cliente, String code_mgis, String region_social, String address, int cap, String comune, String province, String telephone, String telephone2, String telephone3, String codice_fiscale, String title, String fax, String email, String site, String cliente, Date mod_date, String note, String coords) {
        this.id_pv = id_pv;
        this.cod_cliente = cod_cliente;
        this.code_mgis = code_mgis;
        this.region_social = region_social;
        this.address = address;
        this.cap = cap;
        this.comune = comune;
        this.province = province;
        this.telephone = telephone;
        this.telephone2 = telephone2;
        this.telephone3 = telephone3;
        this.codice_fiscale = codice_fiscale;
        this.title = title;
        this.fax = fax;
        this.email = email;
        this.site = site;
        this.cliente = cliente;
        this.mod_date = mod_date;
        this.note = note;
        this.coords = coords;
    }

    public int getId_pv() {
        return id_pv;
    }

    public void setId_pv(int id_pv) {
        this.id_pv = id_pv;
    }

    public String getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(String cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getCode_mgis() {
        return code_mgis;
    }

    public void setCode_mgis(String code_mgis) {
        this.code_mgis = code_mgis;
    }

    public String getRegion_social() {
        return region_social;
    }

    public void setRegion_social(String region_social) {
        this.region_social = region_social;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getTelephone3() {
        return telephone3;
    }

    public void setTelephone3(String telephone3) {
        this.telephone3 = telephone3;
    }

    public String getCodice_fiscale() {
        return codice_fiscale;
    }

    public void setCodice_fiscale(String codice_fiscale) {
        this.codice_fiscale = codice_fiscale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getMod_date() {
        return mod_date;
    }

    public void setMod_date(Date mod_date) {
        this.mod_date = mod_date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCoords() {
        return coords;
    }

    public void setCoords(String coords) {
        this.coords = coords;
    }

    @Override
    public String toString() {
        return "GeoPvFilter{" +
                "id_pv=" + id_pv +
                ", cod_cliente='" + cod_cliente + '\'' +
                ", code_mgis='" + code_mgis + '\'' +
                ", region_social='" + region_social + '\'' +
                ", address='" + address + '\'' +
                ", cap=" + cap +
                ", comune='" + comune + '\'' +
                ", province='" + province + '\'' +
                ", telephone='" + telephone + '\'' +
                ", telephone2='" + telephone2 + '\'' +
                ", telephone3='" + telephone3 + '\'' +
                ", codice_fiscale='" + codice_fiscale + '\'' +
                ", title='" + title + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", site='" + site + '\'' +
                ", cliente='" + cliente + '\'' +
                ", mod_date=" + mod_date +
                ", note='" + note + '\'' +
                ", coords='" + coords + '\'' +
                '}';
    }
}
