package base;

import com.framework.base.factory.DriverFactory;
import com.framework.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class BaseTest {
    private WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        this.driver = new DriverFactory().getDriverType();
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown() {
        //this.driver.close();
        this.driver.quit();
    }

}
