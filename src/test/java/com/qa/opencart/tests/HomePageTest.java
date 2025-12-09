package com.qa.opencart.tests;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {
    PlaywrightFactory pf;
    Page page;
    HomePage homePage;
    @BeforeTest
    public void setup(){
        pf = new PlaywrightFactory();
       page = pf.initBrowser("chrome");
       homePage = new HomePage(page);
    }

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
    @Test
    public void searchProductTest(){
        String actualSearchHeader = homePage.searchProduct("Macbook");
        Assert.assertEquals(actualSearchHeader,"Search - Macbook");

    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}
