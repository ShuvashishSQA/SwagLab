package com.swaglab.pom.testcase;

import com.swaglab.pom.baseSwagTest;
import com.swaglab.pom.page.ProductToProductDetailPage;
import org.testng.annotations.Test;

public class TC03ProductToProductDetailTest extends baseSwagTest {

    TC03ProductToProductDetailTest(){
        super();
    }

    @Test
    public void productDetailsTest(){
        new ProductToProductDetailPage()
                .clickAddToCart()
                .clickRemove()
                .clickBack();
    }

}
