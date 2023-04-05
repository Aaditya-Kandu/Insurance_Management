package com.example.InsuranceManagement.Repositories;

import com.example.InsuranceManagement.Entities.Claims;
import com.example.InsuranceManagement.Entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<Claims, Integer> {

    @Query("SELECT c FROM Claims c")
    List<Claims> getAllClaims();
}
