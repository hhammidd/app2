/*
package com.hamidApp1.controller.reporting.reportA;

import com.hamidApp1.model.istat.Istat_it;
import com.hamidApp1.model.istat.Istat_it_filter;
import com.hamidApp1.model.reporting.reportA.GenericReportA;
import com.hamidApp1.model.reporting.reportA.ReportAFilter;
import com.hamidApp1.service.reporting.reportA.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reporting")
public class ReportAController {

    @Autowired
    private JobService jobService;

    @RequestMapping( value = "/getreporta", method = RequestMethod.POST)
    public void getHistMailList(
            @RequestBody @Valid ReportAFilter input) throws SQLException {

        ReportAFilter raf = new ReportAFilter();

        String monthReport = raf.getMonthReport();

        List<Object> par = new ArrayList<>();
        par.add(monthReport);
        par.add("EUR");

        List<GenericReportA> repBeanList = jobService.getDataReportAService(par,"reportA");
    }

}
*/