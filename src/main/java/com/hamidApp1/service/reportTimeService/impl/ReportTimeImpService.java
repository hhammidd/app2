package com.hamidApp1.service.reportTimeService.impl;

import com.hamidApp1.dao.reportTime.ReportMonthDao;
import com.hamidApp1.model.reportTiming.ReportMontlyListBean;
import com.hamidApp1.service.reportTimeService.ReportTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportTimeImpService implements ReportTimeService {

    @Autowired
    private ReportMonthDao reportMonthDao;

    @Override
    public List<ReportMontlyListBean> getMontlyReport() {
        List<ReportMontlyListBean> monthlyList = null;
        monthlyList = reportMonthDao.reportMonthly();
        return monthlyList;
    }
}
