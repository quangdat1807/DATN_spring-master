package com.example.datn.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="phieunhap")
public class PhieuNhap {
	@Id
	@GeneratedValue
	int pnId;
	double tongtien;
	private Date ngaytao = new Date((new java.util.Date()).getTime());
	
	
	@Override
	public String toString() {
		return "PhieuNhap [pnId=" + pnId + ", tongtien=" + tongtien + ", ngaytao=" + ngaytao + "]";
	}
	public PhieuNhap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhieuNhap(int pnId, double tongtien, Date ngaytao) {
		super();
		this.pnId = pnId;
		this.tongtien = tongtien;
		this.ngaytao = ngaytao;
	}
	public int getPnId() {
		return pnId;
	}
	public void setPnId(int pnId) {
		this.pnId = pnId;
	}
	public double getTongtien() {
		return tongtien;
	}
	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}
	public Date getNgaytao() {
		return ngaytao;
	}
	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}
	
	
}
