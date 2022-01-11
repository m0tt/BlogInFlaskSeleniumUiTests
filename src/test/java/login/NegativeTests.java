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
                        .clickSignInButtonWithoutSuccess()
                        .getAlertText())
                .isEqualTo("Invalid username or password");
    }

    @Test
    public void warningMessageShouldBeVisibleWhenUserNameIsEmpty() {
        assertThat(
                loginPage.open()
                        .setUsername(RandomString.make())
                        .setPassword(RandomString.make())
                        .clickSignInButtonWithoutSuccess()
                        .getAlertText())
                .isEqualTo("Invalid username or password");
    }

    @Test
    public void warningMessageShouldBeVisibleWhenInvalidEmailAddressProvided() {
        assertThat(
                loginPage.open()
                        .clickRegisterLink()
                        .setUsername(RandomString.make())
                        .setEmail(RandomString.make())
                        .setPassword(RandomString.make())
                        .setRepeatPassword(RandomString.make())
                        .clickRegisterButtonWithoutSuccess()
                        .getHelpText())
                .isEqualTo("Invalid email address.");
    }

    @Test
    public void warningMessageShouldBeVisibleWhenInvalidRepeatPasswordProvided() {
        assertThat(
                loginPage.open()
                        .clickRegisterLink()
                        .setUsername(RandomString.make())
                        .setEmail(String.join("@", RandomString.make(), "m0tt.pl"))
                        .setPassword(RandomString.make())
                        .setRepeatPassword(RandomString.make())
                        .clickRegisterButtonWithoutSuccess()
                        .getHelpText())
                .isEqualTo("Field must be equal to password.");
    }
}
