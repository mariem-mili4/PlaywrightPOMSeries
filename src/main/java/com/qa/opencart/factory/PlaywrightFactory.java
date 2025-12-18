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

    private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
    private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

    public static Playwright getPlaywight (){
        return tlPlaywright.get();
    }
    public static Browser getBrowser (){
        return tlBrowser.get();
    }
    public static BrowserContext getBrowserContext (){
        return tlBrowserContext.get();
    }
    public static Page getPage (){
        return tlPage.get();
    }

    //void: When the methode perform an action without returning any value
    public Page initBrowser (Properties prop) {
        String browserName = prop.getProperty("browser").trim();
        //playwright = Playwright.create(); //create a Playwright instance
        tlPlaywright.set(Playwright.create());
        switch (browserName) {
            case "chrome" :
               // browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywight().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "safari" :
                //browser= playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywight().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "firefox" :
                //browser= playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywight().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            default:
                System.out.println("Browser not found");
        }
        //browserContext = browser.newContext();
        tlBrowserContext.set(getBrowser().newContext());
        //page = browserContext.newPage();
        tlPage.set(getBrowserContext().newPage());
        //page.navigate(prop.getProperty("url").trim());
        getPage().navigate(prop.getProperty("url").trim());
        //return page;
        return getPage();
    }
    public Properties initProp() {
        try{
            FileInputStream ip = new FileInputStream ("./src/test/resources/config/config.properties");// open this file and read it
            prop = new Properties();
            prop.load(ip);//loading all key-values pairs from that file
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return prop;
    }
}

