package com.example.datn.repository;

import com.example.datn.models.Order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order>  findByPhoneNumberContaining(String phoneNumber, Pageable pager);
}
