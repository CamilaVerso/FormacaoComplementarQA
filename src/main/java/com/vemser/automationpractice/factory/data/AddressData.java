package com.vemser.automationpractice.factory.data;

import com.github.javafaker.Faker;
import com.vemser.automationpractice.dto.AddressDto;
import java.util.Locale;



public class AddressData {

    Faker faker = new Faker(new Locale("en-us"));

    public AddressDto insertAddressWithValidData() {


        AddressDto addressDto = new AddressDto();
        addressDto.setCompany(String.valueOf(faker.company().name()));
        addressDto.setAddress(String.valueOf(faker.address().streetAddress()));
        addressDto.setAddressLine2(String.valueOf(faker.address().secondaryAddress()));
        addressDto.setCity(String.valueOf(faker.address().cityName()));
        addressDto.setState(addressDto.getState());
        addressDto.setZipPostalCode(faker.address().zipCodeByState(faker.address().stateAbbr()));
        addressDto.setCountry("United States");
        addressDto.setHomePhone(faker.phoneNumber().subscriberNumber(5));
        addressDto.setMobilePhone(String.valueOf(faker.phoneNumber().cellPhone()));
        addressDto.setAdditionalInformation(String.valueOf(faker.lorem().characters(10)));
        addressDto.setNameAddress(String.valueOf(faker.funnyName().name()));

        return addressDto;
    }

    public AddressDto insertAddressWithInvalidData() {

        AddressDto addressDto = new AddressDto();
        addressDto.setCompany(String.valueOf(faker.company().name()));
        addressDto.setAddress(String.valueOf(faker.address().streetAddress()));
        addressDto.setAddressLine2(String.valueOf(faker.address().secondaryAddress()));
        addressDto.setCity(String.valueOf(faker.address().cityName()));
        addressDto.setState(addressDto.getState());
        addressDto.setZipPostalCode(faker.address().zipCodeByState(faker.address().stateAbbr()));
        addressDto.setCountry("United States");
        addressDto.setHomePhone("");
        addressDto.setMobilePhone("");
        addressDto.setAdditionalInformation(String.valueOf(faker.lorem().characters(10)));
        addressDto.setNameAddress(String.valueOf(faker.funnyName().name()));


        return addressDto;
    }
}

