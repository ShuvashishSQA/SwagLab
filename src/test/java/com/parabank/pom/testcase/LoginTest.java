package com.parabank.pom.testcase;

import com.parabank.pom.baseSwagTest;
import com.parabank.pom.page.ProductPage;
import com.parabank.pom.page.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends baseSwagTest {

    ProductPage productPage;

    public LoginTest(){
        super();
    }

    @Test
    public void clickLogin(){
        productPage = new LoginPage()
                .setUsername(getUserName())
                .setPassword(getPassword())
                .clickLogin();
        }
}
