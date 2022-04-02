package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindAll;

public class FBpojo extends BaseClass{
	
	public FBpojo() {
	 

		PageFactory.initElements(driver, this);
			
	}

	@FindAll({
		@FindBy(xpath="//input[@id='emaaaaaail']"),
		@FindBy(xpath="//input[@type='text']"),
		@FindBy(xpath="//input[@placeholder='Email address or phone number']")
		
	})
	
	private WebElement txtUser;
	
	@FindBy(id="pass")
	
	private WebElement txtPass;
	
	@FindBy(id="login")
	
	private WebElement btnClk;

	public WebElement getTxtUser() {
		return txtUser;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getBtnClk() {
		return btnClk;
	}

}
