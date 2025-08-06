package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataRead {
	
	public static Object[][] excelReader(String fileName) throws IOException {

		Object[][] value =null;
		String Sheet ="IdSheet" ;
		String filePath="./Data/"+fileName+".xlsx";
		File Ofile=new File(filePath);
		FileInputStream Oinput=new FileInputStream(Ofile); 
		XSSFWorkbook oWorkBook = new XSSFWorkbook(Oinput);
		XSSFSheet sheet = oWorkBook.getSheet(Sheet);
		//get number of row 3
		int lastRowNum = sheet.getLastRowNum();
		//get the number of column 3
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		
		value=new Object[lastRowNum][lastCellNum];
		//loop through the row
		for (int i = 1; i <=lastRowNum; i++) {
			XSSFRow row=sheet.getRow(i);
			
			for (int j = 0; j < lastCellNum; j++) {
				Object cellValue =null;
				
				XSSFCell cell=row.getCell(j);
				CellType cellType=cell.getCellType();
				
				switch (cell.getCellType()) {
				case NUMERIC:
					long numeric=(long)cell.getNumericCellValue();
					String ValueOfNumeric=String.valueOf(numeric);
					cellValue=ValueOfNumeric;
					break;
				case STRING:
					cellValue=cell.getStringCellValue();
					break;
				case BOOLEAN:
					cellValue=cell.getBooleanCellValue();
					break;
				case ERROR:
					System.out.println("it is an empty row!.....");
					break;
				default:
					System.out.println("error in reading the data");
					break;
				}
				value[i-1][j]=cellValue;
			
			
		}
		Oinput.close();
		oWorkBook.close();
		return value;
		

	}
		return value;

	}
	

}
