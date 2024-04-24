package com.vemser.automationpractice.page;

import com.vemser.automationpractice.dto.AddressDto;
import org.openqa.selenium.By;

import java.net.DatagramPacket;

public class AddressPage extends BasePage{

    private static final By homePageInfo = By.cssSelector("#home-page-tabs > li.active > a");
    private static final By homePageSignUpBtn = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");
    private static final By companyField = By.cssSelector("#company");
    private static final By addressField = By.cssSelector("#address1");
    private static final By addressSecondaryField = By.cssSelector("#address2");
    private static final By cityField = By.cssSelector("#city");
    private static final By stateField = By.cssSelector("#id_state");

    private static final By zipPostalCodeField = By.cssSelector("#postcode");
    private static final By countryField = By.cssSelector("#id_country");
    private static final By homePhoneField = By.cssSelector("#phone");
    private static final By mobilePhoneField = By.cssSelector("#phone_mobile");
    private static final By additionalInformationField = By.cssSelector("#other");
    private static final By nameAddressField = By.cssSelector("#alias");
    private static final By btnSave = By.cssSelector("#submitAddress");
    private static final By btnDelete = By.cssSelector("#center_column > div.addresses > div > div > ul > li.address_update > a:nth-child(2)");
    private static final By textPageMyAddresses = By.cssSelector("#center_column > h1");
    private static final By backToYourAddressesBtn = By.cssSelector("#center_column > ul > li > a");
    private static final By addMyFirstAddressBtn = By.cssSelector("#center_column > div > div > ul > li:nth-child(1) > a > span");
    private static final By textMyAccount = By.cssSelector("#center_column > h1");
    private static final By textYourAddress = By.cssSelector("#center_column > div > h1");

    private static final By textAddressDeleted = By.cssSelector("#center_column > p.alert.alert-warning");
    private static final By textErrorAddressCreate = By.cssSelector("#center_column > div > div > ol > li");

    private static final By emailField = By.cssSelector("#email");

    private static final By passwordField = By.cssSelector("#passwd");

    private static final By signInBtn = By.cssSelector("#SubmitLogin");

    private static final By loginInfotext = By.cssSelector("#center_column > p");

    public void fillEmailField(String email) {
        fillInput(emailField, email);
    }

    public void fillPasswordField(String senha) {
        fillInput(passwordField, senha);
    }


    public void fillCompanyField(String name) {
        fillInput(companyField, name);
    }

    public void  fillAddressField(String address){
        fillInput(addressField, address);
    }

    public void fillAddressSecondaryField(String secondaryAddress){
        fillInput(addressSecondaryField, secondaryAddress);
    }

    public void fillCityField(String city){
        fillInput(cityField, city);
    }

    public void selectState(String option){
            selectOptionSelect(stateField, "California");
    }

    public void  fillZipPostalCodeField(String zipCode){
        fillInput(zipPostalCodeField, zipCode);
    }

    public void selectCountry(String country){
        selectOptionSelect(countryField, "United States");
    }

    public void fillHomePhoneField(String phone){
        fillInput(homePhoneField, phone);
    }

    public void fillMobilePhoneField(String mobilePhone){
        fillInput(mobilePhoneField, mobilePhone);
    }

    public void fillNameAddressField(String nameAddress){
        fillInput(nameAddressField, nameAddress);
    }

    public void fillAdditionalInformationField(String text){
        fillInput(additionalInformationField, text);
    }
    public void clickBtnSave(){
        click(btnSave);
    }

    public void clickBtnBack(){
        click(backToYourAddressesBtn);
    }

    public void clickBtnAddMyFirstAddress(){
        click(addMyFirstAddressBtn);
    }

    public void clickBtnDelete(){
        click(btnDelete);
    }

    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }

    public String confirmPageMyAddresses(){
        return readText(textPageMyAddresses);
    }

    public String confirmPageMyAccount(){
        return readText(textMyAccount);
    }

    public String confirmPageYourAddress(){
        return readText(textYourAddress);
    }

    public String confirmDeletedAddress(){
        return readText(textAddressDeleted);
    }

    public String errorMessageCreatedAddress(){
        return readText(textErrorAddressCreate);
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

    public void registerNewAddressPage(){
        verifyHomePage();
        doLogin("camila@camila5.com", "12345678");
        confirmPageMyAccount();
        clickBtnAddMyFirstAddress();
        confirmPageYourAddress();
    }

    public void deleteAddress(){
        clickBtnDelete();
        alert_clickToAccept();
    }

    public void confirmAddressCreate(){
        clickBtnSave();
        confirmPageMyAddresses();
    }


}
