package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsTableComponent;
import com.demoqa.pages.components.StateAndCityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            userSubjectInput = $("#subjectsInput"),
            userHobbiesInput = $("#hobbiesWrapper"),
            userPictureInput = $("#uploadPicture"),
            userCurrentAddressInput = $("#currentAddress"),
            submitButton = $("#submit");
//          userStateInput = $("#state"),
//          userStateCity = $("#stateCity-wrapper"),
//          userCity = $("#city"),


    private static final String TITLE_TEXT = "Student Registration Form";

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage clearFirstName() {
        firstNameInput.clear();
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserGender(String value) {
        userGenderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserSubject(String value) {
        userSubjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setUserHobbies(String value) {
        userHobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage uploadUserPicture(String value) {
        userPictureInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPage setUserCurrentAddress(String value) {
        userCurrentAddressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setStateAndCity(String state, String city) {
        stateAndCityComponent.setStateWithCity(state, city);
        return this;
    }


    public RegistrationFormPage submitForm() {
        submitButton.click();
        return this;
    }

    public RegistrationFormPage checkResultsTableIsVisible() {
        resultsTableComponent.checkVisible();
        return this;
    }

    public RegistrationFormPage checkResultsInTable(String key, String value) {
        resultsTableComponent.checkResult(key, value);
        return this;
    }

}

