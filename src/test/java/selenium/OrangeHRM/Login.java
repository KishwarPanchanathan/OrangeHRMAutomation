package selenium.OrangeHRM;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	
	static void selectMonthAndYear(WebDriver driver, String month, String year) {
		while(true) {
			
			String currentMonth = driver.findElement(By.xpath("//ul/li/div[contains(@class,'selector-month')]/p")).getText();
			String currentYear = driver.findElement(By.xpath("//ul/li/div[contains(@class,'selector-year')]/p")).getText();
			
			if(currentMonth.equals(month) && currentYear.equals(year)) {
				break;
			}
			
			WebElement nextButton = driver.findElement(By.xpath("//button/i[@class='oxd-icon bi-chevron-right']"));
			WebElement previousButton = driver.findElement(By.xpath("//div[@class='oxd-calendar-header']//button/i[@class='oxd-icon bi-chevron-left']"));
//			nextButton.click();
			previousButton.click();
			
		}
	}
	
	static void selectDate(WebDriver driver, String date) {
		
		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='oxd-calendar-dates-grid']/div[contains(@class,'date-wrapper')]/div"));
		
		for(WebElement day: dates) {
		
			if(day.getText().equals(date)) {
				System.out.println(day.getText() + " : " + date);
				day.click();
				
			}
				
		}
	}
	
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
		
		
		
		// From Date
		/*
		
		fromDate.clear(); // clear is not working
		System.out.println("From Date is displayed: " + fromDate.isDisplayed());
		fromDate.sendKeys("2024-03-19");
		*/
		
		
		// selecting date using date picker
		String year = "2024";
		String month = "December";
		String day = "19";
		
		WebElement fromDate = driver.findElement(By.xpath("//label[text()='From Date']//ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//div[@class='oxd-date-input']/input[@class='oxd-input oxd-input--active']"));
		
		fromDate.click();
		
		
		selectMonthAndYear(driver, month, year);
		selectDate(driver, day);
		
		
		
		
		// closing the driver
		driver.quit();
		
		
	}

}
