package com.example.datn.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "productimg")
public class ImgProduct {

    @Id
    @GeneratedValue
    private Long id;


    private String name;

    private String type;

    @JsonIgnore
    @ManyToOne
	@JoinColumn(
			name = "productId",
			nullable = true,
			foreignKey = @ForeignKey(name = "productimg_products"))
	private Product product;


    public ImgProduct() {
    }


    public ImgProduct(Long id, String name, String type, Product product) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.product = product;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public Product getProduct() {
        return product;
    }


    public void setProduct(Product product) {
        this.product = product;
    }
    

    
}
