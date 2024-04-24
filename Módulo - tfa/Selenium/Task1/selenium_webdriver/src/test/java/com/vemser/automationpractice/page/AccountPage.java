package com.vemser.automationpractice.page;

import org.openqa.selenium.By;


public class AccountPage extends BasePage {

    private static final By homePageInfo = By.cssSelector("#home-page-tabs > li.active > a");
    private static final By homePageSignUpBtn = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");
    private static final By emailField = By.cssSelector("#email_create");
    private static final By passwordField = By.cssSelector("#passwd");
    private static final By firstNameField = By.cssSelector("#customer_firstname");
    private static final By lastNameField = By.cssSelector("#customer_lastname");
    private static final By pronounMr = By.cssSelector("#id_gender1");
    private static final By createAnAccountBtn = By.cssSelector("#SubmitCreate");
   private static final By registerBtn = By.cssSelector("#submitAccount");
    private  By selectDay = By.cssSelector("#days");
    private By selectMonth = By.cssSelector("#months");
    private By selectYear = By.cssSelector("#years");
    private By acceptationTerms = By.cssSelector("#newsletter");
    private By errorMessageFirstNameRequired = By.cssSelector("#center_column > div");


    public void fillEmailField(String email) {
        fillInput(emailField, email);
    }

    public void fillPasswordField(String senha) {
        fillInput(passwordField, senha);
    }

    public void fillFirstName(String firstName){
        fillInput(firstNameField, firstName);
    }

    public void fillLastName(String lastName){
        fillInput(lastNameField, lastName);
    }

    public void verifyHomePage() {
        readText(homePageInfo);
        click(homePageSignUpBtn);
    }

    public void selectDay(String day){
        selectOptionByValue(selectDay, day);
    }

    public void selectMonth(String month){
        selectOptionByValue(selectMonth, month);
    }

    public void selectYear(String year){
        selectOptionByValue(selectYear, year);
    }

    public void createAccount(String email){
        fillEmailField(email);
        click(createAnAccountBtn);
    }
    public void selectPronoun(){
        click(pronounMr);
    }
   public void submitAccount(){
        click(registerBtn);
   }
    public void selectAcceptationTerms(){
        click(acceptationTerms);
    }

    private void selectDays(String day){
        selectOptionByValue(selectDay, day);
    }
   public String getSuccessMessage(){
        By successMessageLocator = By.cssSelector("#center_column > p.alert.alert-success");
        return readText(successMessageLocator);
   }

   public String getErrorMessageFirstName(){
        return readText(errorMessageFirstNameRequired);

   }

}