package com.hamidApp1.dao.importExportDao;

import org.springframework.web.multipart.MultipartFile;

public interface ExportImportQueryDao {
    int csvImportLoadFile(MultipartFile csvFileName, String dateIn, String userCode);

    int excelImportLoadFile(MultipartFile excelFileName, String dateIn, String userCode);
}
