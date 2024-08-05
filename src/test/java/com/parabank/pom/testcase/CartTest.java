package com.parabank.pom.testcase;

import com.parabank.pom.baseSwagTest;
import com.parabank.pom.page.CartPage;
import com.parabank.pom.page.CheckoutPage;
import org.testng.annotations.Test;

public class CartTest extends baseSwagTest {

    CheckoutPage checkoutPage;
    public CartTest(){
        super();
    }

    @Test
    public void proceedToCheckout(){
        checkoutPage = new CartPage()
                .checkCartPageTitle()
                .clickCheckout();
    }
}
