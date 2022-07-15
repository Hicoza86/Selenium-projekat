package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    By yourShoppCartBy = By.xpath("//*[@id='columns']/div[1]/span[2]");

    public CheckOutPage verifyYouAreOnCheckOutPage (String expectedText) {
        String yourShoppCartTitle = readText(yourShoppCartBy);
        assertStringEquals(yourShoppCartTitle, expectedText);
        return this;
    }

    By totalProductsBy = By.xpath("//*[@id='total_product']");// dobar lokator

    // public CheckOutPage matchingTotalProductsPrice(double expected) {
    //     String totalProductsPrice = readText(totalProductsBy);
    //     double actual = convertStringtoDouble(totalProductsPrice);
    //     doubleCompare(expected, actual, 0.1);
    //     return this;
    // }
    By totalShippingBy = By.xpath("//*[@id='total_shipping']");// dobar lokator

    // public CheckOutPage matchingTotalShippingPrice(double expected) {
    //     String totalShippingPrice = readText(totalShippingBy);
    //     double actual = convertStringtoDouble(totalShippingPrice);
    //     doubleCompare(expected, actual, 0.1);
    //     return this;
    // }
    By totalBy = By.xpath("//*[@id='total_price_without_tax']");// dobar lokator

    public CheckOutPage matchingFirstTotalPrice() {
        String firstTotalPrice = readText(totalBy);
        double expected = convertStringtoDouble(firstTotalPrice);// ono sto procita
        double actual = convertStringtoDouble(readText(totalProductsBy)) + convertStringtoDouble(readText(totalShippingBy));
        doubleCompare(expected, actual, 0.1);
        return this;
    }
    By taxBy = By.xpath("//*[@id='total_tax']");// dobar lokator

    // public CheckOutPage matchingTax(double expected) {
    //     String tax = readText(taxBy);
    //     double actual = convertStringtoDouble(tax);
    //     doubleCompare(expected, actual, 0.1);
    //     return this;
    // }
    By totalPlusTaxBy = By.xpath("//*[@id='total_price']");// dobar lokator

    public CheckOutPage matchingSecondTotal() {
        String totalTax = readText(totalPlusTaxBy);
        double expected = convertStringtoDouble(totalTax);
        double actual = convertStringtoDouble(readText(totalBy)) + convertStringtoDouble(readText(taxBy));
        doubleCompare(expected, actual, 0.1);
        return this;
    }
}