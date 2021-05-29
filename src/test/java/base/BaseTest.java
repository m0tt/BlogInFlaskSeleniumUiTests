package base;

import com.framework.base.factory.DriverFactory;
import com.framework.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private WebDriver driver;
    protected LoginPage loginPage;

    @BeforeTest
    public void setUp(){
        this.driver = new DriverFactory().getDriver();
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void tearDown(){
        this.driver.close();
    }

}
