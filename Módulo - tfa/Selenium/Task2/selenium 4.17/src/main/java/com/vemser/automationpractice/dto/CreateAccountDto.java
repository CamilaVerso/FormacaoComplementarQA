package com.vemser.automationpractice.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateAccountDto {

    private String password;
    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String address2;
    private String country;
    private String state;
    private String city;
    private String zipCode;
    private String mobilePhone;
    private String day;
    private String month;
    private String year;
}
