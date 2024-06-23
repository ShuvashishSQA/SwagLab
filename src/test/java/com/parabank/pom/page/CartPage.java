package com.parabank.pom.page;

import com.parabank.pom.baseSwagTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends baseSwagTest {

    @FindBy(xpath = "//a[contains(text(), \"CHECKOUT\")]")
    WebElement btnCheckout;

    @FindBy (xpath = "//div[text()=\"Your Cart\"]")
    WebElement elCartPageTitle;
    public CartPage(){
        PageFactory.initElements(driver, this);
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
