package tests;

import org.junit.Test;

import pages.HomePage;
import pages.MyAccountPage;
import pages.SignInPage;

public class AlreadyRegisteredTests extends BaseTest {
    
    public HomePage homePage;
    public SignInPage signInPage;
    public MyAccountPage myAccountPage;

    String validEmail = "hicailic1989@gmail.com";
    String validPass = "PinkFloyd";

    String invalidEmail = "hicailic1989gmail.com";
    String invalidEmailMessage = "Invalid email address.";

    String invalidPassword = "pinkfloyd";
    String invalidPasswordMessage = "Authentication failed.";

    String emptyEmail = "";
    String emptyEmailErrorMessage = "An email address required.";

    String emptyPassword = "";
    String emptyPasswordErrorMessage = "Password is required.";

    String signOutButton = "Sign out";
    String signInButton = "Sign in"; 
    
    @Test// 5.login funkcionlanosti
    public void successfullLogIn() {
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        myAccountPage = new MyAccountPage(driver);

        homePage.basePage();
        homePage.clickOnSignInButton();
        signInPage.login(validEmail,validPass);
        myAccountPage.verifyYouAreLoggedIn(signOutButton);
    }

    @ Test
    public void invalidEmailTest() {
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);

        homePage.basePage();
        homePage.clickOnSignInButton();
        signInPage.login(invalidEmail, validPass);
        signInPage.verifyUnsuccessfullLogin(invalidEmailMessage);
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    @ Test
    public void invalidPasswordTest() {
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);

        homePage.basePage();
        homePage.clickOnSignInButton();
        signInPage.login(validEmail, invalidPassword);
        signInPage.verifyUnsuccessfullLogin(invalidPasswordMessage);
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    @ Test
    public void emptyEmailTest() {
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);

        homePage.basePage();
        homePage.clickOnSignInButton();
        signInPage.login(emptyEmail, validPass);
        signInPage.verifyUnsuccessfullLogin(emptyEmailErrorMessage);
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    @ Test
    public void emptyPasswordTest() {
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);

        homePage.basePage();
        homePage.clickOnSignInButton();
        signInPage.login(validEmail, emptyPassword);
        signInPage.verifyUnsuccessfullLogin(emptyPasswordErrorMessage);
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    @Test // 5.Logout funkcionalnost
    public void successfullLogOut(){
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        myAccountPage = new MyAccountPage(driver);

        homePage.basePage();
        homePage.clickOnSignInButton();
        signInPage.login(validEmail,validPass);
        myAccountPage.verifyYouAreLoggedIn(signOutButton);
        myAccountPage.clickOnSignOutButton();
        signInPage.verifyYouAreLoggedOut(signInButton);

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        // klik on sign in button i validiras signout dugme
    }
}
