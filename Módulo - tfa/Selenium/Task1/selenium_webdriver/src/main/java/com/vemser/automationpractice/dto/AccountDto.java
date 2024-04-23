package com.vemser.automationpractice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthDay;
    private String birthMonth;
    private String years;

}




