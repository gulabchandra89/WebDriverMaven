package MySuvidha.in.rough;

import MySuvidha.in.utilities.ExcelReader;

public class ExcelObject {

	
	public static ExcelReader excelReader= new ExcelReader("D:\\Programs\\DataDriverFramwork\\src\\test\\resources\\excels\\TestData.xlsx");
	public static void main(String[] args) {
		
		String sheetNameString="signUpFB";	
		int rows=excelReader.getRowCount(sheetNameString);
		int cols= excelReader.getColCount(sheetNameString);
		
		Object[][] data= new Object[rows][cols];
		for(int rowNum=1;rowNum<=rows;rowNum++)
		{	
			for(int colNum=0;colNum<cols;colNum++)
			{
				data[rowNum-1][colNum]=  excelReader.getCellData(sheetNameString,rowNum,colNum);
							System.out.println(data[rowNum-1][colNum]);	
			}
			
		}

	}

}
