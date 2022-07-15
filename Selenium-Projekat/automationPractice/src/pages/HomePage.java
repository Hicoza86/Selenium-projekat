package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    String baseURL = "http://automationpractice.com";

    public HomePage basePage() {
        driver.get(baseURL);
        return this;
    }

    By numberOfPopularProductsBy = By.cssSelector("ul#homefeatured>li");
    
    public HomePage validateNumOfPopularPro(int expectedNumberOfProducts){// ti prosledjujes u homePageTestu 6 expectedNumber of products!!!
        int actualNumberOfProducts = locateElements(numberOfPopularProductsBy).size();//vrati intiger ove locirane
        assertIntegerEquals(expectedNumberOfProducts, actualNumberOfProducts);//
        return this;
    }

    By listOfBestSellers = By.cssSelector("ul#blockbestsellers>li");

    public HomePage validateNumOfBestSellers(int expectedNumberOfProducts){
        int actualNumberOfProducts = locateElements(listOfBestSellers).size();
        assertIntegerEquals(expectedNumberOfProducts, actualNumberOfProducts);
        return this;
    }

    By bestSellersButton = By.xpath("//*[@id='home-page-tabs']/li[2]/a");

    public HomePage bestSellersClick(){
        click(bestSellersButton);
        return this;
    }

    By signInButtonBy = By.xpath("//*[@class='header_user_info']");

    public HomePage clickOnSignInButton() {
        click(signInButtonBy);
        return this;
    }

    By tShirtButtonBy = By.xpath("//*[@id='block_top_menu']/ul/li[3]/a");

     public HomePage clickOnTshirtButton() {
        click(tShirtButtonBy);
        return this;
    }
}
