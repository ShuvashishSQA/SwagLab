package com.parabank.pom.testcase;

import com.parabank.pom.baseSwagTest;
import com.parabank.pom.page.FinishPage;
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
