package com.example.BackendCrud.repo;


import com.example.BackendCrud.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserInfoRepo extends JpaRepository<UserCredential,Integer> {
    Optional<UserCredential> findByName(String username);
}
