package com.example.InsuranceManagement.Entities;

import com.example.InsuranceManagement.Enums.PolicyTypes;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.w3c.dom.stylesheets.LinkStyle;
import java.util.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "policy")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class InsurancePolicy {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    // Policy type use as a Enum type data
    // Database not allow entered Enum type then convert Enum to String
    @Enumerated(value = EnumType.STRING)
    private PolicyTypes policyTypes;

    private String policyNo = UUID.randomUUID().toString();

    private int coverageAmount;

    private String premium;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;




//    @ManyToOne
//    @JoinColumn
//    Clients clients;
//
//
//    @OneToMany(mappedBy = "insurancePolicy", cascade = CascadeType.ALL)
//    private List<Claims> claimsList= new ArrayList<>();




}
