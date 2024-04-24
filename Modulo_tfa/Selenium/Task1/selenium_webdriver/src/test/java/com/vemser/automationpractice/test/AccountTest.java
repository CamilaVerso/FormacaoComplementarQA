package com.vemser.automationpractice.test;

import com.vemser.automationpractice.dto.AccountDto;
import com.vemser.automationpractice.factory.data.AccountData;
import com.vemser.automationpractice.page.AccountPage;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest extends BaseTest{

    AccountPage accountPage = new AccountPage();
    AccountData accountData = new AccountData();

    @Test
    public void verifyAccountCreationWithValidData(){
        AccountDto accountDto = accountData.createAccountWithValidData();
        accountPage.verifyHomePage();
        accountPage.createAccount(accountDto.getEmail());
        accountPage.selectPronoun();
        accountPage.fillFirstName(accountDto.getFirstName());
        accountPage.fillLastName(accountDto.getLastName());
        accountPage.fillPasswordField(accountDto.getPassword());
        accountPage.selectDay(accountDto.getBirthDay());
        accountPage.selectMonth(accountDto.getBirthMonth());
        accountPage.selectYear(accountDto.getYears());
        accountPage.selectAcceptationTerms();
        accountPage.submitAccount();

        String successMessage = accountPage.getSuccessMessage();
        Assert.assertEquals("Your account has been created.", successMessage);
    }
    @Test
    public void verifyAccountCreationWithInvalidData(){
        AccountDto accountDto = accountData.createAccountWithInvalidData();
        accountPage.verifyHomePage();
        accountPage.createAccount(accountDto.getEmail());
        accountPage.selectPronoun();
        accountPage.fillFirstName(accountDto.getFirstName());
        accountPage.fillLastName(accountDto.getLastName());
        accountPage.fillPasswordField(accountDto.getPassword());
        accountPage.selectDay(accountDto.getBirthDay());
        accountPage.selectMonth(accountDto.getBirthMonth());
        accountPage.selectYear(accountDto.getYears());
        accountPage.selectAcceptationTerms();
        accountPage.submitAccount();

        String ErrorMessage = accountPage.getErrorMessageFirstName();
        Assert.assertEquals("There is 1 error\n" +
                "firstname is required.", ErrorMessage);
    }



}
