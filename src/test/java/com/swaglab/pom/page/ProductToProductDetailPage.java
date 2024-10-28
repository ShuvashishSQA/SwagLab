package com.swaglab.pom.page;

import com.swaglab.pom.baseSwagTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductToProductDetailPage extends baseSwagTest {

    @FindBy(xpath = "//button[contains(text(),'ADD TO CART')]")
    WebElement buttonAddToCart;
    @FindBy(xpath = "//button[contains(text(),'REMOVE')]" )
    WebElement buttonRemove;
    @FindBy(className = "inventory_details_back_button" )
    WebElement buttonBack;


    public ProductToProductDetailPage(){
        PageFactory.initElements(driver,this);
    }

    public ProductToProductDetailPage clickAddToCart(){
        buttonAddToCart.isDisplayed();
        buttonAddToCart.click();
        return this;
    }

    public ProductToProductDetailPage clickRemove(){
        buttonRemove.isDisplayed();
        buttonRemove.click();
        return this;
    }

    public ProductPage clickBack(){
        buttonBack.isDisplayed();
        buttonBack.click();
        return new ProductPage();
    }

}
