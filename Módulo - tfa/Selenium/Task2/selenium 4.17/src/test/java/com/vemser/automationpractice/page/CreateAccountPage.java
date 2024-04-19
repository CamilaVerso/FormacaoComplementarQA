package com.vemser.automationpractice.page;

import com.vemser.automationpractice.dto.CreateAccountDto;
import org.openqa.selenium.By;

public class CreateAccountPage extends BasePage{

    private static final By signupLoginLink = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");

    private static final By textSignUp = By.cssSelector("#form > div > div > div:nth-child(3) > div > h2"); // New User Signup!

    private static final By pronounMr = By.cssSelector("#id_gender1");

    private static final By inputName = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > input[type=text]:nth-child(2)");
    private static final By inputEmail = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)");

    private static final By btnSignUp = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > button");

    private static final By inputPassword = By.cssSelector("#password");

    private static final By selectDay = By.cssSelector("#days");
    private static final By selectMonth = By.cssSelector("#months");
    private static final By selectYears = By.cssSelector("#years");

    private static final By checkboxNewsletter = By.cssSelector("#newsletter");
    private static final By checkboxOffer = By.cssSelector("#optin");

    private static final By inputFirstName = By.cssSelector("#first_name");
    private static final By inputLastName = By.cssSelector("#last_name");
    private static final By inputCompany = By.cssSelector("#company");
    private static final By inputAddress = By.cssSelector("#address1");
    private static final By inputAddress2 = By.cssSelector("#address2");
    private static final By selectCountry = By.cssSelector("#country");
    private static final By selectCountryUnitedStates = By.cssSelector("#country > option:nth-child(2)");
    private static final By inputState = By.cssSelector("#state");
    private static final By inputCity = By.cssSelector("#city");
    private static final By inputZipCode = By.cssSelector("#zipcode");
    private static final By mobilePhone = By.cssSelector("#mobile_number");
    private static final By btnCreateAccount = By.cssSelector("#form > div > div > div > div.login-form > form > button");



    public void signupPage(){
        click(signupLoginLink);
    }
    public void createNewAccount(){
    fillInput(inputName, "Camila");
    fillInput(inputEmail, "camila@camila1.com");
    click(btnSignUp);
}
    public void selectPronoun(){
        click(pronounMr);
    }

    public void selectNewsletter(){
        confirmInputCheckbox(checkboxNewsletter);
    }

    public void selectOffer(){
        confirmInputCheckbox(checkboxOffer);
    }

    public void selectDay(String day){
        fillInput(selectDay, day);
    }
    public void selectMounth(String mounth){
        fillInput(selectMonth, mounth);
    }
    public void selectYear(String year){
        fillInput(selectYears, year);
    }

    public void password(){
        fillInput(inputPassword, "123456789");
    }

    public void fillFirstName(String firstName){
        fillInput(inputFirstName, firstName);
    }

    public void fillLastName(String lastName){
        fillInput(inputLastName, lastName);
    }

    public void fillCompany(String company){
        fillInput(inputCompany, company);
    }

    public void fillAddress(String address){
        fillInput(inputAddress, address);
    }
    public void fillAddress2(String address2){
        fillInput(inputAddress2, address2);
    }

    public void selectedCountry(String country){
        fillInput(selectCountry, country);
    }

    public void fillState(String state){
        fillInput(inputState, state);
    }

    public void fillCity(String city){
        fillInput(inputCity, city);
    }
    public void fillZipCode(String zipcode){
        fillInput(inputZipCode, zipcode);
    }

    public void fillMobilePhone(String phone){
        fillInput(mobilePhone, phone);
    }

    public void clickCreateAccount(){
        click(btnCreateAccount);
    }



    public void selectCheckbox(){
        selectNewsletter();
        selectOffer();
    }



}
