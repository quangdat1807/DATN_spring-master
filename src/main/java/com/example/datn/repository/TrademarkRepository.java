package com.example.datn.repository;

import com.example.datn.models.ThuongHieu;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrademarkRepository extends JpaRepository<ThuongHieu, Integer> {
    
}
