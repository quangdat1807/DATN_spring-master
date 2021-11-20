package com.example.datn.repository;


import java.util.Optional;

import com.example.datn.models.RefreshToken;
import com.example.datn.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
  
    @Modifying
    int deleteByUser(User user);
  }
