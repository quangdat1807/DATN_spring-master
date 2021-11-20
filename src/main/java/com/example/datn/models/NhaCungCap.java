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


@Entity(name="nhacungcap")
public class NhaCungCap {
    @Id
	@GeneratedValue
	private int idNCC;
	@NotNull
	@Size(min = 3, max = 50)
	private String tenNCC;
	
	private String diaChi;
	
	private double sdt;
	
	private String gmail;
	
	private String mtk;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY
			, mappedBy = "nhacungcap")
	private List<Product> product;

	public NhaCungCap() {
		super();
	}

	public NhaCungCap(int idNCC, @NotNull @Size(min = 3, max = 50) String tenNCC, String diaChi, double sdt,
			String gmail, String mtk, List<Product> product) {
		super();
		this.idNCC = idNCC;
		this.tenNCC = tenNCC;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.gmail = gmail;
		this.mtk = mtk;
		this.product = product;
	}

	public int getIdNCC() {
		return idNCC;
	}

	public void setIdNCC(int idNCC) {
		this.idNCC = idNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public double getSdt() {
		return sdt;
	}

	public void setSdt(double sdt) {
		this.sdt = sdt;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getMtk() {
		return mtk;
	}

	public void setMtk(String mtk) {
		this.mtk = mtk;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
}
