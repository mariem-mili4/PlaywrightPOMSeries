package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
   private Page page;          // 📦 Storage box (empty)
    //1. String Locators
    private String searchField = "//input[@name='search']";
    private  String searchButton = "//button[@class='btn btn-default btn-lg']";
    private String searchPageHeader = "div#content h1";
    private String loginLink = "a:text('Login')";
    private String AccountLink = "a[title='My Account']";


    //2. Page constructor :
    public HomePage(Page page){ // 📬 Delivery (page arrives)
         this.page = page;  // 📦 ← 📬 Put delivery into storage
    }

    //3. Page actions/methods
    public String getHomePageTitle(){
         String title = page.title();
        System.out.println("page title is :"+title);
        return title;
    }
    public String getHomePageURL (){
       String url = page.url();
        System.out.println("Page url : "+ url);
        return page.url();
    }
    public String searchProduct(String productName){
        page.fill(searchField, productName);
        page.click(searchButton);
        String header = page.textContent(searchPageHeader);
        System.out.println("Search header : "+header);
        return header;
    }
    public LoginPage naviagteToLoginPage(){
        page.click(AccountLink);
        page.click(loginLink);
        return new LoginPage(page);
    }

}
