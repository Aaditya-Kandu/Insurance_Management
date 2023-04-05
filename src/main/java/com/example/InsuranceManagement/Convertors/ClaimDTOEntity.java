package com.example.InsuranceManagement.Convertors;

import com.example.InsuranceManagement.DTOs.ClaimDTO;
import com.example.InsuranceManagement.Entities.Claims;

public class ClaimDTOEntity {

    public static Claims covertClaimDTOtoEntity(ClaimDTO claimDTO){

        Claims claims = Claims.builder()
                .claimNo(claimDTO.getClaimNo())
                .claimDate(claimDTO.getClaimDate())
                .claimStatus(claimDTO.getClaimStatus())
                .description(claimDTO.getDescription())
                .build();

        return claims;
    }
}
