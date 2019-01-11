package com.hamidApp1.dao.reporting.reportA;

import com.hamidApp1.model.reporting.reportA.GenericReportA;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public interface ReportQueryDao {
    List<GenericReportA> findReportAinfo(List<Object> par);

    void insertWorkbookInDb(Workbook workbook, Object o, boolean b, String reportA);
}
