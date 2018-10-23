package com.hamidApp1.model.ExportImportModel.csvExam1;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class ExportImportLog {
    @Id
    private String nameS;
    private String userCode;
    private Timestamp dateLastIns;

    public ExportImportLog(String nameS, String userCode, Timestamp dateLastIns) {
        this.nameS = nameS;
        this.userCode = userCode;
        this.dateLastIns = dateLastIns;
    }

    public ExportImportLog() {
    }

    public String getNameS() {
        return nameS;
    }

    public void setNameS(String nameS) {
        this.nameS = nameS;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Timestamp getDateLastIns() {
        return dateLastIns;
    }

    public void setDateLastIns(Timestamp dateLastIns) {
        this.dateLastIns = dateLastIns;
    }

    @Override
    public String toString() {
        return "ExportImportLog{" +
                "nameS='" + nameS + '\'' +
                ", userCode='" + userCode + '\'' +
                ", dateLastIns=" + dateLastIns +
                '}';
    }
}

