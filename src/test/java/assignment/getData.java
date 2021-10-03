package assignment;

import java.util.ArrayList;

import utilities.ReadExcel;

public class getData {

	
		// TODO Auto-generated method stub
			
	public ArrayList<String> get_data() {
		
		ArrayList<String> ar = new ArrayList<String>();
		
		ReadExcel reader = new ReadExcel("C:\\Users\\abhishek.gupta05\\eclipse-workspace\\assignment\\src\\test\\java\\utilities\\sample_Data.xlsx");
		String sheetName = "Data";
		
		int rowCount = reader.getRowCount(sheetName);
		
		for(int rowNum=2; rowNum<=rowCount; rowNum++){
			String phone_number = reader.getCellData(sheetName, "Mobile Number", rowNum);
			String Email_adress = reader.getCellData(sheetName, "Email_Address", rowNum);
			String First_Name = reader.getCellData(sheetName, "First Name", rowNum);
			String Last_Name = reader.getCellData(sheetName, "Last Name", rowNum);
			
			ar.add(phone_number);
			ar.add(Email_adress);
			ar.add(First_Name);
			ar.add(Last_Name);
			}
		return ar;
	}
}


