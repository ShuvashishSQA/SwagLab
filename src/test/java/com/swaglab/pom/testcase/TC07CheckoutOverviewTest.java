package com.swaglab.pom.testcase;

import com.swaglab.pom.baseSwagTest;
import com.swaglab.pom.page.CheckoutOverviewPage;
import com.swaglab.pom.page.FinishPage;
import org.testng.annotations.Test;

public class TC07CheckoutOverviewTest extends baseSwagTest {

FinishPage finishPage = new FinishPage();

    public TC07CheckoutOverviewTest(){
        super();
    }

    @Test
    public void clickFinish(){
        finishPage = new CheckoutOverviewPage()
                .checkCheckoutOverviewPageHeader()
                .clickFinish();
    }
}
