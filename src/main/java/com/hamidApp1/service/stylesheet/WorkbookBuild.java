package com.hamidApp1.service.stylesheet;

import com.hamidApp1.model.reporting.reportA.GenericReportA;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public interface WorkbookBuild {
    Workbook build(List<GenericReportA> repBeanList);
}
