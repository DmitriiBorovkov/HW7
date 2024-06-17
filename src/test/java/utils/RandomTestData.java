package utils;

import com.github.javafaker.Faker;
import java.util.Locale;

public class RandomTestData {
    static Faker faker = new Faker(new Locale("en"));

    public static String randFirstName = getRandomName(),
            randLastName = getRandomLastName(),
            randEmail = getRandomEmail(),
            randGender = getRandomGender(),
            randPhoneNumber = getRandomPhoneNumber(),
            randomYear = getRandomYear(),
            randomMonth = getRandomMonth(),
            randomDay = getRandomDay(),
            randomHobbies = getRandomHobbies(),
            randomSubjects = getRandomSubjects(),
            randomPicture = getRandomPicture(),
            randomAddress = getRandomAddress(),
            randomState = getRandomState(),
            randCity = getRandomCity(randomState);

    private static String getRandomName() {
        return faker.name().firstName();
    }

    private static String getRandomLastName() {
        return faker.name().lastName();
    }

    private static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    private static String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    private static String getRandomPhoneNumber() {
        return faker.number().digits(10);
    }

    private static String getRandomYear() {
        return String.format("%s", faker.number().numberBetween(1900, 2023));
    }

    private static String getRandomMonth() {
        return faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }

    private static String getRandomDay() {
        return String.format("%02d", faker.number().numberBetween(1, 28));
    }

    private static String getRandomHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    private static String getRandomSubjects() {
        return faker.options().option("Maths", "Art", "Accounting", "Physics", "Chemistry", "Economics", "English",
                "Biology", "History", "Civics", "Computer Science", "Social Studies", "Hindi", "Commerce");
    }

    private static String getRandomPicture() {
        return faker.options().option("rr.png", "kot.jpg");
    }

    private static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    private static String getRandomState() {
        return faker.options().option("NCR","Uttar Pradesh","Haryana", "Rajasthan");
    }

    public static String getRandomCity(String state) {

        return switch (state) {
            case "NCR" -> randCity = faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> randCity = faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> randCity = faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> randCity = faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
}




