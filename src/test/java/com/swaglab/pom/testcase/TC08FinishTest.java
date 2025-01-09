package com.swaglab.pom.testcase;

import com.swaglab.pom.baseSwagTest;
import com.swaglab.pom.page.FinishPage;
import org.testng.annotations.Test;

public class TC08FinishTest extends baseSwagTest {
    public TC08FinishTest(){
        super();
    }

    @Test
    public void checkOrderConfirmation(){
        new FinishPage()
                .checkFinishPageHeader()  //To check finish page heading
                .checkConfirmationText(); //To check confirmation text
    }
}
