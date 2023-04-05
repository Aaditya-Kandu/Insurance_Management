package com.example.InsuranceManagement.Convertors;


import com.example.InsuranceManagement.DTOs.InsuranceDTO;
import com.example.InsuranceManagement.Entities.InsurancePolicy;

public class InsuranceDTOtoEntity {

    public static InsurancePolicy insuranceDTOtoEntityCovert(InsuranceDTO insuranceDTO) {

        InsurancePolicy insurancePolicy = InsurancePolicy.builder()
                .policyTypes(insuranceDTO.getPolicyTypes())
                .coverageAmount(insuranceDTO.getCoverageAmount())
                .startDate(insuranceDTO.getStartDate())
                .endDate(insuranceDTO.getEndDate())
                .premium(insuranceDTO.getPremium())
                .policyNo(insuranceDTO.getPolicyNo())
                .build();

        return insurancePolicy;
    }
}
