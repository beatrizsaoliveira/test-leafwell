package com.leafwell.pages;

import com.microsoft.playwright.Page;

public class StartRegistrationPage {

    private String formRegistration = "#form-container";
    private String buttonForOnePerson = ".c-toggle__btn single-plan no-price";
    private String buttonReferAndSave = ".c-toggle__btn multi-plan no-price";
    private String stateDropDown = "#patient_registry_state_code";
    private String emailForm = "#patient_registry_email";
    private String phoneNumberForm = "#patient_registry_phone";
    private String emailFriendForm = "#patient_registry_email_friend";
    private String checkBoxTerms = "#patient_registry_accepted_terms_of_service";
    private String getStartedButton = "#submitt_embeded_step_1";
    private boolean isRegisteredSuccess = false;

    private final Page page;

    public StartRegistrationPage(Page page) {
        this.page = page;
    }

    public boolean registerOnePerson(String email, String phoneNumber) {

        page.click(buttonForOnePerson);
        page.isVisible(stateDropDown);
        page.fill(emailForm, email);
        page.fill(phoneNumberForm, phoneNumber);
        page.click(checkBoxTerms);
        page.click(getStartedButton);
        page.waitForSelector(formRegistration).isVisible();

        boolean isRegistered = page.isVisible(formRegistration);

        if (isRegistered) {
            isRegisteredSuccess = true;
        }

        return isRegisteredSuccess;
    }

    public boolean registerReferAndSave(String email, String phoneNumber, String emailFriend) {

        page.click(buttonReferAndSave);
        page.isVisible(stateDropDown);
        page.fill(emailForm, email);
        page.fill(phoneNumberForm, phoneNumber);
        page.fill(emailFriendForm, emailFriend);
        page.click(checkBoxTerms);
        page.click(getStartedButton);
        page.waitForSelector(formRegistration).isVisible();

        boolean isRegistered = page.isVisible(formRegistration);

        if (isRegistered) {
            isRegisteredSuccess = true;
        }

        return isRegisteredSuccess;
    }
}