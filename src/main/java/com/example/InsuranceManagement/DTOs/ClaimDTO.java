package com.example.InsuranceManagement.DTOs;

import com.example.InsuranceManagement.Entities.Clients;
import com.example.InsuranceManagement.Enums.ClaimStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ClaimDTO {


    private String description;

    private LocalDate claimDate;

    private ClaimStatus claimStatus;

    private String claimNo = UUID.randomUUID().toString();


}
