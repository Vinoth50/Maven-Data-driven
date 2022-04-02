package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pojo.FBpojo;

public class Sample extends BaseClass{
	public static void main(String[] args) throws IOException, InterruptedException {
	 
		launchBrowser();
	    lauchUrl("https://www.facebook.com/");
	    maxwin();

   Thread.sleep(5000);
	
   FBpojo l = new FBpojo();
   
   toinput(l.getTxtUser(),"Java");
   
   toinput(l.getTxtPass(),"python");
      
	}

}
