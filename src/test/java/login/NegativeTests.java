package login;

import base.BaseTest;
import net.bytebuddy.utility.RandomString;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NegativeTests extends BaseTest {

    @Test
    public void alertTextForLogInIsDisplayed() {
        assertThat(
                loginPage.open()
                        .getAlertText())
                .isEqualTo("Please log in to access this page.");
    }

    @Test
    public void errorMessageShouldBeVisibleWhenIncorrectCredentialsProvided() {
        assertThat(
                loginPage.open()
                        .setUsername(RandomString.make())
                        .setPassword(RandomString.make())
                        .submitWithoutSuccess()
                        .getAlertText())
                .isEqualTo("Invalid username or password");
    }

    @Test
    public void warningMessageShouldBeVisibleWhenUserNameIsEmpty() {
        assertThat(
                loginPage.open()
                        .setUsername(RandomString.make())
                        .setPassword(RandomString.make())
                        .submitWithoutSuccess()
                        .getAlertText())
                .isEqualTo("Invalid username or password");
    }

    @Test
    public void invalidEmailAddress() {
        assertThat(
                loginPage.open()
                        .clickOnRegisterLink()
                        .setUsername(RandomString.make())
                        .setEmail(RandomString.make())
                        .setPassword(RandomString.make())
                        .setRepeatPassword(RandomString.make())
                        .submitWithoutSuccess()
                        .getAlertText())
                .isEqualTo("Invalid email address.");
    }

    @Test
    public void invalidRepeatPassword() {
        assertThat(
                loginPage.open()
                        .clickOnRegisterLink()
                        .setUsername(RandomString.make())
                        .setEmail(RandomString.make()+"@test.pl")
                        .setPassword(RandomString.make())
                        .setRepeatPassword(RandomString.make())
                        .submitWithoutSuccess()
                        .getAlertText())
                .isEqualTo("Field must be equal to password.");
    }
}
