package com.vemser.automationpractice.factory.data;

import com.vemser.automationpractice.dto.LoginDto;
import com.vemser.automationpractice.util.DataFakerGenerator;

public class LoginData {
    DataFakerGenerator dataFakeGenerator = new DataFakerGenerator();
    public LoginDto loginWithValidData() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("camila@camila1.com");
        loginDto.setPassword("123456789");
        return loginDto;
    }
    public LoginDto loginWithInvalidData() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(dataFakeGenerator.emailFaker());
        loginDto.setPassword(dataFakeGenerator.passwordFaker());
        return loginDto;
    }
    public LoginDto loginWithEmptyData() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("");
        loginDto.setPassword("");
        return loginDto;
    }
    public LoginDto loginWithEmptyPassword() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("camila@camila1.com");
        loginDto.setPassword("");
        return loginDto;
    }
}