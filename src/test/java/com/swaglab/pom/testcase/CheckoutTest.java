package com.swaglab.pom.testcase;

import com.swaglab.pom.baseSwagTest;
import com.swaglab.pom.page.CheckoutOverviewPage;
import com.swaglab.pom.page.CheckoutPage;
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
