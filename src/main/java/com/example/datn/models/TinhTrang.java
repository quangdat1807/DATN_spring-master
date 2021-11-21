package com.example.datn.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "tinhtrangdonhang")
@Entity
public class TinhTrang {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY
			, mappedBy = "tinhtrang")
	private List<HoaDon> hoadon;

	

    public TinhTrang() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TinhTrang(int id, String name, List<HoaDon> hoadon) {
		super();
		this.id = id;
		this.name = name;
		this.hoadon = hoadon;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public List<HoaDon> getHoadon() {
		return hoadon;
	}



	public void setHoadon(List<HoaDon> hoadon) {
		this.hoadon = hoadon;
	}	
	
}
