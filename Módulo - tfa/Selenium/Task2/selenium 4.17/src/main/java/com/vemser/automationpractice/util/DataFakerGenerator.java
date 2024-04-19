package com.vemser.automationpractice.util;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataFakerGenerator {
    private static final Faker faker = new Faker(new Locale("en-us"));

    public String emailFaker() {
        return faker.internet().emailAddress();
    }

    public String passwordFaker() {
        return faker.internet().password();
    }

    public String firstNameFake(){
        return faker.name().firstName();
    }

//    public String countryFaker(){
//        return faker.address().country();
//    }

    public String lastNameFaker(){
        return faker.name().lastName();
    }

    public String companyFaker(){
        return faker.company().name();
    }

    public String addressFaker(){
        return faker.address().streetAddress();
    }

    public String address2Faker(){
        return faker.address().secondaryAddress();
    }

    public String stateFaker(){
        return faker.address().state();
    }

    public String cityFaker(){
        return faker.address().cityName();
    }

    public String zipCodeFaker(){
        return faker.address().zipCodeByState(faker.address().stateAbbr());
    }

    public String mobilePhoneFaker(){
        return faker.phoneNumber().cellPhone();
    }

}
