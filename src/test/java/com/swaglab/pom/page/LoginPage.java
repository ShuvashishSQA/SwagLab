package com.swaglab.pom.page;

import com.swaglab.pom.baseSwagTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends baseSwagTest {

    @FindBy(id= "user-name")
    WebElement elUsername;
    @FindBy(id = "password")
    WebElement elPassword;
    @FindBy(id = "login-button")
    WebElement btnLogin;

    public LoginPage() {
        try {
            PageFactory.initElements(driver, this);

        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    public LoginPage setUsername(String Username) {
        elUsername.isDisplayed();
        elUsername.clear();
        elUsername.sendKeys(Username);
        return this;
    }

    public LoginPage setPassword(String Password) {
        elPassword.isDisplayed();
        elPassword.clear();
        elPassword.sendKeys(Password);
        return this;
    }

    public ProductPage clickLogin() {
        btnLogin.isDisplayed();
        btnLogin.click();
        return new ProductPage();
    }

  /*  public LoginPage clickLogin() {
        btnLogin.isDisplayed();
        btnLogin.click();
        return this;
    }*/

}