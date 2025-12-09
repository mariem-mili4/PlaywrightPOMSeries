package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
    Page page;          // 📦 Storage box (empty)
    //1. String Locators
    private String searchField = "//input[@name='search']";
    private  String searchButton = "//button[@class='btn btn-default btn-lg']";
    private String searchPageHeader = "div#content h1";

    //2. Page constructor :
    public HomePage(Page page){ // 📬 Delivery (page arrives)
         this.page = page;  // 📦 ← 📬 Put delivery into storage
    }

    //3. Page actions/methods
    public String getHomePageTitle(){
         return page.title();
    }
    public String getHomePageURL (){
        return page.url();
    }
    public String searchProduct(String productName){
        page.fill(searchField, productName);
        page.click(searchButton);
       return page.textContent(searchPageHeader);
    }

}
