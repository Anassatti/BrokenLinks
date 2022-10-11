package pageObjects;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import Resources.BrokenLinkReport;
import Resources.base;

public class BrokenLinks extends base {
	public WebDriver driver;
	static String url;

	
	@BeforeTest
	public void initilize() throws IOException, InterruptedException
	{
		driver=	initializeDriver();
        driver.manage().window().maximize();
		 driver.get(pro.getProperty("url"));
			//Thread.sleep(3000);
	}
	@Test
	public void brokenLinks() throws InterruptedException
	{
	
		// TODO Auto-generated method stub
		//Taregetwebsite target= new Taregetwebsite(driver);
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;		
		//  Thread.sleep(2000);
		// driver.findElement(By.id("gdpr_allow")).click();
		List<WebElement> links = driver.findElements(By.tagName("a"));

		Iterator<WebElement> it = links.iterator();

		while(it.hasNext()){

			url = it.next().getAttribute("href");

			//  System.out.println(url);

			if(url == null || url.isEmpty()){
				//System.out.println("URL is either not configured for anchor tag or it is empty"+url);
				continue;
			}


			try {
				huc = (HttpURLConnection)(new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();

				if(respCode>=400){
					System.out.println(url+" is a broken link& Response code is"+respCode);
				}
				else{
					//  System.out.println(url+" is a valid link");
				}

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	

	}
	@AfterTest
	public void Teardown()
	{
		
		driver.quit();
	
	}
}


