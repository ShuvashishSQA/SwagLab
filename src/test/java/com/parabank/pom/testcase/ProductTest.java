package com.parabank.pom.testcase;

import com.parabank.pom.baseSwagTest;
import com.parabank.pom.page.CartPage;
import com.parabank.pom.page.ProductPage;
import org.testng.annotations.Test;

public class ProductTest extends baseSwagTest {

    public CartPage cartPage;
    ProductTest(){
        super();
    }

    @Test
    public void proceedToCart(){
        cartPage = new ProductPage()        //Product Page instantiating
                .checkTitle()               //To check Product Page Title
                .sortByPriceLowHigh()       //To sort the list by selecting  "Price low to high".
                .addToCart()                //To add the lowest price item into cart
                .verifyCartBadge()          //To check if the added item count reflects on the cart icon
                .removeFromCart()           //To remove the added item into the cart from item list view
                .addToCart()                //Add the same item again
                .clickCart();               //Finally, click into the cart icon, CartPage will appear
    }

}
