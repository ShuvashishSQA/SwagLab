package com.swaglab.pom.page;

import com.swaglab.pom.baseSwagTest;
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

    @FindBy(xpath = "//div[@class = 'inventory_item'][1]")
    WebElement elFirstItemOfTheList;

    @FindBy(xpath = "//a[@href=\"./cart.html\"]")
    WebElement btnCart;

    @FindBy(xpath = "/html/body/div/div[2]/div[1]/div[2]/a/span")
    WebElement elCartBadge;  //should be updated according item added into cart

    @FindBy(xpath = "//button[text()=\"REMOVE\"]")
    WebElement btnRemove;
    public ProductPage() {
        try {
            PageFactory.initElements(driver, this);

        } catch (Exception e) {
            System.out.println(e.getCause());
        }
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

    public ProductDetailPage checkProductDetails(){
        elFirstItemOfTheList.isDisplayed();
        elFirstItemOfTheList.click();
        return new ProductDetailPage();
    }

/*    public ProductPage addToCart(){
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
    }*/

}
