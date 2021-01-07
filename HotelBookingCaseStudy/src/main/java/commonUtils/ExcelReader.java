package commonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class ExcelReader {
	 public String readData(String colName) throws IOException {
	       // String path = System.getProperty("C://Users//lr548299//eclipse-workspace//Mvn_framework-Artifact//HotelBookingCaseStudy//src//test//resources//testdata//TestData.xslx");
	        FileInputStream fis = new FileInputStream(new File("C://Users//lr548299//eclipse-workspace//Mvn_framework-Artifact//HotelBookingCaseStudy//src//test//resources//testdata//TestData.xlsx"));
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        XSSFSheet bookingDetails = workbook.getSheet("BookingDeatils");
	        String colValue= "";
	        for(int i=1;i<bookingDetails.getLastRowNum();i++)
	        {
	            XSSFRow row = bookingDetails.getRow(i);
	            if(row.getCell(0).getStringCellValue().equalsIgnoreCase(colName)) {
	                colValue = row.getCell(1).getStringCellValue();
	                
	               
	               
	            }
	           
	            
	        }
	        workbook.close();
	        return colValue;
	    }


}
