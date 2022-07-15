package pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {// konstruktor
    public WebDriver driver;// prevodilac, browser
    public WebDriverWait wait;// ovde samo deklarises promenljivu, cekaj dok nesto

    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));// u nju mi spakuj 
    }
    public void waitVisibility (By elementBy){// dokle da ceka
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }
    public void click(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
        driver.findElement(elementBy).click();
    }
    public void writeText (By elementBy, String text) {// elemenyBy nad elementom koji smo locirali
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }
    public String readText(By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }
    public void assertStringEquals (String string, String expectedText) {
        Assert.assertEquals(string, expectedText);
    }
    public void assertIntegerEquals ( int expectedNumber, int actualNumber){
        Assert.assertEquals(expectedNumber, actualNumber);
    }
    public List<WebElement> locateElements(By elementBy){
        waitVisibility(elementBy);
        return driver.findElements(elementBy);
    }
    public void assertElementVisible(By elementBy){// lokator
        boolean isVisible = driver.findElement(elementBy).isDisplayed();
        Assert.assertTrue(isVisible);
    }
    public String readHref(By elementBy){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getAttribute("href");
    }
    public double convertStringtoDouble(String string){
        return Double.parseDouble(string.substring(1));// pretvori sve posle prvog karaktera
    }
    public void doubleCompare (double expected, double actual, double delta){// double delta ti je max odstupanje ova dva
        Assert.assertEquals(expected, actual, delta);
    }  
    public void scrollMethod(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600)");
    }
}
