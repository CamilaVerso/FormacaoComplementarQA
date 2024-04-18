package com.vemser.automationpractice.factory.data;

import com.vemser.automationpractice.dto.LoginDto;
import com.vemser.automationpractice.util.DataFakerGenerator;

public class LoginData {
    DataFakerGenerator dataFakeGenerator = new DataFakerGenerator();
    public LoginDto loginWithValidData() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("luizfelliped53@gmail.com");
        loginDto.setPassword("123456789");
        return loginDto;
    }
    public LoginDto loginWithInvalidData() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(dataFakeGenerator.emailFaker());
        loginDto.setPassword(dataFakeGenerator.passwordFaker());
        return loginDto;
    }
}