import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;


public class WebDriverwithFirefox {

		public static void main(String[] args) throws InterruptedException 
		{
			System.setProperty("webdriver.firefox.bin",
					"C:/Users/kosvenka/AppData/Local/Mozilla Firefox/firefox.exe");
	        FirefoxProfile profile = new FirefoxProfile();
	        profile.setPreference("network.proxy.type", 1);
	        profile.setPreference("network.proxy.http", "10.219.96.26");
	        profile.setPreference("network.proxy.http_port", 8080);
	        profile.setPreference("network.proxy.ssl", "10.219.96.26");
	        profile.setPreference("network.proxy.ssl_port", 8080);
	        
	        FirefoxDriver driver = new FirefoxDriver(profile);
	        driver.get("http://demo.opencart.com");
			Thread.sleep(1000);
			System.out.println("Webpage openend");
	        System.out.println("execution is paused for 1.5 seconds");
	        String title1 = "Your Store";
	        boolean source = driver.getPageSource().contains(title1);
	        
	        if(source)
	        {
	        	System.out.println("Title is verified");
	        }
	        else
	        {
	        	System.out.println(title1 + " is not present");
	        }
	        System.out.println("Waiting for the page to load");
	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
	        
			int link=links.size();
			if(link==73)
					{
						System.out.println("Links verified");
					}
			driver.findElement(By.className("caret")).click();
			Thread.sleep(1000);
			System.out.println("Clicked on Account");
			driver.findElement(By.cssSelector(".dropdown-menu.dropdown-menu-right>li>a")).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			System.out.println("Clicked on Register");
			driver.findElement(By.xpath(".//*[@id='input-firstname']")).sendKeys("Ganesh");
			WebElement we = driver.findElement(By.xpath(".//*[@id='input-firstname']"));
			String name = we.getAttribute("value");
			if(Validate.ValidateName(name))
			{
				System.out.println("First name verified");
				driver.findElement(By.name("lastname")).sendKeys("Kosuri");
				Thread.sleep(1000);
				WebElement last = driver.findElement(By.name("lastname"));
				String lname = last.getAttribute("value");
				if(Validate.ValidateName(lname))
				{
					System.out.println("Last name verified");			
					driver.findElement(By.cssSelector("#input-email")).sendKeys("ganesh@gmail.com");
					Thread.sleep(1000);
					WebElement mail = driver.findElement(By.cssSelector("#input-email"));
					String vmail = mail.getAttribute("value");
					if(Validate.Validatemail(vmail))
					{
						System.out.println("Email is verified");
						driver.findElement(By.id("input-telephone")).sendKeys("9398402005");
						Thread.sleep(1000);
						WebElement phone = driver.findElement(By.id("input-telephone"));
						String number = phone.getAttribute("value");
						if(Validate.ValidateNo(number))
						{
							System.out.println("Phone number verified");
							driver.findElement(By.className("form-control")).sendKeys("Kramadevi@457");
							Thread.sleep(1000);
							WebElement pwrd = driver.findElement(By.className("form-control"));
							String password = pwrd.getAttribute("value");
							driver.findElement(By.id("input-confirm")).sendKeys("Kramadevi@457");
							WebElement pwrd1 = driver.findElement(By.className("form-control"));
							String password1 = pwrd1.getAttribute("value");
							if(password.equals(password1))
							{
								System.out.println("Both the passwords are matching");
							}
						}
						
					}
					
				}
			}
		
			driver.quit();
		
}
}