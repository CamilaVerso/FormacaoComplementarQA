package com.vemser.automationpractice.test;

import com.vemser.automationpractice.dto.CreateAccountDto;
import com.vemser.automationpractice.factory.data.CreateAccountData;
import com.vemser.automationpractice.page.CreateAccountPage;
import org.junit.Test;

public class CreateAccountTest extends BaseTest{

    CreateAccountPage createAccountPage = new CreateAccountPage();
    CreateAccountData createAccountData = new CreateAccountData();

    @Test
    public void initCreateAccount(){
        CreateAccountDto createAccountDto = createAccountData.insertAddressWithValidData();

        createAccountPage.signupPage();
        createAccountPage.createNewAccount(createAccountDto.getName(), createAccountDto.getEmail());
        createAccountPage.selectPronoun();
        createAccountPage.password();
        createAccountPage.selectDay(createAccountDto.getDay());
        createAccountPage.selectMounth(createAccountDto.getMonth());
        createAccountPage.selectYear(createAccountDto.getYear());
        createAccountPage.selectCheckbox();
        createAccountPage.fillFirstName(createAccountDto.getFirstName());
        createAccountPage.fillLastName(createAccountDto.getLastName());
        createAccountPage.fillCompany(createAccountDto.getCompany());
        createAccountPage.fillAddress(createAccountDto.getAddress());
        createAccountPage.fillAddress2(createAccountDto.getAddress2());
        createAccountPage.selectedCountry(createAccountDto.getCountry());
        createAccountPage.fillState(createAccountDto.getState());
        createAccountPage.fillCity(createAccountDto.getCity());
        createAccountPage.fillZipCode(createAccountDto.getZipCode());
        createAccountPage.fillMobilePhone(createAccountDto.getMobilePhone());
        createAccountPage.clickCreateAccount();
        createAccountPage.confirmAccountPage();
        closeAdsByGoogle();
        createAccountPage.fluxoDeleteAccount();


    }
}

