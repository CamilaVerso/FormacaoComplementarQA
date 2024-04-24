package com.vemser.automationpractice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto {

    private String company;
    private String address;
    private String addressLine2;
    private String city;
    private String state;
    private String zipPostalCode;
    private String country;
    private String homePhone;
    private String mobilePhone;
    private String additionalInformation;
    private String nameAddress;
}
