package utils;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;

public abstract class BaseTest {

    private Playwright playwright;
    private BrowserType browserType;
    private Browser browser;
    private BrowserContext context;
    protected Page page;

    private String staticMessageNotification = "text=Get your medical card online in minutes";

    public void launchPlaywright(String browserName, String headless) {
        playwright = Playwright.create();

        if (browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("msedge") || browserName.equalsIgnoreCase("chromium")) {
            browserType = playwright.chromium();
        } else if (browserName.equalsIgnoreCase("webkit")) {
            browserType = playwright.webkit();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            browserType = playwright.firefox();
        }

        if (headless.equalsIgnoreCase("true")) {
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setHeadless(true));
        } else {
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setHeadless(false));
        }

        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1280, 720));
        context.close();

        page = browser.newPage();

        System.out.println("Project Browser Name and Version is: " + browserName + " - " + browser.version());
    }

    public void launchApplication(String pageUrl) {
        page.navigate(pageUrl, new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
        page.waitForSelector(staticMessageNotification);
    }

    public void closePlaywright() {
        page.close();
        browser.close();
        playwright.close();
    }
}