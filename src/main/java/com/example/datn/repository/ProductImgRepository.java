package com.example.datn.repository;

import java.util.List;
import java.util.Optional;

import com.example.datn.models.ImgProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductImgRepository extends JpaRepository<ImgProduct, Long> {
    

    @Query(value = "select * from productimg where product_id= ?1", nativeQuery = true)
    List<ImgProduct> findByProductId(Long id);
}
