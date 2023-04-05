package com.example.InsuranceManagement.DTOs;

import com.example.InsuranceManagement.Enums.PolicyTypes;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class InsuranceDTO {


    private PolicyTypes policyTypes;

    private int coverageAmount;

    private String premium;

    private LocalDate startDate;

    private String policyNo = UUID.randomUUID().toString();

    private LocalDate endDate;
}
