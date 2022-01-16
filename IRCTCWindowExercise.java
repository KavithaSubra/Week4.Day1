package Week4.Day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IRCTCWindowExercise {
public static void main(String[] args) throws IOException {
	WebDriverManager.chromedriver().setup();
	
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	options.addArguments("--start-maximized");
	
	ChromeDriver driver = new ChromeDriver(options);
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	driver.get("https://www.irctc.co.in/nget/train-search");
	//driver.manage().window().maximize();
	File source = driver.getScreenshotAs(OutputType.FILE);
	File dest = new File("./images/HomeScreen.png");
	FileUtils.copyFile(source, dest);
	
	WebElement okButton = driver.findElement(By.xpath("//button[text() = 'OK']"));
	File source1 = driver.getScreenshotAs(OutputType.FILE);
	File dest1 = new File("./images/okButton.png");
	FileUtils.copyFile(source1, dest1);
	
	driver.findElement(By.xpath("//button[text() = 'OK']")).click();
	//driver.findElement(By.className("fa fa-align-justify")).click();
	/*WebElement findFlight = driver.findElement(By.xpath("//label[text()='FLIGHTS']"));
	js.executeScript("arguments[0].scrollintoView();", findFlight);*/
	
	/*driver.findElement(By.linkText("FLIGHTS")).click();
	
	Set<String> windowHandles = driver.getWindowHandles();
	
	List<String> windows = new ArrayList<String>(windowHandles);
	
	String string = windows.get(1);
	driver.switchTo().window(string);
	
	System.out.println("Current Window Title is " + driver.getTitle());
	
	driver.switchTo().window(windows.get(0));
	driver.close();*/
	
	
	
}
}
