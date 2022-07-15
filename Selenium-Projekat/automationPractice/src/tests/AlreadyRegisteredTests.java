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
    String signOutButton = "Sign out";
    String signInButton = "Sign in"; 
    
    @Test
    public void successfullLogIn() {
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        myAccountPage = new MyAccountPage(driver);

        homePage.basePage();
        homePage.clickOnSignInButton();
        signInPage.login(validEmail,validPass);
        myAccountPage.verifyYouAreLoggedIn(signOutButton);// stavio si signOut1 jer nece isti naziv dugmeta da radi kad validiras da je acount napravljen
    }
    @Test 
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
