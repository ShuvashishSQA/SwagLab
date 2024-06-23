package com.parabank.pom.page;

import com.parabank.pom.baseSwagTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinishPage extends baseSwagTest {

    @FindBy(xpath = "//div[text() = \"Finish\"]")
    WebElement elFinishPageHeader;      //Finish

    @FindBy (xpath = "//h2[text() = \"THANK YOU FOR YOUR ORDER\"]")
    WebElement elConfirmationText;      //THANK YOU FOR YOUR ORDER

    public FinishPage(){
        PageFactory.initElements(driver,this);
    }
    public FinishPage checkFinishPageHeader(){
        elFinishPageHeader.isDisplayed();
        return this;
    }

    public FinishPage checkConfirmationText(){
        elConfirmationText.isDisplayed();
        return this;
    }


}
