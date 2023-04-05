package com.example.InsuranceManagement.DTOs;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientsDTO {

    private String name;

    private String phoneNo;

    private String email;

    private LocalDate DateOfBirth;

    private String address;

}
