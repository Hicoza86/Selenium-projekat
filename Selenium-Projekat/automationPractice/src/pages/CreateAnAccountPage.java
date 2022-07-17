package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccountPage extends BasePage {
    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }

    By yourPersonalInfoTitleBy = By.xpath("//*[@id='account-creation_form']/div[1]/h3");
    By firstNameBy = By.xpath("//*[@id='customer_firstname']");
    By lastNameBy = By.xpath("//*[@id='customer_lastname']");
    By passwordBy = By.xpath("//*[@id='passwd']");
    By addressBy = By.xpath("//*[@id='address1']");
    By cityBy = By.xpath("//*[@id='city']");
    By countryBy = By.xpath("//*[@id='id_country']");
    By zipBy = By.xpath("//*[@id='postcode']");
    By stateBy = By.xpath("//*[@id='id_state']");
    By mobileBy = By.xpath("//*[@id='phone_mobile']");
    By registerButtonBy = By.xpath("//*[@id='submitAccount']");

    public CreateAnAccountPage verifyCreateAnAccountPageOpen (String expectedText) {
        String yourPersonalInfo = readText(yourPersonalInfoTitleBy);
        assertStringEquals(yourPersonalInfo, expectedText);
        return this;
    }

    public CreateAnAccountPage inputFirstName (String firstName) {
        writeText(firstNameBy, firstName);
        return this;
    }
    
    public CreateAnAccountPage inputLastName (String lastName) {
        writeText(lastNameBy, lastName);
        return this;
    }
    
    public CreateAnAccountPage inputPassword (String password) {
        writeText(passwordBy, password);
        return this;
    }
    
    public CreateAnAccountPage inputAddress (String address) {
        writeText(addressBy, address);
        return this;
    }
    
    public CreateAnAccountPage inputCity (String city) {
        writeText(cityBy, city);
        return this;
    }
    
    public CreateAnAccountPage selectCountry() {
        Select droppCountry = new Select(driver.findElement(countryBy));
        droppCountry.selectByVisibleText("United States");
        return this;
    }
    
    public CreateAnAccountPage inputZip (String zip) {
        writeText(zipBy, zip);
        return this;
    }

    public CreateAnAccountPage selectState() {
        Select droppState = new Select(driver.findElement(stateBy));
        droppState.selectByVisibleText("Kansas");
        return this;
    }
    
    public CreateAnAccountPage inputMobile (String mobPhone) {
        writeText(mobileBy, mobPhone);
        return this;
    }
    
    public CreateAnAccountPage registerButtonClick(){
        click(registerButtonBy);
        return this;
    }
}
