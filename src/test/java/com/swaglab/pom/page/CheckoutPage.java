package com.swaglab.pom.page;

import com.swaglab.pom.baseSwagTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class CheckoutPage extends baseSwagTest {

    @FindBy(xpath = "//div[text()=\"Checkout: Your Information\"]")
    WebElement elCheckoutPageHeader;
    @FindBy(id = "first-name")
    WebElement elCheckoutFirstName;
    @FindBy(id = "last-name")
    WebElement elCheckoutLastName;
    @FindBy(id = "postal-code")
    WebElement elCheckoutZipCode;

    @FindBy(xpath = "//input[@value=\"CONTINUE\"]")
    WebElement btnContinue;


    public CheckoutPage(){
        try {
            PageFactory.initElements(driver, this);

        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    public CheckoutPage checkCheckoutPageHeader(){
        elCheckoutPageHeader.isDisplayed();
        return this;
    }

    public CheckoutPage setCheckoutFirstName(){
        elCheckoutFirstName.isDisplayed();
        elCheckoutFirstName.clear();
        elCheckoutFirstName.sendKeys(getCheckoutFirstUserName());
        return this;
    }
    public CheckoutPage setCheckoutLastName(){
        elCheckoutLastName.isDisplayed();
        elCheckoutLastName.clear();
        elCheckoutLastName.sendKeys(getCheckoutLastUserName());
        return this;
    }
    public CheckoutPage setCheckoutZipCode(){
        elCheckoutZipCode.isDisplayed();
        elCheckoutZipCode.clear();
        elCheckoutZipCode.sendKeys(getCheckoutZipCode());
        return this;
    }

    public CheckoutOverviewPage clickContinue(){
        btnContinue.isDisplayed();
        btnContinue.click();
        return new CheckoutOverviewPage();
    }


}
