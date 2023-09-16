package org.base;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    public static WebDriver driver;

    // browser init
    public WebDriver init_driver(String browser) {

	if (browser.equals("chrome")) {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();

	} else if (browser.equals("firefox")) {
	    WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
	} else if (browser.equals("edge")) {
	    WebDriverManager.edgedriver().setup();
	    driver = new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	return driver;
    }

    // Url launch
    // driver.get(String url)
    public void lauch_Url(String url) {
	driver.get(url);
    }

    // Enter Text value --> sendKeys()
    // How will we call --> By using WebElemet ref --> In SendKey we use String type
    public void enterTextValue(WebElement ele, String data) {

	ele.sendKeys(data);

    }

    // Btn Click ---> click()
    // Webele ref click()

    public void btnClick(WebElement ele) {
	ele.click();

    }

    // mouseAction-->moveToElement()

    public void mouseHoverAction(WebElement ele) {
	Actions ac = new Actions(driver);
	ac.moveToElement(ele).perform();

    }

    public void dragAndDrop(WebElement drag, WebElement drop) {
	Actions ac = new Actions(driver);
	ac.dragAndDrop(drag, drop).perform();
    }

    // Enter value using javascript --> js
    public void enterTextByJs(WebElement element, String data) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
    }

    // click by using js
    public void btnClickByJs(WebElement ele) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()", ele);
    }

    // getAttribute
    public String getAttribute(WebElement ele) {
	String attribute = ele.getAttribute("value");

	return attribute;
    }

    // getText
    public String getText(WebElement element) {
	String text = element.getText();

	return text;
    }
}
