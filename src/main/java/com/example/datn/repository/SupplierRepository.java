package com.example.datn.repository;

import com.example.datn.models.NhaCungCap;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<NhaCungCap, Integer> {
    
}
