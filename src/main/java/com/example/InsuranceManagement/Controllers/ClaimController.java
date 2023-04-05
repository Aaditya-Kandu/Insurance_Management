package com.example.InsuranceManagement.Controllers;

import com.example.InsuranceManagement.DTOs.ClaimDTO;
import com.example.InsuranceManagement.Entities.Claims;
import com.example.InsuranceManagement.Services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClaimController {

    @Autowired
    ClaimService claimService;



    @PostMapping("/claims")
    public ResponseEntity<String> addClaim(@RequestBody() ClaimDTO claimDTO){
        try {
            String response = claimService.addClaim(claimDTO);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Get all Claims
    @GetMapping("/claims")
    public List<Claims> getAllClaim(){
        return claimService.getAllClaim();
    }

    // Get Claim by Id

    @GetMapping("/claims/{id}")
    public ResponseEntity<Claims> getClaimById(@PathVariable(value = "id") int id){

            Claims claims = claimService.getClaimById(id);
           return new ResponseEntity<>(claims, HttpStatus.ACCEPTED);
        }

    // Claim Updated by id

    @PutMapping("/claims/{id}")
    public ResponseEntity<String> claimUpdatedById(@PathVariable(value = "id") int id, @RequestBody() ClaimDTO claimDTO){
        try {
            String response = claimService.claimUpdateById(id,claimDTO);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/claims/{id}")
    public ResponseEntity<String> claimDeleteById(@PathVariable(value = "id") int id){

        try {
            String response = claimService.claimDeleteById(id);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }

    }
}
