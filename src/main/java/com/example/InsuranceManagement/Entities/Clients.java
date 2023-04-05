package com.example.InsuranceManagement.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @NotNull
    @Column(unique = true)  // Allow only unique value
    @Size(min = 10, max = 10) // use some validation like phone no. only 10 digit not less not extra.
    private String phoneNo;

    @NotNull
    @Column(unique = true) // Only unique
    @Email                  // Accept only valid Email
    private String email;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth; // Manually fill the DOB

    private String address;

//
//    @OneToMany(mappedBy = "clients", cascade = CascadeType.ALL)
//    private List<InsurancePolicy> policyList = new ArrayList<>();
//


    
}
