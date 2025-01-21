package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static XSSFWorkbook wb;

    public ExcelReader(){
        File file = new File("./src/test/java/resources/Test_data.xlsx");
        try {
            FileInputStream fis = new FileInputStream(file);
            wb = new XSSFWorkbook(fis);
        }
        catch(IOException e){
            System.out.println("No such file: "+e.getMessage());
        }
    }

    public static String getStringData(String sheetName, int row, int col){
        return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
    }

}
