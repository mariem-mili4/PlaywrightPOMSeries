package com.qa.opencart.tests;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.tests.BaseTest ;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void HomePageTitleTest(){
        String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle,"Your Store");
    }
    @Test
    public void HomePageURLTest(){
        String actualURL = homePage.getHomePageURL();
        Assert.assertEquals(actualURL,"https://naveenautomationlabs.com/opencart/");
    }
    @DataProvider
    public Object[][] getProductNames(){
        return new Object[][]{
                {"Macbook"},
                {"iMac"},
                {"Samsung"}
        };
    }

    @Test(dataProvider = "getProductNames")
    public void searchProductTest(String productName){
        String actualSearchHeader = homePage.searchProduct(productName);
        Assert.assertEquals(actualSearchHeader,"Search - "+productName);

    }

}
