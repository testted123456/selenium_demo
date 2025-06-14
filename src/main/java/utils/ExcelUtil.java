package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {

    public static List<Map<String, String>> readTestSteps(String filePath, String sheetName) {
        List<Map<String, String>> steps = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);
            Row header = sheet.getRow(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Map<String, String> step = new HashMap<>();
                Row row = sheet.getRow(i);
                for (int j = 0; j < header.getLastCellNum(); j++) {
                    String key = header.getCell(j).getStringCellValue();
                    String value = row.getCell(j) != null ? row.getCell(j).toString() : "";
                    step.put(key, value);
                }
                steps.add(step);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return steps;
    }
}
