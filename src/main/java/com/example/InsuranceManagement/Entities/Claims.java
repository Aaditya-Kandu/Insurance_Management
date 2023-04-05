package com.example.InsuranceManagement.Entities;

import com.example.InsuranceManagement.Enums.ClaimStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "claim")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Claims {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String claimNo = UUID.randomUUID().toString();

    private String description;


    private LocalDate claimDate;

    @Enumerated(value = EnumType.STRING)
    private ClaimStatus claimStatus;

//    @ManyToOne
//    @JoinColumn
//    InsurancePolicy insurancePolicy;


}
