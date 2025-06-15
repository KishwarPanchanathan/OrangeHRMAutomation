package selenium.OrangeHRM;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Scanner scan = new Scanner(System.in);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(5000);
		
		// checking Login Page.
		
		//Page title
		WebElement pageTitle = driver.findElement(By.xpath("/html/head/title"));
		System.out.println("Is page title exists: " + pageTitle);
		if(pageTitle.equals("OrangeHRM")) {
			System.out.println("Title is matching.");
		}
		
		
		// Logo
		WebElement Logo = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']/img"));
		System.out.println("Is Logo Present :" + Logo.isDisplayed());
		
		// username field
		WebElement userNameField = driver.findElement(By.xpath("//div/input[@name='username']"));
		System.out.println("Is Username Field Present: " + userNameField.isDisplayed());
		if(userNameField.isDisplayed()) {
			System.out.print("Enter your username: ");
			String username = scan.next();
			userNameField.sendKeys(username);
		}
		
		// password field
		WebElement passwordField = driver.findElement(By.xpath("//div/input[@name='password']"));
		System.out.println("Is Password Field Present: " + passwordField.isDisplayed());
		if(passwordField.isDisplayed()) {
			System.out.print("Enter your password: ");
			String password = scan.next();
			passwordField.sendKeys(password);
		}
		
		// Login Button
		WebElement loginButton = driver.findElement(By.xpath("//div[contains(@class,'login-action')]/button"));
		System.out.println("Is Login Button Present: " + loginButton.isDisplayed());
		if(loginButton.isDisplayed()) {
			loginButton.click();
		}
		
		Thread.sleep(5000);
		
		
		
		driver.quit();
		
		
	}

}
