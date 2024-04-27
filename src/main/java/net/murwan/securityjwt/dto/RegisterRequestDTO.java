package net.murwan.securityjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private AddressDTO addressDTO;
    private String dob;
    private String sex;
    private String bloodType;
    private String chronic;
    private String allergies;
    private String surgeries;
    private String medications;
    private String immunization;
    private String familyHistory;
    private String physicianName;
    private String physicianContact;
    private String emergencyInstructions;
    private String emergencyContact;

}