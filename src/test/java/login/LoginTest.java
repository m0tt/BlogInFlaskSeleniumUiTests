package login;

import base.BaseTest;
import net.bytebuddy.utility.RandomString;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    public void alertTextIsDisplayed() {
        assertThat(
                loginPage.open()
                        .getAlertText())
                .isEqualTo("Please log in to access this page.");
    }

    @Test
    public void errorMessageShouldBeVisibleWhenIncorrectCredentialsProvided() {
        assertThat(
                loginPage.open()
                        .withUsername(RandomString.make())
                        .withPassword(RandomString.make())
                        .submitWithoutSuccess()
                        .getAlertText())
                .isEqualTo("Invalid username or password");
    }

}
