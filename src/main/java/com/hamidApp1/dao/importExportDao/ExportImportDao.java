package com.hamidApp1.dao.importExportDao;

import com.hamidApp1.model.ExportImportModel.csvExam1.tables.Importcsv1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ExportImportDao extends JpaRepository<Importcsv1,String> {

    @Modifying
    @Transactional
    @Query("delete from Importcsv1 i where i.type_fraud = ?1")
    void deleteLoadcsvByOperator(String thisId);
}
