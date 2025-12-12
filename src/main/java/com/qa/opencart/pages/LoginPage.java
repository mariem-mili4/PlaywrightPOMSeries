package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;
    //1. String Locators - OR
    private String emailField = "input[name='email']";
    private String passwordField = "input[name='password']";
    private String loginButton = "input[class='btn btn-primary']";
    private String forgetPasswordLink = "a[href=\"https://naveenautomationlabs.com/opencart/index.php?route=account/forgotten\"]:first-of-type";
    private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";


    //2.Page Constructor :
    public LoginPage(Page page){
        this.page = page;
    }

    //3. page actions/methods :
    public String getLoginPageTitle(){
        return page.title();
    }
    public Boolean isEmailFieldExist(){
        return page.isVisible(emailField);
    }
    public Boolean isLoginButtonExist(){
        return page.isVisible(loginButton);
    }
    public Boolean isPwdlFieldExist(){
        return page.isVisible(passwordField);
    }
    public Boolean isForgetPwdExist(){
        return page.isVisible(forgetPasswordLink);
    }
    public boolean login(String email, String password){
        System.out.println("App creds: " + email + ":" + password);
        page.fill(emailField, email);
        page.fill(passwordField, password);
        page.click(loginButton);
        page.locator(logoutLink).waitFor();
        if(page.locator(logoutLink).isVisible()) {
            System.out.println("user is logged in successfully....");
            return true;
        }else {
            System.out.println("user is not logged in successfully....");
            return false;
        }
    }
}
