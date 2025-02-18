package com.example.PatientManagementSystem.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 2, max=20,message = "size must be between 5 and 20")
    private String name;

    @Min(value = 0, message = "Age must be greater than or equal to 0")
    @Max(value = 100, message = "Age must be less than or equal to 100")
    private int age;

    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be 'Male', 'Female', or 'Other'")
    private String gender;

    @Email(message="Enter Valid Email")
    private String email;

    @NotBlank(message = "Patient's city can't be empty")
    private String city;

    @NotNull(message = "Date of birth can't be null")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

}
