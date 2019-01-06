package MoneyControlStepDefination;



import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefination 
{
	WebDriver driver;


	@Given("^Open The Browser$")
	public void open_The_Browser() throws Throwable
	{
		System.setProperty("webdriver.chrome.driver","D:\\SelenumTesting\\MoneyControl\\src\\main\\resources\\ChromeextPath\\chromedriver.exe");
	    driver=new ChromeDriver();
	    
	    driver.get("https://www.moneycontrol.com/");
	    driver.manage().window().maximize();
	}

	@When("^Click on DropDown ICON$")
	public void click_on_DropDown_ICON() throws Throwable 
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//div[@class='chkMrkRdr']/a")).click();
	    
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("scroll(0,400)");
	}

	@Then("^Take the Screenshot$")
	public void take_the_Screenshot() throws Throwable
	{
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("D:\\SelenumTesting\\MoneyControl\\Screenshot\\money.png"));
	   
	}
	
	@Then("^List of Stocks in News$")
	public void list_of_Stocks_in_News() throws Throwable
	{
	    WebElement data=driver.findElement(By.xpath("//div[@id='lastStock']/div[1]"));
	    System.out.println(data.getText());
	}

}
