package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static tests.testData.TestData.*;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;

public class TextBoxTests extends TestBase {
    @Test
    void succssfullRegistrationTest_withFaker() {
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
        String userGender = "Male";
        String userNumber = "8900562323";
        String monthOfBirth = "June";
        String yearOfBirth = "2000";
        String dayOfBirth = "14";
        String userSubject = "Commerce";
        String userHobbie = "Music";
        String userFile = "file.png";
        String userState = "Uttar Pradesh";
        String userCity = "Lucknow";

//    @Test
//    void succssfullRegistrationTest() {
//        registrationPage.openPage()
//                .removeBanners()
//                .typeFirstName(firstName)
//                .typeLastName(lastName)
//                .typeUserEmail(userEmail)
//                .setGender(userGender)
//                .typeUserNumber(userNumber)
//                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
//                .typeSubject(userSubject)
//                .setHobbies(userHobbie)
//                .typeFile(userFile)
//                .typeCurrentAddress(currentAddress)
//                .setStateAndCity(userState, userCity)
//                .submitForm();

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
    void succssfullRegistrationTest_withUtils() {
        Faker faker = new Faker();

        String firstName = getRandomString(10);
        String lastName = faker.name().lastName();
        String userEmail = getRandomEmail();
        String userGender = "Male";
        String userNumber = "8900562323";
        String monthOfBirth = "June";
        String yearOfBirth = "2000";
        String dayOfBirth = "14";
        String userSubject = "Commerce";
        String userHobbie = "Music";
        String userFile = "file.png";
        String userState = "Uttar Pradesh";
        String userCity = "Lucknow";

//    @Test
//    void succssfullRegistrationTest() {
//        registrationPage.openPage()
//                .removeBanners()
//                .typeFirstName(firstName)
//                .typeLastName(lastName)
//                .typeUserEmail(userEmail)
//                .setGender(userGender)
//                .typeUserNumber(userNumber)
//                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
//                .typeSubject(userSubject)
//                .setHobbies(userHobbie)
//                .typeFile(userFile)
//                .typeCurrentAddress(currentAddress)
//                .setStateAndCity(userState, userCity)
//                .submitForm();

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

