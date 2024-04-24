package com.TW.mobile_app_ws.ui.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class updateUserDetailsRequestModel {
    @NotNull(message = "First name can't be null")
    @Size(min = 2, message = "First name must be greater than 2 characters")
    private String firstName;
    @NotNull(message = "Last name can't be null")
    @Size(min = 2, message = "Last name must be greater than 2 characters")
    private String lastName;

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
}
