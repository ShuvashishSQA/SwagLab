package com.swaglab.pom.testcase;

import com.swaglab.pom.baseSwagTest;
import com.swaglab.pom.page.FinishPage;
import org.testng.annotations.Test;

public class FinishTest extends baseSwagTest {
    public FinishTest(){
        super();
    }

    @Test
    public void checkOrderConfirmation(){
        new FinishPage()
                .checkFinishPageHeader()  //To check finish page heading
                .checkConfirmationText(); //To check confirmation text
    }
}
