package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public Map<String, String> dataSheet;
	
	public static Map<String, String> readExcelData(String sheetName){
		File f = new File("src/test/resources/TextData.xlsx");
		InputStream is = null;
		try {
			is = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Workbook wb = null;
		try {
			wb = new XSSFWorkbook(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet(sheetName);
		Map<String, String> sheetData = new LinkedHashMap<String,String>();
		if(null == sheet){
			System.out.println("Sheet name is not provided correctly. Entered value is "+sheetName);
			System.exit(0);
		}
		for(int i = 0;i<sheet.getPhysicalNumberOfRows();i++){
			Row row = sheet.getRow(i);
			String name = row.getCell(0).getStringCellValue();
			String value = null;
			Cell valueCell = row.getCell(1);
			if(null != valueCell){
				switch(valueCell.getCellTypeEnum()){
				case STRING:
					value = valueCell.getStringCellValue();
					break;
				case BOOLEAN:
					value = String.valueOf(valueCell.getBooleanCellValue());
					break;
				case NUMERIC:
					double ori = valueCell.getNumericCellValue();
					long modified = Math.round(ori);
					if(ori == modified){
						value = String.valueOf(modified);
					}else{
						value = String.valueOf(ori);
					}
					break;
				default :
					System.out.println("Not a valid value for "+valueCell.getAddress());
				}
			}else{
				System.out.println("No value has been entered for header "+name);
			}
			
			sheetData.put(name, value);
		}
		
		return sheetData;
		
		
	}
	
}
