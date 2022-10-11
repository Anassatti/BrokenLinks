package Resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
public class base {

	public  WebDriver driver;
	public Properties pro;
public WebDriver initializeDriver() throws IOException
{
	pro= new Properties();

FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");

pro.load(fis);

//mvn test -Dbrowser= chrome
//Control browser from Maven command
//String browserName= System.getProperty("browser");
//Control browser from data.properties file command
String browserName=pro.getProperty("browser");


if(browserName.contains("chrome"))
{
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\anass\\Desktop\\Files\\Seleium\\Driver\\LastVersion\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	if(browserName.contains("headless"))
	{
		 options.addArguments("headless");
	     
	}

	driver = new ChromeDriver(options);
    
	
		
}
else if (browserName.equals("firefox"))
{
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Anas\\Desktop\\Seleium\\Driver\\LastVersion\\geckodriver.exe");
	 driver= new FirefoxDriver();
	//firefox code
}
else if (browserName.equals("IE"))
{
//	IE code
}

//driver.manage().timeouts().implicitlyWait(10, 10);

return driver;

}

public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
{
	TakesScreenshot tk=(TakesScreenshot) driver;
	File source=tk.getScreenshotAs(OutputType.FILE);
	String destentionFile= System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source, new File(destentionFile));
	return destentionFile;
}

}