package com.hamidApp1.service.exportImportService.impl;

import com.hamidApp1.dao.importExportDao.ExportImportQueryDao;
import com.hamidApp1.service.exportImportService.ExportImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExportImportServiceImpl implements ExportImportService {

    private static final String UNDEFINED = "undefined" ;

    @Autowired
    private ExportImportQueryDao exportImportQueryDao;

    @Override
    public int csvImportLoadJob(MultipartFile csvFileName, String dateIn, String userCode) {

        if (dateIn != null && !dateIn.equals(UNDEFINED) && userCode != null && !userCode.equals(UNDEFINED)){
            return exportImportQueryDao.csvImportLoadFile(csvFileName, dateIn, userCode);
        } else {
            return 2;
        }

    }
}
