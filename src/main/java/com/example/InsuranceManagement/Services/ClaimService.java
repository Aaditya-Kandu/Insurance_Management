package com.example.InsuranceManagement.Services;

import com.example.InsuranceManagement.Convertors.ClaimDTOEntity;
import com.example.InsuranceManagement.DTOs.ClaimDTO;
import com.example.InsuranceManagement.Entities.Claims;
import com.example.InsuranceManagement.Entities.Clients;
import com.example.InsuranceManagement.Repositories.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {

    @Autowired
    ClaimRepository claimRepository;

    public String addClaim(ClaimDTO claimDTO) throws Exception{

        Claims claims = ClaimDTOEntity.covertClaimDTOtoEntity(claimDTO);

        claimRepository.save(claims);

        return "Claim Added Successfully";
    }


    // Get All Claims
    public List<Claims> getAllClaim() {

        return claimRepository.getAllClaims();
    }

    public Claims getClaimById(int id){
        Claims claims = claimRepository.findById(id).get();

        return claims;
    }

    // Claim Update by Id:

    public String claimUpdateById(int id, ClaimDTO claimDTO) throws Exception{

        Claims claims = getClaimById(id);

        claims.setClaimStatus(claimDTO.getClaimStatus());
        claims.setDescription(claimDTO.getDescription());
        claims.setClaimDate(claimDTO.getClaimDate());

        claimRepository.save(claims);

        return "Claim Updated Successfully";
    }

    public String claimDeleteById(int id) throws Exception{

        claimRepository.deleteById(id);
        return "Claim delete Successfully";
    }
}
