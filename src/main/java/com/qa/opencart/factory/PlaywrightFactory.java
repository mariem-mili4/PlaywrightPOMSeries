package com.qa.opencart.factory;

import com.microsoft.playwright.Playwright;
//🏭 Factory = مصنع
public class PlaywrightFactory {
    Playwright playwright;// playwright is of class Playwright
//void : When the methode perform an action without returning any value
    public void initBrowser (String browserName) {
        System.out.println("Browser name is :"+browserName);
        playwright = Playwright.create(); //create a Playwright instance

    }
}
