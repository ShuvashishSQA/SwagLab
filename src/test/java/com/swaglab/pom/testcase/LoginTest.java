package com.swaglab.pom.testcase;

import com.swaglab.pom.baseSwagTest;
import com.swaglab.pom.page.ProductPage;
import com.swaglab.pom.page.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends baseSwagTest {

    ProductPage productPage;

    public LoginTest(){
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
