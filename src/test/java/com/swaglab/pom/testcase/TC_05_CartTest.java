package com.swaglab.pom.testcase;

import com.swaglab.pom.baseSwagTest;
import com.swaglab.pom.page.CartPage;
import com.swaglab.pom.page.CheckoutPage;
import org.testng.annotations.Test;

public class TC_05_CartTest extends baseSwagTest {

    CheckoutPage checkoutPage;
    public TC_05_CartTest(){
        super();
    }

    @Test
    public void proceedToCheckout(){
        checkoutPage = new CartPage()
                .checkCartPageTitle()
                .clickCheckout();
    }
}
