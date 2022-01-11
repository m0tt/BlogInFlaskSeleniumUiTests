package login;

import base.BaseTest;
import com.framework.pages.CreatePostPage;
import com.framework.pages.HomePage;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class E2EFlowTest extends BaseTest {

    String userName = RandomString.make(4);
    String email = String.join("@", RandomString.make(), "m0tt.pl");
    String password = RandomString.make();
    String title = RandomString.make();
    HomePage homePage;
    CreatePostPage createPostPage;

    @Test
    public void newUserShouldBeRegistered() {
        loginPage = loginPage.open();
        assertThat(
                loginPage.clickRegisterLink()
                        .setUsername(userName)
                        .setEmail(email)
                        .setPassword(password)
                        .setRepeatPassword(password)
                        .clickRegisterButtonWithSuccess()
                        .getAlertText())
                .isEqualTo("Congratulations, you are now a registered user!");
    }

    @Test(dependsOnMethods = {"newUserShouldBeRegistered"})
    public void newUserShouldBeLoggedIn() {
        homePage = loginPage.clickSignInButtonWithSuccess(userName, password);
        assertThat(
                homePage.getLabelDangerText())
                .isEqualTo("Sorry but there is nothing to display. Please create a new post.");
    }

    @Test(dependsOnMethods = {"newUserShouldBeLoggedIn"})
    public void newUserShouldCreatePost() {
        createPostPage = homePage.clickCreateLink();
        assertThat(
                createPostPage.setTitle(title)
                        .setContent("Content of the 1st post")
                        .clickCreateButtonWithSuccess()
                        .getAlertText())
                .isEqualTo("Post was successfully created!");
    }

    @Test(dependsOnMethods = {"newUserShouldCreatePost"})
    public void newPostShouldBeVisible() {
        homePage = createPostPage.clickMicroblogLink();
        assertThat(
                homePage.getListOfPostDetails().get(0))
                .contains(userName)
                .contains(title);
    }

    @Test(dependsOnMethods = {"newPostShouldBeVisible"})
    public void newPostShouldBeEditable() {
        createPostPage = homePage.clickEditButton();
        assertThat(
                createPostPage.setTitle("EditedPost")
                        .setContent("EditedPost")
                        .clickCreateButtonWithSuccess()
                        .getAlertText())
                .contains("Post was successfully updated!");
        homePage = createPostPage.clickMicroblogLink();
        assertThat(
                homePage.getListOfPostDetails().get(0))
                .contains(userName)
                .contains(title+"EditedPost");
    }

    @Test(dependsOnMethods = {"newPostShouldBeEditable"})
    public void newPostShouldBeDeletable() {
        createPostPage = homePage.clickEditButton();
        assertThat(
                createPostPage.getTitle())
                .contains(title+"EditedPost");
        assertThat(
                createPostPage.getContent())
                .contains("Content of the 1st postEditedPost");
        createPostPage.clickDeleteButtonWithSuccess()
                      .clickDeleteConfirmationPopUpWithSuccess();
        assertThat(
                homePage.getLabelDangerText())
                .isEqualTo("Sorry but there is nothing to display. Please create a new post.");

    }
}
