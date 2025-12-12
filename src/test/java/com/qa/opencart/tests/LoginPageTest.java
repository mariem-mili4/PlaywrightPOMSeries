package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    @Test (priority = 1)
    public void loginPageNavigationTest(){
       loginPage = homePage.naviagteToLoginPage();
       String actualLoginPageTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(actualLoginPageTitle, AppConstants.Login_PAGE_TITLE);
    }
    @Test (priority = 2)
    public void isEmailFieldExistTest(){
        Assert.assertTrue(loginPage.isEmailFieldExist());
    }
    @Test (priority = 3)
    public void isPasswordFieldExistTest(){
        Assert.assertTrue(loginPage.isPwdlFieldExist());
    }
    @Test (priority = 4)
    public void isLoginButtonExistTest(){
        Assert.assertTrue(loginPage.isLoginButtonExist());
    }
    @Test (priority = 5)
    public void isForgetPasswordExistTest(){
        Assert.assertTrue(loginPage.isForgetPwdExist());
    }
    @Test (priority = 6)
    public void loginTest(){
        Assert.assertTrue(loginPage.login(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
    }
}
