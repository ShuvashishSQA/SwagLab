package com.swaglab.pom.page;

import com.swaglab.pom.baseSwagTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends baseSwagTest {

    @FindBy(xpath = "//a[contains(text(), \"CHECKOUT\")]")
    WebElement btnCheckout;

    @FindBy (xpath = "//div[text()=\"Your Cart\"]")
    WebElement elCartPageTitle;
    public CartPage(){
        try {
            PageFactory.initElements(driver, this);

        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    public CartPage checkCartPageTitle(){
        elCartPageTitle.isDisplayed();
        return this;
    }

    public CheckoutPage clickCheckout(){
        btnCheckout.isDisplayed();
        btnCheckout.click();
        return new CheckoutPage();
    }
}
