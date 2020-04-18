package MySuvidha.in.utilities;

import static org.testng.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.PublicKey;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public  String path;
	public FileInputStream fis1= null;
	public FileOutputStream fos= null;
	private XSSFWorkbook workbook= null;
	private XSSFSheet sheet= null;
	private XSSFRow row= null;
	private XSSFCell cell= null;	
	

	 public ExcelReader(String path) {
		this.path=path;
		try {
			fis1= new FileInputStream(path);
			
			workbook= new XSSFWorkbook(fis1);
			sheet= workbook.getSheetAt(0);
			//fis1.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	public int getRowCount(String sheetName)
	{
		sheet= workbook.getSheet(sheetName);
		return sheet.getLastRowNum();
	}
	
	public int getColCount(String sheetName)
	{
		sheet= workbook.getSheet(sheetName);
		row= sheet.getRow(0);
		return row.getLastCellNum();
	}
	
	public Object getCellData(String sheetName,int rowNum,int colNum)
	{
		sheet= workbook.getSheet(sheetName);
		row= sheet.getRow(rowNum);
		cell=row.getCell(colNum);
		return cell.getStringCellValue();
		
	}
	

	public Object getCellData(String sheetName,int rowNum,String col)
	{
		sheet= workbook.getSheet(sheetName);
		row= sheet.getRow(rowNum);
		int cols= row.getLastCellNum();
		int colNum=-1;
		
		for(int i=1;i<cols;i++)
		{
			
			if(row.getCell(i).getStringCellValue().equalsIgnoreCase("col"))
			{
				colNum=i;
			}
			
		}
		
		
		
		cell=row.getCell(colNum);
		return cell.getStringCellValue();
		
	}
	
	
	

}
