package com.swaglab.pom.testcase;

import com.swaglab.pom.baseSwagTest;
import com.swaglab.pom.page.CartPage;
import com.swaglab.pom.page.ProductPage;
import org.testng.annotations.Test;

public class TC_02_ProductTest extends baseSwagTest {

    public CartPage cartPage;
    TC_02_ProductTest(){
        super();
    }

    @Test
    public void proceedToCart(){
        new ProductPage()        //Product Page instantiating
                .checkTitle()               //To check Product Page Title
                .sortByPriceLowHigh()       //To sort the list by selecting  "Price low to high".
                .checkProductDetails();     //Landing into Product Details page

                /*.addToCart()                //To add the lowest price item into cart
                .verifyCartBadge()          //To check if the added item count reflects on the cart icon
                .removeFromCart()           //To remove the added item into the cart from item list view
                .addToCart()                //Add the same item again
                .clickCart();               //Finally, click into the cart icon, CartPage will appear*/
    }
}
