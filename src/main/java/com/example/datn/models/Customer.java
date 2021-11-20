package com.example.datn.models;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "khachhang")
public class Customer {
    @Id
	@GeneratedValue
	private int id;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private User user;
	
    @NotBlank
	@Size(max = 35)
	private String hoten;
	
	@NotBlank
	@Size(max = 150)
	private String diachi;
	
	
	private String sdt;

	// @OneToMany(fetch = FetchType.LAZY
	// 		, mappedBy = "custommer")
	// private List<Order> order;

	public Customer() {
	}

	public Customer(int id, User user, @NotBlank @Size(max = 35) String hoten, @NotBlank @Size(max = 150) String diachi,
			@Size(max = 10) @Null String sdt) {
		this.id = id;
		this.user = user;
		this.hoten = hoten;
		this.diachi = diachi;
		this.sdt = sdt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	


	
}
