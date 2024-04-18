package com.vemser.automationpractice.factory.data;

import com.vemser.automationpractice.dto.AccountDto;
import com.vemser.automationpractice.util.DataFakerGenerator;

import java.util.Random;


public class AccountData {
    DataFakerGenerator dataFakeGenerator = new DataFakerGenerator();
    Random random = new Random();

    public AccountDto createAccountWithValidData() {

        AccountDto accountDto = new AccountDto();
        accountDto.setFirstName("Camila");
        accountDto.setLastName("Gonçalves");
        accountDto.setEmail(dataFakeGenerator.emailFaker());
        accountDto.setPassword(dataFakeGenerator.passwordFaker());
        accountDto.setBirthDay(String.valueOf(random.nextInt(31) + 1));
        accountDto.setBirthMonth(String.valueOf(random.nextInt(12) + 1));
        accountDto.setYears(String.valueOf(random.nextInt(103) + 1900));


        return accountDto;
    }

    public AccountDto createAccountWithInvalidData() {

        AccountDto accountDto = new AccountDto();
        accountDto.setFirstName("");
        accountDto.setLastName("Gonçalves");
        accountDto.setEmail(dataFakeGenerator.emailFaker());
        accountDto.setPassword(dataFakeGenerator.passwordFaker());
        accountDto.setBirthDay(String.valueOf(random.nextInt(31) + 1));
        accountDto.setBirthMonth(String.valueOf(random.nextInt(12) + 1));
        accountDto.setYears(String.valueOf(random.nextInt(103) + 1900));


        return accountDto;
    }
}
