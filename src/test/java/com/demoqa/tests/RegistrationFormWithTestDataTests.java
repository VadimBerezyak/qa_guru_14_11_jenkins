package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.pages.components.ResultsTableComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;
import static java.lang.String.format;

public class RegistrationFormWithTestDataTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();



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
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setUserGender("Other")
                .setUserNumber("1234567890")
                .submitForm()
                .checkResultsTableIsVisible()
                .checkResultsInTable("Student Name", expectedFullName)
                .checkResultsInTable("Gender", "Other")
                .checkResultsInTable("Mobile", "1234567890");
    }

}
