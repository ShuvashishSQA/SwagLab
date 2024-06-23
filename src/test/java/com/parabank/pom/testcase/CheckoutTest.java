package com.parabank.pom.testcase;

import com.parabank.pom.baseSwagTest;
import com.parabank.pom.page.CheckoutOverviewPage;
import com.parabank.pom.page.CheckoutPage;
import org.testng.annotations.Test;

public class CheckoutTest extends baseSwagTest {

    CheckoutOverviewPage checkoutOverviewPage ;
    public CheckoutTest(){
        super();
    }

    @Test
    public void clickCheckout() {
        checkoutOverviewPage = new CheckoutPage()
                .checkCheckoutPageHeader()
                .setCheckoutFirstName()
                .setCheckoutLastName()
                .setCheckoutZipCode()
                .clickContinue();
    }

}
