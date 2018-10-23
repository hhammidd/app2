package com.hamidApp1.model.ExportImportModel.csvExam1.tables;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class ImpCsvPrim implements Serializable {

    private String source_file;
    private BigDecimal numRow;

    public ImpCsvPrim() {
    }

    public ImpCsvPrim(String source_file, BigDecimal numRow) {
        this.source_file = source_file;
        this.numRow = numRow;
    }

    public String getSource_file() {
        return source_file;
    }

    public void setSource_file(String source_file) {
        this.source_file = source_file;
    }

    public BigDecimal getNumRow() {
        return numRow;
    }

    public void setNumRow(BigDecimal numRow) {
        this.numRow = numRow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImpCsvPrim that = (ImpCsvPrim) o;
        return Objects.equals(source_file, that.source_file) &&
                Objects.equals(numRow, that.numRow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source_file, numRow);
    }
}
