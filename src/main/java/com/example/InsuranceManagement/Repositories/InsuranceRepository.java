package com.example.InsuranceManagement.Repositories;

import com.example.InsuranceManagement.Entities.Clients;
import com.example.InsuranceManagement.Entities.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceRepository extends JpaRepository<InsurancePolicy, Integer> {

    @Query("SELECT c FROM InsurancePolicy c")
    List<InsurancePolicy> getAllInsurance();

}
