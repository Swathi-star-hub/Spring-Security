package com.example.BackendCrud.repo;

import com.example.BackendCrud.entity.FamilyDtls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicDetailsRepo extends JpaRepository<FamilyDtls,Integer> {
}
