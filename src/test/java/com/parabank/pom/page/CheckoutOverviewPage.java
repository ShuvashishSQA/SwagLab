package com.parabank.pom.page;

import com.parabank.pom.baseSwagTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends baseSwagTest {

    @FindBy(xpath = "//div[text() = \"Checkout: Overview\"]")
    WebElement elCheckoutOverviewPageHeader;
    @FindBy(xpath = "//a[text() = \"FINISH\"]")
    WebElement btnFinish;

    public CheckoutOverviewPage(){
        try {
            PageFactory.initElements(driver, this);

        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    public CheckoutOverviewPage checkCheckoutOverviewPageHeader(){
        elCheckoutOverviewPageHeader.isDisplayed();
        return this;
    }

    public FinishPage clickFinish(){
        btnFinish.isDisplayed();
        btnFinish.click();
        return new FinishPage();
    }


}
