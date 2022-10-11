package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObject.Taregetwebsite;
import Resources.base;


public class otherPage extends base{
	
	public void initilize() throws IOException
	{
		driver=	initializeDriver();
		
	}

	public WebDriver driver;
	
	By tagName=By.tagName("a");
	

	public void brokenLinks(WebDriver  driver)
	{
		Taregetwebsite portal=new Taregetwebsite(driver);
		List<WebElement> links= ((WebDriver) portal).findElements(tagName);
		for(int i=0;i<=links.size();i++)
		{
			WebElement element=links.get(i);
			String url=element.getAttribute("href");
		}
	}

}
