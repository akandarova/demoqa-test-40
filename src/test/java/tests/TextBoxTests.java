package tests;

import org.junit.jupiter.api.Test;

import static tests.testData.TestData.*;

public class TextBoxTests extends TestBase {
    @Test
    void succssfullRegistrationTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .setGender(userGender)
                .typeUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .typeSubject(userSubject)
                .setHobbies(userHobbie)
                .typeFile(userFile)
                .typeCurrentAddress(currentAddress)
                .setStateAndCity(userState, userCity)
                .submitForm();

        tableResults.modalDialog();

        tableResults.checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Student Email", userEmail)
                .checkResults("Gender", userGender)
                .checkResults("Mobile", userNumber)
                .checkResults("Date of Birth", dayOfBirth)
                .checkResults("Subjects", userSubject)
                .checkResults("Hobbies", userHobbie)
                .checkResults("Picture", userFile)
                .checkResults("Address", currentAddress)
                .checkResults("State and City", userState + " " + userCity);
    }

    @Test
    void checkMustHaveFormTest() {
            registrationPage.openPage()
                    .typeFirstName(firstName)
                    .typeLastName(lastName)
                    .setGender(userGender)
                    .typeUserNumber(userNumber)
                    .submitForm();

        tableResults.modalDialog();

        tableResults.checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Gender", userGender)
                .checkResults("Mobile", userNumber);
    }

    @Test
    void negativeEmptyfieldTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeUserNumber(userNumber)
                .submitForm();

        registrationPage.checkLastNameIsEmpty()
                        .genderIsEmpty();
    }

    @Test
    void negativeWrongEmailTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail + "889")
                .setGender(userGender)
                .typeUserNumber(userNumber)
                .submitForm();

        registrationPage.wrongEmail();
    }

    @Test
    void negativeWrongNumberTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(userGender)
                .typeUserNumber("8900")
                .submitForm();

        registrationPage.wrongNumber();
    }
}

