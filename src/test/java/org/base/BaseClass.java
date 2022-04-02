package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static Select s;
	
	public static void launchBrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();

	}
	public static void lauchUrl(String url) {
		driver.get(url);
	}

	public static void maxwin() {
		driver.manage().window().maximize();
	}

	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println("title:" + title);

	}

	public static void toGetUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("url:" + url);
	}

	public static void toClose() {
		driver.quit();
	}


	public static void btnClk(WebElement e) {
		e.click();
	}

	public static void toApplyWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	public static void toGetValue(WebElement ele) {
		String name = ele.getAttribute("value");

	}
	public static void toMove(WebElement e) {
	 a = new Actions(driver);
	 a.moveToElement(e).perform();
	}
	public static void toDoubleClk(WebElement ele) {
            a=new Actions(driver);
            a.doubleClick(ele).perform();
	}
	public static void toRightClk(WebElement e) {
      a=new Actions(driver);
      a.contextClick(e).perform();
	}
	
	public static void toCopy() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONVERT);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
		
	}
	public static void toinput(WebElement element,String input) {
       element.sendKeys(input);
	}
	public static void toTakeSnap(String filename) throws IOException {
    TakesScreenshot t = (TakesScreenshot)driver;
    File scr = t.getScreenshotAs(OutputType.FILE);
    File desk = new File("C:\\Users\\ELCOT\\eclipse-workspace\\MavenSample\\Screenshort\\"+filename+".png");
    FileUtils.copyFile(scr,desk);
	}	
	public static void getName() {
		Scanner s =new Scanner(System.in);
		System.out.println("enter the file name");
		String name = s.next();
		}

	public static  String excelRead(int row,int cell) throws IOException {
		
	File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\MavenSample\\Excel Data\\test01.xls");
				FileInputStream file = new FileInputStream(f);
			Workbook w = new HSSFWorkbook(file);
			Sheet s=w.getSheet("Sheet1");
        Row r = s.getRow(row);
        Cell c = r.getCell(cell);
		 int cellType = c.getCellType();
        
		 String value;
		if (cellType==1) {
			 value = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date d = c.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd-mm-yyyy");
			  value = sim.format(d);
		} else {
               double dd = c.getNumericCellValue();
              long l = (long) dd;
                value = String.valueOf(l);     
               
		}
		
		return value;
		}
		 
		 
     
		}
        
        
			
			
		
		
	

		

	

