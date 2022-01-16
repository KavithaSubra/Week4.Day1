package Week4.Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindows {
	
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("home")).click();
		String title = driver.getTitle();
		System.out.println(title);
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String window: windowHandles)
		{
			System.out.println(window);
		}
		
		List<String> windows = new ArrayList<String>(windowHandles);
		String childWindow = windows.get(1);
		System.out.println(childWindow);
		//Switch to ChildWindow
		String title2 = driver.switchTo().window(childWindow).getTitle();
		System.out.println(title2);
		
		driver.close();
		
		
		
		//driver.switchTo().window(windows.get(0));
		
		driver.switchTo().window(windowHandle);
		
		String text2 = driver.findElement(By.tagName("h1")).getText();
		System.out.println(text2);
		
		//driver.quit();
}

}
