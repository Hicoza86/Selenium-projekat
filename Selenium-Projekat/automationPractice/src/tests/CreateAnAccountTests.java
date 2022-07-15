package tests;

import org.junit.Test;

import pages.HomePage;
import pages.MyAccountPage;
import pages.CreateAnAccountPage;
import pages.SignInPage;

public class CreateAnAccountTests extends BaseTest {

    public HomePage homePage;
    public SignInPage signInPage;
    public CreateAnAccountPage createAnAccountPage;
    public MyAccountPage myAccountPage;

    String authentTitle = "AUTHENTICATION";
    String yourPersonalInfoTitle = "YOUR PERSONAL INFORMATION";
    String signOutButton = "Sign out";
    String hicaEmail = "hicailic113@gmail.com";

    String firstName = "Nemanja";
    String lastName = "Ilic";
    String fiveChar = "PinkFloyd";
    String myAddress = "Rada Neimara 20";
    String postalCode = "11000";
    String city = "Beograd";
    String phone = "+381658197129";


    @Test
    public void successfullAccountCreation() {// validiras da si na signIn strani
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);// nisi prosledio drajver 
        createAnAccountPage = new CreateAnAccountPage(driver);
        myAccountPage = new MyAccountPage(driver);

        homePage.basePage();
        homePage.clickOnSignInButton();
        signInPage.verifySignInPageOpen(authentTitle);// verifikujes da si na sign strani
        signInPage.verifyAccountIsCreated(hicaEmail);
        createAnAccountPage.verifyCreateAnAccountPageOpen(yourPersonalInfoTitle);//verif da si na createanacc strani
        createAnAccountPage.inputFirstName(firstName);
        createAnAccountPage.inputLastName(lastName);
        createAnAccountPage.inputPassword(fiveChar);
        createAnAccountPage.inputAddress(myAddress);
        createAnAccountPage.inputCity(city);
        createAnAccountPage.selectCountry();// moras prvo da selectujes US, da bi ti se otvorili State i ZipCode
        createAnAccountPage.inputZip(postalCode);
        createAnAccountPage.selectState();
        createAnAccountPage.inputMobile(phone);
        createAnAccountPage.registerButtonClick();
        myAccountPage.verifyYouAreLoggedIn(signOutButton);// validirao si da si na myAccount strani preko Sign out dugmeta

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
