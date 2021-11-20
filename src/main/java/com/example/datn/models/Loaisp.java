package com.example.datn.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name = "loaisanpham")
public class Loaisp {

    @Id
	@GeneratedValue
	private int idlsp;
	@NotNull
	@Size(min = 3, max = 50)
	private String tenlsp;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY
			, mappedBy = "loaisanpham")
	private List<Product> products;

	public Loaisp() {
	}

	public Loaisp(int idlsp, @NotNull @Size(min = 3, max = 50) String tenlsp, List<Product> products) {
		this.idlsp = idlsp;
		this.tenlsp = tenlsp;
		this.products = products;
	}

	public int getIdlsp() {
		return idlsp;
	}

	public void setIdlsp(int idlsp) {
		this.idlsp = idlsp;
	}

	public String getTenlsp() {
		return tenlsp;
	}

	public void setTenlsp(String tenlsp) {
		this.tenlsp = tenlsp;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
	
	
	


	

	
    
}
