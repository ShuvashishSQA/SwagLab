package com.parabank.pom.testcase;

import com.parabank.pom.baseSwagTest;
import com.parabank.pom.page.CheckoutOverviewPage;
import com.parabank.pom.page.FinishPage;
import org.testng.annotations.Test;

public class CheckoutOverviewTest extends baseSwagTest {

FinishPage finishPage = new FinishPage();

    public CheckoutOverviewTest(){
        super();
    }

    @Test
    public void clickFinish(){
        finishPage = new CheckoutOverviewPage()
                .checkCheckoutOverviewPageHeader()
                .clickFinish();
    }
}
