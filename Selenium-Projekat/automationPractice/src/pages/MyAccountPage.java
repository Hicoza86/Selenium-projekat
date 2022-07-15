package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver){
        super(driver);
    }
    By signOutButtonBy = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[2]/a");

    public MyAccountPage verifyYouAreLoggedIn (String expectedText) {
        String signOutButton = readText(signOutButtonBy);
        assertStringEquals(signOutButton, expectedText);
        return this;
    }

    public MyAccountPage clickOnSignOutButton() {
        click(signOutButtonBy);
        return this;
    }

    By tShirtButtonBy = By.xpath("//*[@id='block_top_menu']/ul/li[3]/a");

     public MyAccountPage clickOnTshirtButton() {
        click(tShirtButtonBy);
        return this;
    }
    
}
