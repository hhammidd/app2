package com.hamidApp1.controller.reportTimeController;

import com.hamidApp1.model.reportTiming.ReportMontlyListBean;
import com.hamidApp1.model.reportTiming.TrendInputBean;
import com.hamidApp1.service.reportTimeService.ReportTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reporttiming")
public class reportTimeController {

    @Autowired
    private ReportTimeService reportTimeService;

    @RequestMapping(value = "/lasthourdelay", method = RequestMethod.POST)
    public List<ReportMontlyListBean> getReportTimeMontly(@RequestBody @Valid TrendInputBean input) {
        List<ReportMontlyListBean> output = null;

        output = reportTimeService.getMontlyReport();

        if (output != null) {
            return output;
        } else
        return null;
    }

}
