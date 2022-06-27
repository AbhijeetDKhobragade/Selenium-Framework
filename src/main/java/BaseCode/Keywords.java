package BaseCode;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Keywords {
	WebDriver d ;
	FileInputStream fis;
	Properties p ;
	FileInputStream fis1;
	Properties p1 ;
	public void open() {
		try {
			 fis = new FileInputStream("C:\\Users\\ASUS\\Desktop\\eclipse data\\Project1\\src\\main\\java\\BaseCode\\object.properties");
			 p = new Properties();
			p.load(fis);
			fis1 = new FileInputStream("C:\\Users\\ASUS\\Desktop\\eclipse data\\Project1\\src\\main\\java\\BaseCode\\browser.properties");
			 p1 = new Properties();
			p1.load(fis1);
			if(p1.getProperty("browsername").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "A:\\All exe files\\chromedriver.exe");
				 d = new ChromeDriver();
				 d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			}else if(p1.getProperty("browsername").equals("opera")) {
				System.setProperty("webdriver.opera.driver", "A:\\All exe files\\operadriver.exe");
				d = new OperaDriver();
				 d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

	public void url(String url) {
		d.get(url);
	}

	public void input(String testData, String objectName) {
		d.findElement(By.xpath(p.getProperty(objectName))).sendKeys(testData);
	}

	public void click(String objectName) {
		d.findElement(By.xpath(p.getProperty(objectName))).click();
	}

	public void band() {
		d.close();
	}

	

}
