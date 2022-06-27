package BaseCode;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public ArrayList getTestingData (String path){
		try {
			ArrayList testData = new ArrayList();
			FileInputStream f = new FileInputStream(path);
			XSSFWorkbook b = new XSSFWorkbook(f);
			XSSFSheet s = b.getSheetAt(0);
			Iterator<Row> r = s.iterator();
			while (r.hasNext()) {
				Row ro = r.next();
				Iterator<Cell> ce = ro.cellIterator();
				while (ce.hasNext()) {
					Cell c = ce.next();
					if (c.getCellType() == CellType.STRING) {
						testData.add(c.getStringCellValue());
					}
					if (c.getCellType() == CellType.NUMERIC) {
						testData.add(c.getNumericCellValue());
					}
				}
			}
			return testData;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
