package com.swaglab.pom.testcase;

import com.swaglab.pom.baseSwagTest;
import com.swaglab.pom.page.CheckoutOverviewPage;
import com.swaglab.pom.page.CheckoutPage;
import org.testng.annotations.Test;

public class TC06CheckoutTest extends baseSwagTest {

    CheckoutOverviewPage checkoutOverviewPage ;
    public TC06CheckoutTest(){
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
