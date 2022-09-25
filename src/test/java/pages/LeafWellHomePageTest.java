package pages;

import com.leafwell.pages.LeafWellHomePage;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.BaseTest;

public class LeafWellHomePageTest extends BaseTest {

    private LeafWellHomePage leafwellHomePage;
    private String page_url = "https://dev.leafwell.com/";

    @BeforeClass
    @Parameters({"pageUrl", "browserName", "headless"})
    public void browserStart(@Optional("https://dev.leafwell.com/") String pageUrl, @Optional("webkit") String browserName, @Optional("false") String headless) {
        launchPlaywright(browserName, headless);
        launchApplication(pageUrl);

        PlaywrightAssertions.assertThat(page).hasURL(page_url);
    }

    @Test(priority = 1)
    @Parameters("state")
    public void startedTest(@Optional("NY") String state) {
        leafwellHomePage = new LeafWellHomePage(page);

        boolean isStartedSucceeded = leafwellHomePage.start(state);

        Assert.assertTrue(isStartedSucceeded);
    }

    @AfterClass
    public void browserClose() {
        closePlaywright();
    }
}