package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccountPage extends BasePage {
    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }
    By yourPersonalInfoTitleBy = By.xpath("//*[@id='account-creation_form']/div[1]/h3");

    public CreateAnAccountPage verifyCreateAnAccountPageOpen (String expectedText) {
        String yourPersonalInfo = readText(yourPersonalInfoTitleBy);
        assertStringEquals(yourPersonalInfo, expectedText);
        return this;
    }

    By fNameBy = By.xpath("//*[@id='customer_firstname']");

    public CreateAnAccountPage inputFirstName (String fName) {
        writeText(fNameBy, fName);
        return this;
    }
    By lNameBy = By.xpath("//*[@id='customer_lastname']");

    public CreateAnAccountPage inputLastName (String lName) {
        writeText(lNameBy, lName);
        return this;
    }
    By passwordBy = By.xpath("//*[@id='passwd']");

    public CreateAnAccountPage inputPassword (String password) {
        writeText(passwordBy, password);
        return this;
    }
    By addressBy = By.xpath("//*[@id='address1']");

    public CreateAnAccountPage inputAddress (String address) {
        writeText(addressBy, address);
        return this;
    }
    By cityBy = By.xpath("//*[@id='city']");

    public CreateAnAccountPage inputCity (String city) {
        writeText(cityBy, city);
        return this;
    }
    By countryBy = By.xpath("//*[@id='id_country']");

    public CreateAnAccountPage selectCountry() {
        Select drpState = new Select(driver.findElement(countryBy));
        drpState.selectByVisibleText("United States");
        return this;
    }
    By zipBy = By.xpath("//*[@id='postcode']");

    public CreateAnAccountPage inputZip (String zip) {
        writeText(zipBy, zip);
        return this;
    }
    By stateBy = By.xpath("//*[@id='id_state']");

    public CreateAnAccountPage selectState() {
        Select drpState = new Select(driver.findElement(stateBy));
        drpState.selectByVisibleText("Kansas");
        return this;
    }
    By mobileBy = By.xpath("//*[@id='phone_mobile']");

    public CreateAnAccountPage inputMobile (String mobPhone) {
        writeText(mobileBy, mobPhone);
        return this;
    }
    By registerButtonBy = By.xpath("//*[@id='submitAccount']");
    public CreateAnAccountPage registerButtonClick(){
        click(registerButtonBy);
        return this;
    }
}
