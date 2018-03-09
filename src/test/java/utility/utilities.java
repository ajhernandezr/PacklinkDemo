package utility;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;




public class utilities {
  public static WebDriver driver;
	
	
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	 
    public static WebDriver getDriver() {
        return webDriver.get();
    }
 
    public static  void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

       
	public static void smallPause() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// Handle here
		}
	}

	public static void mediumPause() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// Handle here
		}
	}

	public static void longPause() {
		try {
			Thread.sleep(14000);
		} catch (InterruptedException e) {
			// Handle here
		}
	}
	



	public static  void waitForElement(WebElement element)  {
		driver = utilities.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
		
   		wait.until(ExpectedConditions.visibilityOf(element));
   	
   		
	}

	
	public static void waitUntilElementDisplayed(final WebElement webElement) {
		
		driver = utilities.getDriver();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		ExpectedCondition<Boolean> elementIsDisplayed = new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver arg0) {
		  try {
		     webElement.isDisplayed();
		     return true;
		  }
		  catch (NoSuchElementException e ) {
		    return false;
		  }
		  catch (StaleElementReferenceException f) {
		    return false;
		  }
		    }
		};
		wait.until(elementIsDisplayed);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

	public static  void moveToElement(WebElement element) {

		Actions builder = new Actions(driver);
		builder.moveToElement(element).build().perform();
	}

	
	public static  WebDriver selectBrowser()  {
		// Create a new instance of the Chrome driver
		
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			

			// Disable extensions and hide infobars
			options.addArguments("--disable-extensions");
			options.addArguments("disable-infobars");

			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(Constant.registerURL);
	driver.manage().window().maximize();

	return driver;
		
		}


	// Method for interact with dificult web elements
	public static void pushDificultElements(WebDriver driver, final WebElement element2) throws Exception {
		Wait<WebDriver> fluent = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		Function<WebDriver, WebElement> push = new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver arg0) {
				WebElement element = element2;
				if (element != null) {

					element.click();
				}
				return element;
			}
		};
		fluent.until(push);
	}


}
