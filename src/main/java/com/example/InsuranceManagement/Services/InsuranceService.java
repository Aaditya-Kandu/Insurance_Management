package com.example.InsuranceManagement.Services;

import com.example.InsuranceManagement.Convertors.InsuranceDTOtoEntity;
import com.example.InsuranceManagement.DTOs.InsuranceDTO;
import com.example.InsuranceManagement.Entities.Clients;
import com.example.InsuranceManagement.Entities.InsurancePolicy;
import com.example.InsuranceManagement.Repositories.ClientsRepository;
import com.example.InsuranceManagement.Repositories.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {

    @Autowired
    InsuranceRepository insuranceRepository;

    public String addInsurance(InsuranceDTO insuranceDTO) throws Exception{

        InsurancePolicy insurancePolicy = InsuranceDTOtoEntity.insuranceDTOtoEntityCovert(insuranceDTO);

        insuranceRepository.save(insurancePolicy);

        return "New Insurance Policy Added Successfully";
    }


    public List<InsurancePolicy> getAllInsurance(){
        return insuranceRepository.getAllInsurance();
    }

    // find by id
    public InsurancePolicy getPolicyById(int id){

        InsurancePolicy insurancePolicy = insuranceRepository.findById(id).get();

        return insurancePolicy;
    }

    public String updatePolicyById(int id, InsuranceDTO insuranceDTO) throws Exception{

        InsurancePolicy insurancePolicy =  getPolicyById(id);

        insurancePolicy.setPolicyTypes(insuranceDTO.getPolicyTypes());
        insurancePolicy.setPremium(insuranceDTO.getPremium());
        insurancePolicy.setStartDate(insuranceDTO.getStartDate());
        insurancePolicy.setEndDate(insuranceDTO.getEndDate());
        insurancePolicy.setCoverageAmount(insuranceDTO.getCoverageAmount());

        insuranceRepository.save(insurancePolicy);
      

        return "Policy Update Successfully";
    }

    public String deletePolicyById(int id) throws Exception{

        insuranceRepository.deleteById(id);

        return "Delete Policy Successfully";
    }
}
