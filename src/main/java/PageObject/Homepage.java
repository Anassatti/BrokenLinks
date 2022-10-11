package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.base;

public class Homepage extends base {
	
	public WebDriver driver;
	
	By Homepage=By.linkText("https://hukoomi.gov.qa/en/");
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
	}

	public WebElement getPortal()
	{
		return driver.findElement(Homepage);
	}
}
