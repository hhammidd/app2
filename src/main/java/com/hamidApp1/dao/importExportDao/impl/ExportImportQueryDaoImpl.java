package com.hamidApp1.dao.importExportDao.impl;

import com.hamidApp1.dao.importExportDao.ExportImportDao;
import com.hamidApp1.dao.importExportDao.ExportImportQueryDao;
import com.hamidApp1.model.ExportImportModel.csvExam1.ExportImportCsvBean;
import com.hamidApp1.model.ExportImportModel.csvExam1.ExportImportLog;
import com.hamidApp1.model.ExportImportModel.csvExam1.tables.ImpCsvPrim;
import com.hamidApp1.model.ExportImportModel.csvExam1.tables.Importcsv1;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Component
public class ExportImportQueryDaoImpl implements ExportImportQueryDao {

    @Autowired
    private ExportImportDao exportImportDao;

    private static final String IMPORT_SOURCE_FILE_PREFIX = "CUP_";
    private static final SimpleDateFormat DATE_FORMAT_OUTPUT = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat IMPORT_DATE_FORMATTING = new SimpleDateFormat("yyyyMMdd");
    private static final SimpleDateFormat CUP_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

    @Override
    public int csvImportLoadFile(MultipartFile csvFileName, String dateIn, String userCode) {
        BufferedReader br = null;
        LocalDate date = LocalDate.now();
        Date dateAbb = java.sql.Date.valueOf(date);
        Date sourceDate = null;
        
        List<ExportImportCsvBean> exportImportCsvBeanList = new ArrayList<ExportImportCsvBean>();
        ExportImportCsvBean exportImportCsvObj = null;
        ExportImportLog exportImportLogObj = null;

        int result = 0;

        Map<String, Integer> sourceFileMap = new HashMap<>();
        int numRow = 0;

        try {
            InputStream inputStream = csvFileName.getInputStream();
            br = new BufferedReader(new InputStreamReader(inputStream));

            SimpleDateFormat dateFormatInput = new SimpleDateFormat("ddMMyyyy");
            Date processedDate = dateFormatInput.parse(dateIn);
            
            String line = br.readLine();
            String csvSplit = ",";
            
            int processesRows = 0;
            
            while ((line = br.readLine()) != null){
                line = line.replace("\"", "");
                
                processesRows++;
                
                exportImportCsvObj = new ExportImportCsvBean();
                exportImportCsvObj.setSource_file(IMPORT_SOURCE_FILE_PREFIX + DATE_FORMAT_OUTPUT.format(processedDate));
                exportImportCsvObj.setNumRow(BigDecimal.valueOf(processesRows));
                
                String[] csvField = line.split(csvSplit);
                sourceDate = IMPORT_DATE_FORMATTING.parse(csvField[2].trim());
                String merchantDesc = csvField[8];
                if (merchantDesc.length() > 25) {
                    merchantDesc = merchantDesc.substring(0, 25);
                }
                exportImportCsvObj.setOperator(merchantDesc);

                if (csvField[3] != null){
                    exportImportCsvObj.setType_fraud(csvField[3].substring(0, 1));
                } else {
                    exportImportCsvObj.setType_fraud(" ");
                }

                exportImportCsvObj.setCity(" ");
                exportImportCsvObj.setMcc(" ");
                exportImportCsvObj.setAmount(Double.valueOf(csvField[14].trim()));
                exportImportCsvObj.setIssuer_bin(" ");
                exportImportCsvObj.setIca(csvField[5].trim());
                exportImportCsvObj.setDate_movi(IMPORT_DATE_FORMATTING.parse(csvField[12].trim()));
                exportImportCsvObj.setPan(csvField[4]);
                exportImportCsvObj.setMovie(csvField[0]);
                exportImportCsvObj.setPos_enter_mod(" ");
                exportImportCsvObj.setSource_code(" ");
                exportImportCsvObj.setCard_present(" ");
                exportImportCsvObj.setCh_present(" ");
                exportImportCsvObj.setPos_type(" ");
                exportImportCsvObj.setTerm_cat(" ");
                exportImportCsvObj.setCod_eser(csvField[7].trim());
                exportImportCsvObj.setCode_scart(null);
                exportImportCsvObj.setElaborate(BigDecimal.ZERO);
                // this is dateNow
                exportImportCsvObj.setDate_abb(dateAbb);
                // user logined Code
                exportImportCsvObj.setUser_abb(userCode);

                exportImportCsvBeanList.add(exportImportCsvObj);
            }

            //insertLoadedCsvToDb(exportImportCsvBeanList);

            if (processesRows > 0) {
                sourceFileMap.put(exportImportCsvObj.getSource_file(), processesRows);
                insertLoadCsvLog(sourceFileMap, userCode);
            } else {
                result = 2;
            } if (result == 0) {
                // an example for delete by the
                //deleteLoadCsvLog("C");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    /**
     * This is excel load example
     * @param excelFileName
     * @param dateIn
     * @param userCode
     * @return
     */
    @Override
    public int excelImportLoadFile(MultipartFile excelFileName, String dateIn, String userCode) {
        int result = 0;
        InputStream inputStream = null;
        Workbook workbook = null;
        LocalDate date = LocalDate.now();
        Date dateAbb = java.sql.Date.valueOf(date);
        Date sourceDate = null;
        List<ExportImportCsvBean> exportImportCsvBeanList = new ArrayList<ExportImportCsvBean>();
        ExportImportCsvBean exportImportCsvObj = null;
        ExportImportLog exportImportLogObj = null;
        Map<String, Integer> sourceFileMap = new HashMap<String, Integer>();

        try {

            SimpleDateFormat dateFormatInput = new SimpleDateFormat("ddMMyyyy");
            Date processedDate = dateFormatInput.parse(dateIn);

            inputStream = excelFileName.getInputStream();

            workbook = getWorkbook(inputStream, excelFileName.getOriginalFilename());

            Sheet fisrtSheet = workbook.getSheetAt(0);

            Iterator<Row> iteratorRow = fisrtSheet.iterator();

            String merchDesc = null;

            int processesRows = 0;

            while (iteratorRow.hasNext()){
                Row nexRow = iteratorRow.next();

                // skip first row
                if (nexRow.getRowNum()==0)
                    continue;

                processesRows++;

                if ((nexRow.getCell(0)==null || nexRow.getCell(0).getStringCellValue().equals(""))
                && (nexRow.getCell(4)==null || nexRow.getCell(4).getStringCellValue().trim().equals(""))) {
                    System.out.println("Last Empty row"+ processesRows);
                    processesRows--;
                    break;
                }

                exportImportCsvObj = new ExportImportCsvBean();
                exportImportCsvObj.setSource_file(IMPORT_SOURCE_FILE_PREFIX + DATE_FORMAT_OUTPUT.format(processedDate));
                exportImportCsvObj.setNumRow(BigDecimal.valueOf(processesRows));

                sourceDate = CUP_DATE_FORMAT.parse(nexRow.getCell(2).getStringCellValue());
                exportImportCsvObj.setSourceDate(sourceDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

                String merchantDesc = nexRow.getCell(8).getStringCellValue().trim();
                if (merchantDesc.length() > 25) {
                    merchantDesc = merchantDesc.substring(0, 25);
                }
                exportImportCsvObj.setOperator(merchantDesc);

                if (nexRow.getCell(3) != null){
                    exportImportCsvObj.setType_fraud(nexRow.getCell(3).getStringCellValue().substring(0,1).trim());
                } else {
                    exportImportCsvObj.setType_fraud(" ");
                }

                exportImportCsvObj.setCity(" ");
                exportImportCsvObj.setMcc(" ");
                exportImportCsvObj.setAmount(Double.valueOf(nexRow.getCell(13).getStringCellValue()));
                exportImportCsvObj.setIssuer_bin(" ");
                exportImportCsvObj.setIca(nexRow.getCell(5).getStringCellValue().trim());
                exportImportCsvObj.setDate_movi(IMPORT_DATE_FORMATTING.parse(nexRow.getCell(12).getStringCellValue().trim()));
                exportImportCsvObj.setPan(nexRow.getCell(4).getStringCellValue().trim());

                exportImportCsvObj.setMovie(nexRow.getCell(0).getStringCellValue().trim());
                exportImportCsvObj.setPos_enter_mod(" ");
                exportImportCsvObj.setSource_code(" ");
                exportImportCsvObj.setCard_present(" ");
                exportImportCsvObj.setCh_present(" ");
                exportImportCsvObj.setPos_type(" ");
                exportImportCsvObj.setTerm_cat(" ");

                exportImportCsvObj.setCod_eser(nexRow.getCell(7).getStringCellValue().trim());
                exportImportCsvObj.setCode_scart(null);
                exportImportCsvObj.setElaborate(BigDecimal.ZERO);
                // this is dateNow
                exportImportCsvObj.setDate_abb(dateAbb);
                // user logined Code
                exportImportCsvObj.setUser_abb(userCode);

                exportImportCsvBeanList.add(exportImportCsvObj);
            }

            insertLoadedCsvToDb(exportImportCsvBeanList);

            if (processesRows > 0) {
                sourceFileMap.put(exportImportCsvObj.getSource_file(), processesRows);
                insertLoadCsvLog(sourceFileMap, userCode);
            } else {
                result = 2;
            } if (result == 0) {
                // an example for delete by the
                //deleteLoadCsvLog("C");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }


        return result;
    }

    private Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("Is not Excel File");
        }
        return workbook;
    }

    private void deleteLoadCsvLog(String thisId) {
        exportImportDao.deleteLoadcsvByOperator(thisId);
    }

    private void insertLoadCsvLog(Map<String, Integer> sourceFileMap, String userCode) {

    }


    private void insertLoadedCsvToDb(List<ExportImportCsvBean> exportImportCsvBeanList) {
        if (exportImportCsvBeanList.isEmpty()){
            return;
        }
        Importcsv1 eI = new Importcsv1();
        for (ExportImportCsvBean ei: exportImportCsvBeanList){
            System.out.println(ei.getSource_file()+ "vwww"+ ei.getNumRow());
        }
        for (ExportImportCsvBean eic : exportImportCsvBeanList){
            eI.setId(new ImpCsvPrim(eic.getSource_file(),eic.getNumRow()));
            eI.setSourceDate(null);
            eI.setOperator(eic.getOperator());
            eI.setCity(eic.getCity());
            eI.setMcc(eic.getMcc());
            eI.setType_fraud(eic.getType_fraud());
            eI.setAmount(eic.getAmount());
            eI.setIca(eic.getIca());
            eI.setIssuer_bin(eic.getIssuer_bin());
            eI.setDate_movi(eic.getDate_movi());
            eI.setPan(eic.getPan());
            eI.setMovie(eic.getMovie());
            eI.setPos_enter_mod(eic.getPos_enter_mod());
            eI.setSource_code(eic.getSource_code());
            eI.setCard_present(eic.getCard_present());
            eI.setPos_type(eic.getPos_type());
            eI.setTerm_cat(eic.getTerm_cat());
            eI.setCod_eser(eic.getCod_eser());
            eI.setCode_scart(eic.getCode_scart());
            eI.setElaborate(eic.getElaborate());
            eI.setDate_abb(eic.getDate_abb());
            eI.setUser_abb(eic.getUser_abb());
            exportImportDao.save(eI);
        }
    }
}
