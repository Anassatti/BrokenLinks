package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.base;

public class Taregetwebsite extends base {
	
	public WebDriver driver;
	
	
	By targetWebsite=By.linkText("Home");
	
	public Taregetwebsite(WebDriver driver)
	{
		this.driver=driver;
	}

	public WebElement getPortal()
	{
		return driver.findElement(targetWebsite);
	}
}
