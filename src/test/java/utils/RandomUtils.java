package utils;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;

public class RandomUtils {
    Faker faker = new Faker();

//   public static void main(String[] args) {
//        System.out.println(getRandomString(8));
//        System.out.println(getRandomEmail());
//        System.out.println(getRandomInt(111111111, 999999999));
//        System.out.println(getRandomPhone());
//        System.out.println(getRandomGender());
//        System.out.println(getGender());
//    }

    public static String getRandomString(int lenght){
        //String LETTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        SecureRandom rnd = new SecureRandom();

        for (int i = 0; i < lenght; i++){
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));
        }

        return result.toString();
    }

    public static String getRandomEmail() {
        //return getRandomString(8) + "@" + getRandomString(4) + ".com";
        return format("%s@%s.com", getRandomString(8), getRandomString(8));
    }

    public static int getRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomPhone(){
        String phoneTemplate = "+%s (%s) %s - %s - %s";

        return format(phoneTemplate,getRandomInt(1, 9), getRandomInt(111, 999), getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }

//    public static String getRandomGender_bad_practice(){
//        String[] genders = {"Male", "Female", "Other"};
//        int randomIndex = getRandomInt(0, genders.length-1);
//
//        return genders[randomIndex];
//    }

    public static String getRandomGender(){
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromStringArray(genders);
    }

    public static String getRandomItemFromStringArray(String[] stringArray){
        int arrayLenght = stringArray.length;
        int randomIndex = getRandomInt(0, arrayLenght - 1);

        return stringArray[randomIndex];
    }

    public String getGender(){
        String[] gender = {"Male", "Female", "Other"};
        return faker.options().option(gender);
    }

    public String getSubject() {
        String[] subject = {"Maths","Accounting","Arts","Social Studies","Physics","Chemistry",
                "Computer Science","Commerce","Economics","Civics","English","Hindi","Biology","History"};

        return faker.options().option(subject);
    }

    public String getHobbie() {
        String[] hobbie = {"Sports", "Reading", "Music"};

        return faker.options().option(hobbie);
    }

    public String getUserFile() {
        String[] userFile = {"file.png", "file2.png"};

        return faker.options().option(userFile);
    }

    public String selectCity(String state) {
            return switch (state) {
                case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
                case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
                case "Haryana" -> faker.options().option("Karnal", "Panipat");
                case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
                default -> null;
            };
        }
}
