package tests.testData;

import com.github.javafaker.Faker;

public class TestDataFaker {

    static Faker faker = new Faker();

   public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String userEmail = faker.internet().emailAddress();
    public static String userGender = faker.options().option("Male", "Female");
    public static String userNumber = String.valueOf(faker.phoneNumber().subscriberNumber(10));
    public static String monthOfBirth = faker.options().option("January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December");
    public static String yearOfBirth = String.format("%s", faker.number().numberBetween(1900, 2100));
    public static String dayOfBirth = String.format("%s", faker.number().numberBetween(10, 28));
    public static String userSubject = faker.options().option("English", "Chemistry", "Computer Science", "Commerce", "Economics",
            "Civics");
    public static String userHobbie = faker.options().option("Sports", "Reading", "Music");
    public static String currentAddress = faker.address().streetAddress();
    public static String userFile = faker.options().option("file.png", "file2.png");
    public static String userState = faker.options().option("NCR", "Haryana", "Rajasthan");
    public static String userCity = selectCity(userState);

    public static String selectCity(String userState) {
        return switch (userState) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
}
