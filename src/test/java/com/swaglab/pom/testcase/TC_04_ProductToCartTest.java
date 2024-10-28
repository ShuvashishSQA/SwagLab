package com.swaglab.pom.testcase;

import com.swaglab.pom.baseSwagTest;
import com.swaglab.pom.page.CartPage;
import com.swaglab.pom.page.ProductPage;
import org.testng.annotations.Test;

public class TC_04_ProductToCartTest extends baseSwagTest {

    public CartPage cartPage;
    TC_04_ProductToCartTest(){
        super();
    }

    @Test
    public void proceedToCart(){
        new ProductPage()        //Product Page instantiating
                .checkTitle()               //To check Product Page Title
                .addToCart()                //To add the lowest price item into cart
                .clickCart();               //Finally, click into the cart icon, CartPage will appear
    }
}
