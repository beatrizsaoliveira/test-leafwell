package com.leafwell.pages;

import com.microsoft.playwright.Page;

public class LeafWellHomePage {

    private String dropdownStateId = "#stateCode-dctct36-1663864869341";
    private String buttonGetStartId = ".to-green :text('Get started')";
    private boolean isStarted = false;

    private final Page page;

    public LeafWellHomePage(Page page) {
        this.page = page;
    }

    public boolean start(String state) {
        page.selectOption(dropdownStateId, state);
        page.click(buttonGetStartId);
        page.waitForSelector(buttonGetStartId).isVisible();

        boolean isEnabled = page.isEnabled("button");

        if (isEnabled) {
            isStarted = true;
        }

        return isStarted;
    }
}