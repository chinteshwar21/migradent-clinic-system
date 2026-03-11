package com.migradent.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateDto {
    private String id;

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 100, message = "First name must be between 2 and 100 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 100, message = "Last name must be between 2 and 100 characters")
    private String lastName;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dob;

    @NotBlank(message = "Contact email is required")
    @Email(message = "Contact email must be a valid email address")
    private String contactEmail;

    @NotBlank(message = "Contact phone is required")
    @Pattern(
        regexp = "^[6-9]\\d{9}$",
        message = "Contact phone must be a valid Indian phone number (10 digits starting with 6-9)"
    )
    private String contactPhone;

    @NotBlank(message = "Status is required")
    private String status;
}