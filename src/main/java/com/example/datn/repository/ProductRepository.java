package com.example.datn.repository;

import java.util.List;
import java.util.Optional;

import com.example.datn.models.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
    Page<Product> findByTensanphamContainingIgnoreCase(String name, Pageable pager);


    @Query(value = "select * from products pr where thuonghieu_id = 1 and category_id = 1 Limit 6", nativeQuery = true)
    List<Product> findByTitleContaining();

    @Query(value = "select * from products pr where thuonghieu_id = 2 and category_id = 1 Limit 6", nativeQuery = true)
    List<Product> findByTrade();

    //@Query(value = "select * from products where seourl like ?1 ", nativeQuery = true)
    Optional<Product> findBySeourlContaining(String name);

    @Query(value = "select *  from products inner join thuonghieu on products.thuonghieu_id = thuonghieu.idth where tenth iLIKE %:name% and products.gia between :giamin and :giamax", nativeQuery = true)
    Page<Product> findByTradeMake(@Param(value = "name") String name, @Param(value = "giamin") Long giamin, @Param(value = "giamax") Long giamax, Pageable pager );


    @Query(value = "Select * from products where gia between :giamin and :giamax", nativeQuery = true)
    Page<Product> findProductAll(@Param(value = "giamin") Long giamin, @Param(value = "giamax") Long giamax, Pageable pager );

    @Query(value = "select *  from products p inner join categories c on p.category_id = c.category_id where c.seourl iLIKE %:seourl% and p.gia between :giamin and :giamax", nativeQuery = true)
    Page<Product> findCategory(@Param(value = "seourl") String seourl, @Param(value = "giamin") Long giamin, @Param(value = "giamax") Long giamax, Pageable pager );

    @Query(value = "select *  from products p inner join categories c on p.category_id = c.category_id" +
    " inner join thuonghieu th on p.thuonghieu_id = th.idth"+
    " where c.seourl iLIKE  %:seourl% and th.tenth iLike %:tenth% and p.gia between :giamin and :giamax", nativeQuery = true)
    Page<Product> findCategoryAndTrademake(@Param(value = "seourl") String seourl, @Param(value = "tenth") String tenth, @Param(value = "giamin") Long giamin, @Param(value = "giamax") Long giamax, Pageable pager );


    @Query(value = "Select * from products where category_id = :idcate and thuonghieu_id = :idth Limit 6", nativeQuery = true)
    List<Product> findByRelatedProduct(@Param(value = "idth") int idth, @Param(value = "idcate") int idcate);
}
