package com.yasithsandesh.magulahoyamuapi.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateAccountDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    private int birthYear;

    @NotBlank(message = "EducationLevel is required")
    private String educationLevel;

    @NotBlank(message = "Job is required")
    private String job;

    private String height;

    @Pattern(
            regexp = "MALE|FEMALE",
            message = "Gender must be MALE, FEMALE"
    )
    private String gender;

    private String text;

    private String country;

    private String city;

    private PartnerPreferenceDTO partnerPreference;

}
