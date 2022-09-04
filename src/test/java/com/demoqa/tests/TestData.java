package com.demoqa.tests;

import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

import static java.lang.String.format;

public class TestData {
    static String firstName = "Alex",
            lastName = "Egorov",
            expectedFullName = format("%s %s", firstName, lastName),
            email = "AlexEgorov@mail.com",
            gender = "Male",
            mobile = "1234567890",
            subject = "Math",
            hobbies = "Sports",
            picturePath = "img/1.png",
            pictureName = "1.png",
            currentAddress = "Some address 1",
            state = "NCR",
            city = "Delhi",
            expectedStateCityAddress = format("%s %s", state, city),
            day = "30",
            month = "January",
            year = "2000",
            expectedDateOfBirth = format("%s %s,%s", day, month, year);
}
