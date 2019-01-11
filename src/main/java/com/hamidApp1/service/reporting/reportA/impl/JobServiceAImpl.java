/*
package com.hamidApp1.service.reporting.reportA.impl;

import com.hamidApp1.dao.reporting.reportA.ReportQueryDao;
import com.hamidApp1.model.reporting.reportA.GenericReportA;
import com.hamidApp1.service.reporting.reportA.JobService;
import com.hamidApp1.service.stylesheet.ReportABuilder;
import com.hamidApp1.service.stylesheet.WorkbookBuild;
import com.hamidApp1.service.util.GenericResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceAImpl implements JobService {

    @Autowired
    private ReportQueryDao reportQueryDao;

    @Override
    public List<GenericReportA> getDataReportAService(List<Object> par, String reportA) {
        List<GenericReportA> reportABean = new ArrayList<>();
        reportABean = reportQueryDao.findReportAinfo(par);

        WorkbookBuild build = new ReportABuilder();
        Workbook workbook = build.build(reportABean);

        reportQueryDao.insertWorkbookInDb(workbook, par.get(1), false,"ReportA");
        return null;
    }
}
*/