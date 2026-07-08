package org.zigWheelsAutomation.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtils {
    private static final Logger log = LogManager.getLogger(ExcelUtils.class);
    public static void writeBikeDetails(String filePath,
                                        String sheetName,
                                        List<String> bikeNames,
                                        List<String> prices,
                                        List<String> launchDates) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet(sheetName);
            String[] columns = {"S.No", "Bike Name", "Price", "Expected Launch Date"};
            Row header = sheet.createRow(0);
            CellStyle style = createHeaderStyle(workbook);

            for (int i = 0; i < columns.length; i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(style);
            }
            int rowCount = Math.max(bikeNames.size(),
                    Math.max(prices.size(), launchDates.size()));
            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(i + 1);
                row.createCell(1).setCellValue(i < bikeNames.size() ? bikeNames.get(i) : "");
                row.createCell(2).setCellValue(i < prices.size() ? prices.get(i) : "");
                row.createCell(3).setCellValue(i < launchDates.size() ? launchDates.get(i) : "");
            }
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }
            File file = new File(filePath);
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            try (FileOutputStream fos = new FileOutputStream(file)) {
                workbook.write(fos);
            }
            log.info("Bike details written to: {}", filePath);
        }
        catch (IOException e) {
            log.error("Failed to write bike details to Excel", e);
            throw new RuntimeException(e);
        }
    }

    private static CellStyle createHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        return style;
    }
}