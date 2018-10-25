package com.hamidApp1.service.exportImportService;

import org.springframework.web.multipart.MultipartFile;

public interface ExportImportService {
    int csvImportLoadJob(MultipartFile csvFileName, String dateIn, String userCode);
    int excelImportLoadJob(MultipartFile excelFileName, String dateIn, String userCode);
}
