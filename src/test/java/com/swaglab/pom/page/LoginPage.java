package com.swaglab.pom.page;

import com.swaglab.pom.baseSwagTest;
import org.openqa.selenium.By;
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


    public LoginPage collectAndSetUsername() {
        // Locate the 'Accepted usernames are' section
        WebElement userSection = driver.findElement(By.id("login_credentials"));

// Extract the text
        String userText = userSection.getText();

// Split the text to get individual usernames (assuming they are separated by line breaks)
        String[] users = userText.split("\\r?\\n");

// Example: Use the first username in the list for the user ID
        String userId = users[1]; // index 1, because index 0 might be "Accepted usernames are:"

// Now locate the username input field and input the user ID
        elUsername.isDisplayed();
        elUsername.clear();
        elUsername.sendKeys(userId);
        return this;
    }

    public LoginPage collectAndSetPassword() {
//Locate the 'password for all user' section
        WebElement passwordSection = driver.findElement(By.className("login_password"));

//Extract the text
        String passwordText = passwordSection.getText();

//Split the text to get password
        String[] splitPassword = passwordText.split("\\r?\\n");

//pick the exact password string
        String password = splitPassword[1];

//Now locate the password field and enter the password in the elPassword field
        elPassword.isDisplayed();
        elPassword.clear();
        elPassword.sendKeys(password);
        return this;
    }

    public ProductPage clickLogin() {
        btnLogin.isDisplayed();
        btnLogin.click();
        return new ProductPage();
    }

}