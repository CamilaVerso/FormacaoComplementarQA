package com.vemser.automationpractice.page;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private static final By homePageInfo = By.cssSelector("#home-page-tabs > li.active > a");

    private static final By homePageSignUpBtn = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");

    private static final By emailField = By.cssSelector("#email");

    private static final By passwordField = By.cssSelector("#passwd");

    private static final By signInBtn = By.cssSelector("#SubmitLogin");

    private static final By loginInfotext = By.cssSelector("#center_column > p");

    private static final By incorrectEmailMessage = By.cssSelector("#center_column > div.alert.alert-danger > ol > li");

    private static final By signOutBtn = By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a");

    private static final By textAuthenticationPage = By.cssSelector("#center_column > h1");


    public void fillEmailField(String email) {
        fillInput(emailField, email);
    }

    public void fillPasswordField(String senha) {
        fillInput(passwordField, senha);
    }

    public void verifyHomePage() {
        readText(homePageInfo);
        click(homePageSignUpBtn);
    }

    public String doLogin(String email, String senha) {
        fillEmailField(email);
        fillPasswordField(senha);
        click(signInBtn);
        return readText(loginInfotext);
    }

    public String loginIncorrectEmail(String email, String senha) {
        fillEmailField(email);
        fillPasswordField(senha);
        click(signInBtn);
        return readText(incorrectEmailMessage);
    }

    public String doLogout () {
        click(signOutBtn);
        return readText(textAuthenticationPage);
    }
}