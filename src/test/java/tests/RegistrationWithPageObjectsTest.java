package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.RandomTestData.*;


public class RegistrationWithPageObjectsTest extends TestBase {
    @Test
    void fillFormTest() {
        RegistrationPage registrationPage = new RegistrationPage();

        registrationPage.openPage()
                .closeBanner()
                .setName(randFirstName)
                .setLastName(randLastName)
                .setEmail(randEmail)
                .setGender(randGender)
                .setUserPhoneNumberInput(randPhoneNumber)
                .setBirthday(randomYear, randomMonth, randomDay)
                .setSubjects(randomSubjects)
                .setHobbies(randomHobbies)
                .uploadFile(randomPicture)
                .setAddress(randomAddress)
                .setState(randomState)
                .setCity(randCity)
                .submitForm()

                .checkResult("Student Name", String.format("%s %s", randFirstName, randLastName))
                .checkResult("Student Email", randEmail)
                .checkResult("Gender", randGender)
                .checkResult("Mobile", randPhoneNumber)
                .checkResult("Date of Birth", String.format("%s %s,%s", randomDay, randomMonth, randomYear))
                .checkResult("Subjects", randomSubjects)
                .checkResult("Hobbies", randomHobbies)
                .checkResult("Picture", randomPicture)
                .checkResult("Address", randomAddress)
                .checkResult("State and City", String.format("%s %s", randomState, randCity));
    }
}
