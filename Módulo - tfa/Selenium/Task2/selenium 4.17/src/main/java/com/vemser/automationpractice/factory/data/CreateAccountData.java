package com.vemser.automationpractice.factory.data;

import com.vemser.automationpractice.dto.CreateAccountDto;
import com.vemser.automationpractice.util.DataFakerGenerator;

import java.util.Random;

public class CreateAccountData {

    DataFakerGenerator dataFakeGenerator = new DataFakerGenerator();

    Random random = new Random();

    public CreateAccountDto insertAddressWithValidData(){

        CreateAccountDto createAccountDto = new CreateAccountDto();

        createAccountDto.setPassword(dataFakeGenerator.passwordFaker());

        createAccountDto.setName(dataFakeGenerator.firstNameFake());
        createAccountDto.setEmail(dataFakeGenerator.emailFaker());
        createAccountDto.setDay(String.valueOf(random.nextInt(31) + 1));
        createAccountDto.setMonth(String.valueOf(random.nextInt(12) + 1));
        createAccountDto.setYear(String.valueOf(random.nextInt(103) + 1900));
        createAccountDto.setFirstName(dataFakeGenerator.firstNameFake());
        createAccountDto.setLastName(dataFakeGenerator.lastNameFaker());
        createAccountDto.setCompany(dataFakeGenerator.companyFaker());
        createAccountDto.setAddress(dataFakeGenerator.addressFaker());
        createAccountDto.setAddress2(dataFakeGenerator.address2Faker());
        createAccountDto.setCountry("United States");
        createAccountDto.setState(dataFakeGenerator.stateFaker());
        createAccountDto.setCity(dataFakeGenerator.cityFaker());
        createAccountDto.setZipCode(dataFakeGenerator.zipCodeFaker());
        createAccountDto.setMobilePhone(dataFakeGenerator.mobilePhoneFaker());
        System.out.println(createAccountDto);
        return createAccountDto;

    }

    public CreateAccountDto insertAddressWithInvalidData(){

        CreateAccountDto createAccountDto = new CreateAccountDto();

        createAccountDto.setPassword(dataFakeGenerator.passwordFaker());

        createAccountDto.setName(dataFakeGenerator.firstNameFake());
        createAccountDto.setEmail(dataFakeGenerator.emailFaker());
        createAccountDto.setDay(String.valueOf(random.nextInt(31) + 1));
        createAccountDto.setMonth("July");
        createAccountDto.setYear(String.valueOf(random.nextInt(103) + 1900));
        createAccountDto.setFirstName("");
        createAccountDto.setLastName(dataFakeGenerator.lastNameFaker());
        createAccountDto.setCompany(dataFakeGenerator.companyFaker());
        createAccountDto.setAddress(dataFakeGenerator.addressFaker());
        createAccountDto.setAddress2(dataFakeGenerator.address2Faker());
        createAccountDto.setCountry("United States");
        createAccountDto.setState(dataFakeGenerator.stateFaker());
        createAccountDto.setCity(dataFakeGenerator.cityFaker());
        createAccountDto.setZipCode(dataFakeGenerator.zipCodeFaker());
        createAccountDto.setMobilePhone(dataFakeGenerator.mobilePhoneFaker());
        System.out.println(createAccountDto);

        return createAccountDto;

    }
}

