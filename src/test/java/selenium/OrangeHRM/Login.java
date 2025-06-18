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
//			String username = scan.next();
			String username = "Admin";
			userNameField.sendKeys(username);
		}
		
		// password field
		WebElement passwordField = driver.findElement(By.xpath("//div/input[@name='password']"));
		System.out.println("Is Password Field Present: " + passwordField.isDisplayed());
		if(passwordField.isDisplayed()) {
			System.out.print("Enter your password: ");
//			String password = scan.next();
			String password = "admin123";
			passwordField.sendKeys(password);
		}
		
		// Login Button
		WebElement loginButton = driver.findElement(By.xpath("//div[contains(@class,'login-action')]/button"));
		System.out.println("Is Login Button Present: " + loginButton.isDisplayed());
		if(loginButton.isDisplayed()) {
			loginButton.click();
		}
		
		
		// validating home page
		WebElement dashboardPage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6"));
		System.out.println("Dashboard page is displayed: " + dashboardPage.isDisplayed());
		
		
		// Leave option
		WebElement leaveOption = driver.findElement(By.xpath("//a/span[text()='Leave']"));
		System.out.println("Leave options is displayed: " + leaveOption.isDisplayed());
		leaveOption.click();
		System.out.println("Leave Option is clicked..");
		Thread.sleep(3000);
		WebElement leaveHeader = driver.findElement(By.xpath("//h6[text()='Leave']"));
		

		System.out.println("Leave header is displayed: " + leaveHeader.isDisplayed());
		
		/* leave list will show if the screen is normal but when you
		 * resize the page the list will hide so we need to write a condition 
		 */
		
		// Leave List
		WebElement leaveListHeading = driver.findElement(By.xpath("//h5[text()='Leave List']"));
		System.out.println("Leave List Heading is displayed: " + leaveListHeading.isDisplayed());

		WebElement upCaret = driver.findElement(By.xpath("//button/i[contains(@class,'oxd-icon bi-caret-up-fill')]"));
		upCaret.click();
		System.out.println("Up Caret is clicked...");
		WebElement downCaret = driver.findElement(By.xpath("//button/i[contains(@class,'oxd-icon bi-caret-down-fill')]"));
		downCaret.click();
		
		System.out.println("is down caret displayed: " + downCaret.isDisplayed());
		
		
		
		Thread.sleep(3000);
		
		if(!downCaret.isDisplayed()) {
			upCaret.click();
		}
		
		
		// closing the driver
		driver.quit();
		
		
	}

}
