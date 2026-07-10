package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import tests.testData.TestDataFaker;

import static tests.testData.TestData.*;


public class TextBoxTests extends TestBase {

    @Test
    void succssfullRegistrationTest() {
        registrationPage.openPage()
                .removeBanners()
                .typeFirstName(TestDataFaker.firstName)
                .typeLastName(TestDataFaker.lastName)
                .typeUserEmail(TestDataFaker.userEmail)
                .setGender(TestDataFaker.userGender)
                .typeUserNumber(TestDataFaker.userNumber)
                .setDateOfBirth(TestDataFaker.dayOfBirth, TestDataFaker.monthOfBirth, TestDataFaker.yearOfBirth)
                .typeSubject(TestDataFaker.userSubject)
                .setHobbies(TestDataFaker.userHobbie)
                .typeFile(TestDataFaker.userFile)
                .typeCurrentAddress(TestDataFaker.currentAddress)
                .setStateAndCity(TestDataFaker.userState, TestDataFaker.userCity)
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
                    .typeFirstName(TestDataFaker.firstName)
                    .typeLastName(TestDataFaker.lastName)
                    .setGender(TestDataFaker.userGender)
                    .typeUserNumber(TestDataFaker.userNumber)
                    .submitForm();

        tableResults.modalDialog();

        tableResults.checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Gender", userGender)
                .checkResults("Mobile", userNumber);
    }

    @Test
    void negativeEmptyfieldTest() {
        registrationPage.openPage()
                .typeFirstName(TestDataFaker.firstName)
                .typeUserNumber(TestDataFaker.userNumber)
                .submitForm();

        registrationPage.checkLastNameIsEmpty()
                        .genderIsEmpty();
    }

    @Test
    void negativeWrongEmailTest() {
        registrationPage.openPage()
                .typeFirstName(TestDataFaker.firstName)
                .typeLastName(TestDataFaker.lastName)
                .typeUserEmail(TestDataFaker.userEmail + "889")
                .setGender(TestDataFaker.userGender)
                .typeUserNumber(TestDataFaker.userNumber)
                .submitForm();

        registrationPage.wrongEmail();
    }

    @Test
    void negativeWrongNumberTest() {
        registrationPage.openPage()
                .typeFirstName(TestDataFaker.firstName)
                .setGender(TestDataFaker.userGender)
                .typeUserNumber("8900")
                .submitForm();

        registrationPage.wrongNumber();
    }
}

