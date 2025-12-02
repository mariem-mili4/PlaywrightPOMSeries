package com.qa.opencart.factory;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
//🏭 Factory = مصنع
public class PlaywrightFactory {
    Playwright playwright;// playwright is of class Playwright
//void : When the methode perform an action without returning any value
    public void initBrowser (String browserName) {
        System.out.println("Browser name is :"+browserName);
        playwright = Playwright.create(); //create a Playwright instance
        switch (browserName) {
            case "chrome" : playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); break;
            case "safari" : playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)); break;
            case "chromium" : playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); break;
            case "firefox" : playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)); break;
            default: System.out.println("Browser not found");
        }

    }
}
