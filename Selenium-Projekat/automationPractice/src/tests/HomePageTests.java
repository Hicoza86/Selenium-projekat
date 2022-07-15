package tests;

import org.junit.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignInPage;
import pages.TshirtPage;

public class HomePageTests extends BaseTest{
    public HomePage homePage;
    public TshirtPage tshirtPage;
    public CheckOutPage checkOutPage;
    public SignInPage signInPage;
    public MyAccountPage myAccountPage;

    @Test
    public void openBrowser () {
        homePage = new HomePage(driver);
        homePage.basePage();

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
    int numberOfPopularProducts = 7;

    @Test
    public void checkNumberOfPopularProducts () {
        homePage = new HomePage(driver);
        homePage.basePage();
        homePage.validateNumOfPopularPro(numberOfPopularProducts);
        
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
    int numberOfBestSellProducts = 7;

    @Test
    public void checkNumberOfBestSellers () {
        homePage = new HomePage(driver);
        homePage.basePage();
        homePage.bestSellersClick();
        homePage.validateNumOfBestSellers(numberOfBestSellProducts);
        
    }

    String tShirtTitle = "T-SHIRTS ";
    String cartTitle = "Product successfully added to your shopping cart";
    String yourShoppingCart = "Your shopping cart";
    // double totalProducts = 16.51;
    // double totalShipping = 2.00;
    // double total = totalProducts + totalShipping;
    // double tax = 0.00;
    // double totalTax = total + tax;

    @Test
    public void fromTshirtIntoCart () {
        homePage = new HomePage(driver);
        tshirtPage = new TshirtPage(driver);
        checkOutPage = new CheckOutPage(driver);

        homePage.basePage();
        homePage.clickOnTshirtButton();
        tshirtPage.verifyTshirt(tShirtTitle);
        tshirtPage.scrollMethod();
        tshirtPage.hoverAndClick();
        tshirtPage.validateTshirtInCart(cartTitle);// text sa zelenim stikliran
        tshirtPage.clickOnProceedToCheckOut();// klikni na dugme
        checkOutPage.verifyYouAreOnCheckOutPage(yourShoppingCart);// verifikuj da si na Chekout strani, title sop-cart summary

        // checkOutPage.matchingTotalProductsPrice(totalProducts);
        // checkOutPage.matchingTotalShippingPrice(totalShipping);
        // checkOutPage.matchingFirstTotalPrice(total);
        // checkOutPage.matchingTax(tax);
        // checkOutPage.matchingSecondTotal(totalTax);
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException exception) {
            exception.printStackTrace();// odstampaj gresku ako te neko prekine u izvrsavanju koda
        }
    }
    String validEmail = "hicailic1989@gmail.com";
    String validPass = "PinkFloyd";
    String signOutButton1 = "Sign out";

    @Test
        public void verifyTotPriceShowsAsExpected () {// pravis test da se uloguje ode na tshirt clikne i sve do kraja cene proveris
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        myAccountPage = new MyAccountPage(driver);
        tshirtPage = new TshirtPage(driver);
        checkOutPage = new CheckOutPage(driver);

        homePage.basePage();
        homePage.clickOnSignInButton();

        signInPage.login(validEmail,validPass);
        myAccountPage.verifyYouAreLoggedIn(signOutButton1);

        myAccountPage.clickOnTshirtButton();
        tshirtPage.verifyTshirt(tShirtTitle);//verif da si stigo na tshirt
        tshirtPage.scrollMethod();
        tshirtPage.hoverAndClick();
        tshirtPage.validateTshirtInCart(cartTitle);
        tshirtPage.clickOnProceedToCheckOut();
        checkOutPage.verifyYouAreOnCheckOutPage(yourShoppingCart);

       // checkOutPage.matchingTotalProductsPrice(totalProducts);
       // checkOutPage.matchingTotalShippingPrice(totalShipping);
        checkOutPage.matchingFirstTotalPrice();
        // checkOutPage.matchingTax(tax);
        checkOutPage.matchingSecondTotal();
        
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException exception) {
            exception.printStackTrace();// odstampaj gresku ako te neko prekine u izvrsavanju koda
        }
    }
}

