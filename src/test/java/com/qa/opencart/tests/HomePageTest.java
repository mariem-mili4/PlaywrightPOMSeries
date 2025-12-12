package com.qa.opencart.tests;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test (priority = 1)
    public void HomePageTitleTest(){
        String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, AppConstants.Home_PAGE_TITLE);
    }
    @Test (priority = 2)
    public void HomePageURLTest(){
        String actualURL = homePage.getHomePageURL();
        Assert.assertEquals(actualURL,AppConstants.URL);
    }
    @DataProvider
    public Object[][] getProductNames(){
        return new Object[][]{
                {"Macbook"},
                {"iMac"},
                {"Samsung"}
        };
    }

    @Test(priority = 3,dataProvider = "getProductNames")
    public void searchProductTest(String productName){
        String actualSearchHeader = homePage.searchProduct(productName);
        Assert.assertEquals(actualSearchHeader,"Search - "+productName);

    }

}
