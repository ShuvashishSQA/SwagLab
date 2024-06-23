package com.parabank.pom.page;

import com.parabank.pom.baseSwagTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends baseSwagTest {

    @FindBy(className = "product_label")
    WebElement elProductPageTitle;
    @FindBy(className = "product_sort_container")
    WebElement elSortProduct;

  /*  @FindBy (xpath = "//div[@class = 'inventory_item'][1]")
    WebElement elFirstItemOfTheList;*/

    @FindBy(xpath = "//div[@class = 'inventory_item'][1]//button[text()='ADD TO CART']")
    WebElement elFirstItemAddToCart;

    @FindBy(xpath = "//a[@href=\"./cart.html\"]")
    WebElement btnCart;

    @FindBy(className = "fa-layers-counter shopping_cart_badge")
    WebElement elCartBadge;  //should be updated according item added into cart

    @FindBy(xpath = "//button[text()=\"REMOVE\"]")
    WebElement btnRemove;
    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    //to check if the title appears correct --> Products
    public ProductPage checkTitle(){
        elProductPageTitle.isDisplayed();
        return this;
    }

    public ProductPage sortByPriceLowHigh(){
        elSortProduct.isDisplayed();
        Select select = new Select(elSortProduct);
        select.selectByVisibleText("Price (low to high)");
        return this;
    }

    public ProductPage addToCart(){
        elFirstItemAddToCart.isDisplayed();
        elFirstItemAddToCart.isDisplayed();
        elFirstItemAddToCart.click();
        return this;
    }

    public ProductPage verifyCartBadge(){
        System.out.println(elCartBadge.getText());//equals("1");
        return this;
    }

    public ProductPage removeFromCart(){
        btnRemove.isDisplayed();
        btnRemove.click();
        return this;
    }

    //Now click the Cart button. The CART page will appear.
    public CartPage clickCart(){
        btnCart.isDisplayed();
        btnCart.click();
        return new CartPage();
    }



}
