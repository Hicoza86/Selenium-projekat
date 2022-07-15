package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    public WebDriver driver;
    
    @Before 
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hica\\Desktop\\Selenium-Projekat\\automationPractice\\lib\\geckodriver.exe");
        driver = new FirefoxDriver();// ovde gore mu zadas putanju,
        // kazes od cega mu zadajes putanju(FIREFOX) i u produzetku putanju

        driver.manage().window().maximize();// maksimizira firefox
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
