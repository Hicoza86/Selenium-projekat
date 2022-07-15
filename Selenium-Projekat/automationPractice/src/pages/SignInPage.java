package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage{
    public SignInPage(WebDriver driver) {// konstruktor
        super(driver); 
    } 

    By authentTitleBy = By.xpath("//*[@class='page-heading']");

    public SignInPage verifySignInPageOpen (String expectedText) {
        String signInAuthent = readText(authentTitleBy);
        assertStringEquals(signInAuthent, expectedText);
        return this;
    }

    By emailBy = By.id("email_create");
    By createAnAccountButtonBy = By.id("SubmitCreate");

    public SignInPage verifyAccountIsCreated (String email){
        writeText (emailBy, email);// lokator i text
        click(createAnAccountButtonBy);
        return this;
    }

    By validEmailBy = By.xpath("//*[@id='email']");
    By validPassBy = By.xpath("//*[@id='passwd']");
    By signInButtonBy = By.xpath("//*[@id='SubmitLogin']");

    public SignInPage login (String email, String pass){
        writeText(validEmailBy, email);
        writeText(validPassBy, pass);
        click(signInButtonBy);
        return this;
    }
    By signInButtBy = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");

    public SignInPage verifyYouAreLoggedOut (String expectedText) {
        String signInButton = readText(signInButtBy);
        assertStringEquals(signInButton, expectedText);
        return this;
    }

}
