package com.hamidApp1.service.reporting.reportA;

import com.hamidApp1.model.reporting.reportA.GenericReportA;

import java.util.List;

public interface JobService {
    List<GenericReportA> getDataReportAService(List<Object> par, String reportA);
}
