package com.example.datn.repository;

import java.util.List;

import com.example.datn.models.MessageNotifications;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



public interface MessageNotificationsRepository extends JpaRepository<MessageNotifications, Long> {
    
}
