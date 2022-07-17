package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage{
    public SignInPage(WebDriver driver) {// konstruktor
        super(driver); 
    } 

    By authentTitleBy = By.xpath("//*[@class='page-heading']");
    By emailBy = By.id("email_create");
    By createAnAccountButtonBy = By.id("SubmitCreate");
    By validEmailBy = By.xpath("//*[@id='email']");
    By validPassBy = By.xpath("//*[@id='passwd']");
    By signInButtonBy = By.xpath("//*[@id='SubmitLogin']");
    By errorMessageBy = By.xpath("//*[@id='center_column']/div[1]/ol/li");
    By signInButtBy = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");

    public SignInPage verifySignInPageOpen (String expectedText) {
        String signInAuthent = readText(authentTitleBy);
        assertStringEquals(signInAuthent, expectedText);
        return this;
    }

    public SignInPage verifyAccountIsCreated (String email){
        writeText (emailBy, email);// lokator i text
        click(createAnAccountButtonBy);
        return this;
    }

    public SignInPage login (String email, String pass){
        writeText(validEmailBy, email);
        writeText(validPassBy, pass);
        click(signInButtonBy);
        return this;
    }

    public SignInPage verifyUnsuccessfullLogin (String expectedText){
        String error = readText(errorMessageBy);
        assertStringEquals(error, expectedText);
        return this;
    }
    
    public SignInPage verifyYouAreLoggedOut (String expectedText) {
        String signInButton = readText(signInButtBy);
        assertStringEquals(signInButton, expectedText);
        return this;
    }

}
