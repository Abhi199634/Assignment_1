package assignment;

import utilities.ReadExcel;

public class ExcelUtilTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReadExcel reader = new ReadExcel("C:\\Users\\abhishek.gupta05\\eclipse-workspace\\assignment\\src\\test\\java\\utilities\\sample_Data.xlsx");
		String sheetName = "login";
		
		System.out.println(reader.getCellData(sheetName, "username", 3));
		String data = reader.getCellData(sheetName, 0, 2);
		System.out.println(data);
		
		int rowCount = reader.getRowCount(sheetName);
		System.out.println("total rows: "+ rowCount);
		
		//reader.addColumn(sheetName, "status");

	}

}
