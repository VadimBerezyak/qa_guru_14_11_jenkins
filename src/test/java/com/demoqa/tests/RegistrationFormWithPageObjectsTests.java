package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.pages.components.ResultsTableComponent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setUserEmail("AlexEgorov@mail.com")
                .setUserGender("Other")
                .setUserNumber("1234567890")
                .setBirthDate("30", "December", "2000")
                .setUserSubject("Math")
                .setUserHobbies("Sports")
                .uploadUserPicture("img/1.png")
                .setUserCurrentAddress("Some address 1")
                .setStateAndCity("NCR", "Delhi")
                .submitForm()
                .checkResultsTableIsVisible()
                .checkResultsInTable("State and City", "NCR Delhi")
                .checkResultsInTable("Student Name", "Alex Egorov")
                .checkResultsInTable("Gender", "Other")
                .checkResultsInTable("Mobile", "1234567890")
                .checkResultsInTable("Date of Birth", "30 December,2000")
                .checkResultsInTable("Subjects", "Maths")
                .checkResultsInTable("Hobbies", "Sports")
                .checkResultsInTable("Picture", "1.png")
                .checkResultsInTable("Address", "Some address 1")
                .checkResultsInTable("State and City", "NCR Delhi");
    }

    @Test
    void fillFormWithMinimumDataFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setUserGender("Other")
                .setUserNumber("1234567890")
                .submitForm()
                .checkResultsTableIsVisible()
                .checkResultsInTable("Student Name", "Alex Egorov")
                .checkResultsInTable("Gender", "Other")
                .checkResultsInTable("Mobile", "1234567890");
    }

}
