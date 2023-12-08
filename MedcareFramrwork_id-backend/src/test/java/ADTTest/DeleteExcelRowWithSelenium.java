package ADTTest;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class DeleteExcelRowWithSelenium {

	public static String TkaePatientName;

	//public static  String TakePatientName = kk;

	//public static void main(String[] args) {
	// Set the path to your Excel file
	String excelFilePath = "C:\\Users\\Kamlakar\\Desktop\\medcare06_11_2023\\MedcareFramrwork_Latestone\\MedcareFramrwork_0.1\\MedcareFramrwork_0.1\\MedcareFramrwork_id-backend\\Readdata.xlsx.xlsx";
	{


		try (FileInputStream fis = new FileInputStream(excelFilePath);
				Workbook workbook = new XSSFWorkbook(fis)) {

			// Access the specific sheet you want to modify (0 is the first sheet)
			Sheet sheet = workbook.getSheetAt(0);

			// Get the row index you want to read and delete (adjust as needed)
			int rowIndex = 0; // for example

			// Read and display the row data (you can customize this part)
			Row row = sheet.getRow(rowIndex);
			if (row != null) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					TkaePatientName = cell.toString();
					System.out.print(cell.toString() + "\t");
					break;
				}
				System.out.println(); // New line for the next row
			} else {
				System.out.println("Row index is out of range.");
			}

			// Delete the row
			if (rowIndex >= 0 && rowIndex < sheet.getPhysicalNumberOfRows()) {
				sheet.removeRow(row);
				sheet.shiftRows(rowIndex + 1, sheet.getLastRowNum(), -1); // Shift rows to close the gap
			} else {
				System.out.println("Row index is out of range.");
			}


			// Save the modified Excel file
			try (FileOutputStream fos = new FileOutputStream(excelFilePath)) {
				workbook.write(fos);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
