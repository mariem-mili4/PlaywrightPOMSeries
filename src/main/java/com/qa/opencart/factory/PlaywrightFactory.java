package com.qa.opencart.factory;

import com.microsoft.playwright.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//🏭 Factory = مصنع
public class PlaywrightFactory {
    Playwright playwright;// playwright is of class Playwright
    Browser browser;
    BrowserContext browserContext;//to create an isolated browsing env
    Page page;
    Properties prop;

//void: When the methode perform an action without returning any value
    public Page initBrowser (String browserName) {

        System.out.println("Browser name is :"+browserName);
        playwright = Playwright.create(); //create a Playwright instance
        switch (browserName) {
            case "chrome" :
                browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari" :
                browser= playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox" :
                browser= playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                System.out.println("Browser not found");
        }
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate("https://naveenautomationlabs.com/opencart/");
        return page;
    }
    public Properties initProp() throws IOException {
        FileInputStream ip = new FileInputStream ("src/test/resources/config/config.properties");// open this file and read it
        prop.load(ip);//loading all key-values pairs from that file
        return prop;
    }
}

