package com.rizal.springdemo.mvc.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private Map<String, String> countryOptions;
    private String favoriteLanguage;

    public Student() {

        // implement populate dropdown list with some properties file (remove all list refferences)
//        countryOptions = new LinkedHashMap<>();
//        countryOptions.put("INA", "Indonesia");
//        countryOptions.put("USA", "United State of America");
//        countryOptions.put("IND", "India");
//        countryOptions.put("AFG", "Afghanistan");
//        countryOptions.put("ALB", "Albania");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Map<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }
}
