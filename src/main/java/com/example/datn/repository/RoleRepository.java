package com.example.datn.repository;

import java.util.Optional;

import com.example.datn.models.ERole;
import com.example.datn.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
  }
