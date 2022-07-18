package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TshirtPage extends BasePage {
    public TshirtPage(WebDriver driver) {
        super(driver);
    }

    By tShirtsBy = By.xpath("//*[@id='center_column']/h1/span[1]");
    By pictureBy = By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]");
    By addToCartBy = By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]");
    By cartTitleBy = By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2");
    By proceedToCheckOut = By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a");

    public TshirtPage verifyTshirt (String expectedText) {
        String pageTitle = readText(tShirtsBy);
        assertStringEquals(pageTitle, expectedText);
        return this;
    }
    
    public TshirtPage hoverAndClick() {
        WebElement element = driver.findElement(pictureBy);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        click(addToCartBy);
        return this;
    }

    public TshirtPage validateTshirtInCart (String expectedText) {
        String pageTitle = readText(cartTitleBy);
        assertStringEquals(pageTitle, expectedText);
        return this;
    }

    public TshirtPage clickOnProceedToCheckOut() {
        click(proceedToCheckOut);
        return this;
    }
}