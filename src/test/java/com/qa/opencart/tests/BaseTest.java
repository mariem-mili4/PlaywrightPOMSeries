package com.qa.opencart.tests;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    PlaywrightFactory playwrightFactory;
    Page page;
    Properties prop;

    protected HomePage homePage;

    @BeforeTest
    public void setup() throws IOException {
        playwrightFactory = new PlaywrightFactory();
        prop = playwrightFactory.initProp();
        page = playwrightFactory.initBrowser(prop);
        homePage = new HomePage(page);
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }
}
