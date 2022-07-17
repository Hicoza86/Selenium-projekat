package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    By yourShoppCartBy = By.xpath("//*[@id='columns']/div[1]/span[2]");
    By totalProductsBy = By.xpath("//*[@id='total_product']");
    By totalShippingBy = By.xpath("//*[@id='total_shipping']");
    By totalBy = By.xpath("//*[@id='total_price_without_tax']");
    By taxBy = By.xpath("//*[@id='total_tax']");
    By totalPlusTaxBy = By.xpath("//*[@id='total_price']");

    public CheckOutPage verifyYouAreOnCheckOutPage (String expectedText) {
        String yourShoppCartTitle = readText(yourShoppCartBy);
        assertStringEquals(yourShoppCartTitle, expectedText);
        return this;
    }

    public CheckOutPage matchingFirstTotalPrice() {
        String firstTotalPrice = readText(totalBy);// prvi total 
        double expected = convertStringtoDouble(firstTotalPrice);

        String totalProductsString = readText(totalProductsBy);
        double totalProducts = convertStringtoDouble(totalProductsString);// procitaj totalproducts i konvertuj u double

        String totalShippingString = readText(totalShippingBy);
        double totalShipping = convertStringtoDouble(totalShippingString);// procitaj shipping i konvertuj u double

        double actual = totalProducts + totalShipping;
        doubleCompare(expected, actual, 0.1);// ocitan prvi total poredi sa zbirom products and shipping
        return this;
    }

    public CheckOutPage matchingSecondTotal() {
        String totalTax = readText(totalPlusTaxBy);
        double expected = convertStringtoDouble(totalTax);// ocitaj total tax i konvertuj u double

        String firstTotalString = readText(totalBy);
        double firstTotal = convertStringtoDouble(firstTotalString);

        String taxString = readText(taxBy);
        double tax = convertStringtoDouble(taxString);

        double actual = firstTotal + tax;// zbir ova dva ocitana, poredi sa totalTax
        doubleCompare(expected, actual, 0.1);
        return this;
    }

    // public CheckOutPage matchingTotalProductsPrice(double expected) {
    //     String totalProductsPrice = readText(totalProductsBy);
    //     double actual = convertStringtoDouble(totalProductsPrice);
    //     doubleCompare(expected, actual, 0.1);
    //     return this;
    // }

    // public CheckOutPage matchingTotalShippingPrice(double expected) {
    //     String totalShippingPrice = readText(totalShippingBy);
    //     double actual = convertStringtoDouble(totalShippingPrice);
    //     doubleCompare(expected, actual, 0.1);
    //     return this;
    // }
    
    // public CheckOutPage matchingTax(double expected) {
    //     String tax = readText(taxBy);
    //     double actual = convertStringtoDouble(tax);
    //     doubleCompare(expected, actual, 0.1);
    //     return this;
    // }
    
}