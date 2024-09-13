package task17;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws Exception {
		
		//Setting up the chrome driver
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//Launching Snapdeal website
		driver.get("http://www.snapdeal.com");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		
		//Clicking on signIn button
		WebElement  signIn = driver.findElement(By.xpath("//span[@class='accountUserName col-xs-12 reset-padding']"));
		signIn.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		
		//Registering as a new user
		WebElement register = driver.findElement(By.className("newUserRegister")); 
		register.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		
		//Switching to iframe
		WebElement iFrameElement=driver.findElement(By.xpath("//iframe[@id='loginIframe']"));
		driver.switchTo().frame(iFrameElement);

		//Filling the details of SignUp form 
		WebElement userName =  driver.findElement(By.xpath("//input[@id='userName']"));
		userName.sendKeys("testNandhitha0066@gmail.com");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
		WebElement continueBtn = driver.findElement(By.xpath("//button[@id='checkUser']"));
		continueBtn.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

		WebElement contact = driver.findElement(By.xpath("//input[@id='j_number']"));
		contact.sendKeys("9600955380");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

		WebElement form =	driver.findElement(By.xpath("//input[@id='j_name']"));
		form.sendKeys("Nandhitha"); 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		
		WebElement dob = driver.findElement(By.xpath("//input[@id='j_dob']"));
		dob.click();  
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		dob.sendKeys("06/06/1996"); 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));

		WebElement pass =driver.findElement(By.xpath("//input[@id='j_password']"));
		pass.sendKeys("abcdxyz@12345");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

		//Clicking on continue button
		WebElement signup = driver.findElement(By.xpath("//button[@id='userSignup']"));
		signup.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

		//Verifying if the user has signed in successfully
		WebElement ver = driver.findElement(By.xpath("//div/span[contains(text(),'Nandhitha')]"));
		if (ver.getText().equals("Nandhitha"))
		{
			System.out.println(ver.getText() +" signedIn successfully");
		}
		else
		{
			System.out.println(ver.getText() +" couldn't be logged in");
		}

	}

}

/* Output :
 
 Nandhitha signedIn successfully
 
 */
