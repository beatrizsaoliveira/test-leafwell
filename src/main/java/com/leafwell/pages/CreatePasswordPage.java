package com.leafwell.pages;

import com.microsoft.playwright.Page;

public class CreatePasswordPage {

    private String newPwd = "#patient_registry_password";
    private String confirmNewPwd = "#patient_registry_password_confirmation";
    private String continueButton = ".c-btn :text('Continue')";

    private final Page page;

    public CreatePasswordPage(Page page) {
        this.page = page;
    }

    public void registerPassword(String password, String confirmPassword) {
        page.fill(newPwd, password);
        page.fill(confirmNewPwd, confirmPassword);
        page.click(continueButton);
    }
}