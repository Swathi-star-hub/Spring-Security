package com.example.BackendCrud.DAO;

import com.example.BackendCrud.entity.FamilyDtls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicDetailsDAO  {
    public FamilyDtls getFamilyDtlsBymebId(Integer mebId);
}
