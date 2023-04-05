package com.example.InsuranceManagement.Controllers;

import com.example.InsuranceManagement.DTOs.InsuranceDTO;
import com.example.InsuranceManagement.Entities.InsurancePolicy;
import com.example.InsuranceManagement.Services.InsuranceService;
import org.hibernate.validator.internal.metadata.core.AnnotationProcessingOptionsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InsuranceController {

    @Autowired
    InsuranceService insuranceService;

    @PostMapping("/policies")
    public ResponseEntity<String> addNewPolicy(@RequestBody() InsuranceDTO insuranceDTO){

        try {
            String response = insuranceService.addInsurance(insuranceDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Fetch all the policy
    @GetMapping("/policies")
    public List<InsurancePolicy> getAllPolicy(){
        return insuranceService.getAllInsurance();
    }

    // fetch the policy by the id

    @GetMapping("/policies/{id}")
    public InsurancePolicy getInsuranceById(@PathVariable(value = "id") int id){

        InsurancePolicy insurancePolicy = insuranceService.getPolicyById(id);

        return insurancePolicy;
    }

    // update policy by id
    @PutMapping("/policies/{id}")
    public ResponseEntity<String> updatePolicyById(@PathVariable(value = "id") int id,@RequestBody() InsuranceDTO insuranceDTO){

        try {
            String response = insuranceService.updatePolicyById(id,insuranceDTO);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    // Delete policy by id

    @DeleteMapping("/policies/{id}")
    public ResponseEntity<String> deletePolicyById(@PathVariable(value = "id") int id){

        try {
            String response = insuranceService.deletePolicyById(id);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
