package com.swaglab.pom.page;

import com.swaglab.pom.baseSwagTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static jdk.internal.agent.Agent.getText;

public class ProductDetailPage extends baseSwagTest {

    @FindBy(className = "btn_primary btn_inventory" )
    WebElement buttonAddToCart;
    @FindBy(className = "btn_secondary btn_inventory" )
    WebElement buttonRemove;
    @FindBy(className = "inventory_details_back_button" )
    WebElement buttonBack;

    @FindBy(className = "fa-layers-counter shopping_cart_badge")
    WebElement elCartBadge;

    public ProductDetailPage(){
        PageFactory.initElements(driver,this);
    }

    public ProductDetailPage clickAddToCart(){
        buttonAddToCart.isDisplayed();
        buttonAddToCart.click();
        return this;
    }
    public boolean verifyCartBadge(){
        String cartItemCount = elCartBadge.getText();//equals("1");
        return cartItemCount.equals("1");
    }

    public ProductDetailPage clickRemove(){
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
