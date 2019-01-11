package com.hamidApp1.dao.reporting.reportA.impl;

import com.hamidApp1.dao.reporting.reportA.ReportAQuery;
import com.hamidApp1.dao.reporting.reportA.ReportQueryDao;
import com.hamidApp1.model.reporting.reportA.GenericReportA;
import com.hamidApp1.model.reporting.reportA.ReportABean;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReportQueryDaoImpl implements ReportQueryDao {

    @Autowired
    private ReportAQuery reportAQuery;

    @Override
    public List<GenericReportA> findReportAinfo(List<Object> par) {
        List<GenericReportA> results = new ArrayList<>();

        String monthSel = (String) par.get(0);
        String sqlRep = (String) par.get(1);

        // do the store procedure and get back result

        return null;
    }

    @Override
    public void insertWorkbookInDb(Workbook workbook, Object o, boolean isEnc, String reportA) {

    }
}
