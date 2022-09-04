package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.pages.components.ResultsTableComponent;
import com.demoqa.utils.RandomUtils;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.CharSequence.compare;
import static java.lang.String.format;

public class RegistrationFormWithFakerTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    Faker faker = new Faker();

    String firstName,
            lastName,
            expectedFullName,
            email,
            gender,
            mobile,
            subject,
            hobbies,
            picturePath,
            pictureName,
            currentAddress,
            state,
            city,
            expectedStateCityAddress,
            day,
            month,
            year,
            expectedDateOfBirth;

    @BeforeEach

    void randomTestData() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        expectedFullName = format("%s %s", firstName, lastName);
        email = faker.internet().emailAddress();
        gender = RandomUtils.getRandomGender();
        mobile = faker.phoneNumber().subscriberNumber(10);
        subject = RandomUtils.getRandomSubject();
        hobbies = RandomUtils.getRandomHobbies();
        picturePath = "img/1.png";
        pictureName = "1.png";
        currentAddress = faker.address().fullAddress();
        state = RandomUtils.getRandomState();
        city = RandomUtils.getRandomCityFromState(state);
        expectedStateCityAddress = format("%s %s", state, city);
        month = RandomUtils.getRandomMonthOfBirth();
        year = faker.number().numberBetween(1900, 2100) + "";
        day = RandomUtils.getRandomDayOfBirth(month,year);
        expectedDateOfBirth = format("%s %s,%s", day, month, year);
    }
    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setUserGender(gender)
                .setUserNumber(mobile)
                .setBirthDate(day, month, year)
                .setUserSubject(subject)
                .setUserHobbies(hobbies)
                .uploadUserPicture(picturePath)
                .setUserCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .submitForm()
                .checkResultsTableIsVisible()
                .checkResultsInTable("State and City", expectedStateCityAddress)
                .checkResultsInTable("Student Name", expectedFullName)
                .checkResultsInTable("Gender", gender)
                .checkResultsInTable("Mobile", mobile)
                .checkResultsInTable("Date of Birth", expectedDateOfBirth)
                .checkResultsInTable("Subjects", subject)
                .checkResultsInTable("Hobbies", hobbies)
                .checkResultsInTable("Picture", pictureName)
                .checkResultsInTable("Address", currentAddress);
    }

    @Test
    void fillFormWithMinimumDataFormTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setUserGender(gender)
                .setUserNumber(mobile)
                .submitForm()
                .checkResultsTableIsVisible()
                .checkResultsInTable("Student Name", expectedFullName)
                .checkResultsInTable("Gender", gender)
                .checkResultsInTable("Mobile", mobile);
    }

}
