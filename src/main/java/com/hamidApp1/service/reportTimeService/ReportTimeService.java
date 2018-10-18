package com.hamidApp1.service.reportTimeService;

import com.hamidApp1.model.reportTiming.ReportMontlyListBean;

import java.util.List;

public interface ReportTimeService {
    List<ReportMontlyListBean> getMontlyReport();
}
