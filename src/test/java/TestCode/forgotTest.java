package TestCode;

import java.util.ArrayList;

import org.testng.annotations.Test;

import BaseCode.ExcelReader;
import BaseCode.Keywords;

public class forgotTest extends ExcelReader {
	@Test
	public void fbtest() {
		forgotTest login = new forgotTest();
		ArrayList testData = login.getTestingData("A:\\forgotpassword.xlsx");
		Keywords k = new Keywords();
		for(int i = 0;i<testData.size(); i++) {
			if(testData.get(i).equals("open")) {
				k.open();
				
			}
			if(testData.get(i).equals("url")) {
				k.url(testData.get(i+1).toString());
				
			}
			if(testData.get(i).equals("input")) {
				k.input(testData.get(i+1).toString(),testData.get(i+2).toString());
				
			}
			if(testData.get(i).equals("click")) {
				k.click(testData.get(i+2).toString());
				
			}
			if(testData.get(i).equals("band")) {
				k.band();
				
			}
		}
	}

}
