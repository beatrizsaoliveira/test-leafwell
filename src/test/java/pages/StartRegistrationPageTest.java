package pages;

import com.leafwell.pages.StartRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.BaseTest;

public class StartRegistrationPageTest extends BaseTest {

    private StartRegistrationPage startRegistrationPage;

    @BeforeClass
    @Parameters({"pageUrl", "browserName", "headless"})
    public void browserStart(@Optional("https://dev.leafwell.com/medical-card") String pageUrl, @Optional("webkit") String browserName, @Optional("false") String headless) {
        launchPlaywright(browserName, headless);
        launchApplication(pageUrl);
    }

    @Test(priority = 2)
    @Parameters({"name", "email", "phoneNumber"})
    public void registrationTest(@Optional("beatriz_123@email.com") String email, @Optional("123456789") String phoneNumber) {
        startRegistrationPage = new StartRegistrationPage(page);

        boolean isRegistered = startRegistrationPage.registerOnePerson(email, phoneNumber);

        Assert.assertTrue(isRegistered);
    }

    @AfterClass
    public void browserClose() {
        closePlaywright();
    }
}