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


@Entity(name = "thuonghieu")
public class ThuongHieu {

    @Id
	@GeneratedValue
	private int idTH;
	@NotNull
	@Size(min = 3, max = 50)
	private String tenTH;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY
			, mappedBy = "thuonghieu")
	private List<Product> products;

	
	
	public ThuongHieu() {
	}

	public ThuongHieu(int idTH, @NotNull @Size(min = 3, max = 50) String tenTH, List<Product> products) {
		this.idTH = idTH;
		this.tenTH = tenTH;
		this.products = products;
	}

	public int getIdTH() {
		return idTH;
	}

	public void setIdTH(int idTH) {
		this.idTH = idTH;
	}

	public String getTenTH() {
		return tenTH;
	}

	public void setTenTH(String tenTH) {
		this.tenTH = tenTH;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	


	

	
    
}
