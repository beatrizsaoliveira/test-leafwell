package com.leafwell.pages;

import com.microsoft.playwright.Page;

public class PatientRegisterPage {

    private String firstNameId = "#patient_registry_first_name";
    private String lastNameId = "#patient_registry_last_name";
    private String middleNameId = "#patient_registry_middle_name";
    private String sufix = "#patient_registry_suffix";
    private String genderMale = "#patient_registry_gender_m";
    private String genderFemale = "#patient_registry_gender_f";
    private String genderOther = "#patient_registry_gender_o";
    private String birthMouth = "#patient_registry_birth_date_month_birth_date";
    private String birthDateId = "#patient_registry_birth_date_day_birth_date";
    private String bithYear = "#patient_registry_birth_date_year_birth_date";
    private String addressOne = "#patient_registry_shipping_address_line_1";
    private String addressTwo = "#patient_registry_shipping_address_line_2";
    private String countryId = "#patient_registry_shipping_address_county";
    private String city = "#patient_registry_shipping_address_city";
    private String state = "#patient_registry_shipping_address_state_or_province_or_region";
    private String zipCode = "#patient_registry_shipping_address_postal_code";
    private String buttonContinue = ".c-btn :text('Continue')";

    private final Page page;

    public PatientRegisterPage(Page page) {
        this.page = page;
    }

    public void registerPatient(String firstName, String lastName, String middleName, String gender, String birthDate, String address, String country, String state, String zipCode) {
        page.fill(firstNameId, firstName);
        page.fill(lastNameId, lastName);
        page.fill(middleNameId, middleName);
        page.fill(genderFemale, gender);
        page.fill(birthMouth, birthDate);
        page.fill(birthDateId, birthDate);
        page.fill(bithYear, birthDate);
        page.fill(addressOne, address);
        page.fill(countryId, country);
        page.fill(lastNameId, lastName);
        page.fill(lastNameId, lastName);
        page.click(buttonContinue);
    }
}
