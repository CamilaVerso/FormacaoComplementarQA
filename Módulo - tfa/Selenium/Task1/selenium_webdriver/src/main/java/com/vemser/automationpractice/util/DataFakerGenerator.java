package com.vemser.automationpractice.util;

import com.github.javafaker.Faker;

import java.util.Locale;
public class DataFakerGenerator {
    private static final Faker faker = new Faker(new Locale("en"));

    public String emailFaker() {
        return faker.internet().emailAddress();
    }
    public String passwordFaker() {
        return faker.internet().password();
    }


}