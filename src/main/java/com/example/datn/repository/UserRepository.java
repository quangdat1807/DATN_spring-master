package com.example.datn.repository;

import java.util.Optional;

import com.example.datn.models.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Page<User> findByUsernameContaining(String user, Pageable pager); 


    User findByEmail(String email);

    User findByToken(String token);
  
    Boolean existsByUsername(String username);
  
    Boolean existsByEmail(String email);


    @Query(value = "select * from users inner join user_roles on users.id = user_roles.user_id where user_id = :user_id and role_id = 3", nativeQuery = true)
    User findByRole(@Param(value = "user_id") Long userId);
  }
