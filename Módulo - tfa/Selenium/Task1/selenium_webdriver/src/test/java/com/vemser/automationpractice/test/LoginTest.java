package com.vemser.automationpractice.test;

import com.vemser.automationpractice.dto.LoginDto;
import com.vemser.automationpractice.factory.data.LoginData;
import com.vemser.automationpractice.page.LoginPage;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseTest{

    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();

    @Test
    public void verifyLoginWithValidData() {
        LoginDto loginDto = loginData.loginWithValidData();
        loginPage.verifyHomePage();
        String msgm = loginPage.doLogin(loginDto.getEmail(), loginDto.getPassword());
        Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", msgm);
    }

    @Test
    public void verifyLoginWithInvalidData() {
        LoginDto loginDto = loginData.loginWithInvalidData();
        loginPage.verifyHomePage();
        String msgm = loginPage.loginIncorrectEmail(loginDto.getEmail(), loginDto.getPassword());
        Assert.assertEquals("Authentication failed.", msgm);
    }

    @Test
    public void verifyLogout() {
        LoginDto loginDto = loginData.loginWithValidData();
        loginPage.verifyHomePage();
        loginPage.doLogin(loginDto.getEmail(), loginDto.getPassword());
        String msg = loginPage.doLogout();
        Assert.assertEquals("AUTHENTICATION", msg);
    }
}