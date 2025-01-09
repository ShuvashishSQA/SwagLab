package com.swaglab.pom.testcase;

import com.swaglab.pom.baseSwagTest;
import com.swaglab.pom.page.ProductPage;
import com.swaglab.pom.page.LoginPage;
import org.testng.annotations.Test;

public class TC01LoginTest extends baseSwagTest {

    ProductPage productPage;

    public TC01LoginTest(){
        super();
    }


    @Test(priority = 0)
    public void clickLoginButton(){
        productPage = new LoginPage()
                .collectAndSetUsername()
                .collectAndSetPassword()
                .clickLogin();
        }
}
