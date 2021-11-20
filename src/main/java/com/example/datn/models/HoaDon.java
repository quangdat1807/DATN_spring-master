package com.example.datn.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "hoadon")
@Entity
public class HoaDon {
	
	@Id
	@GeneratedValue
	int idhoadon;
	double tongtien;
	private Date ngaytao = new Date((new java.util.Date()).getTime());
	
	
	
	@Override
	public String toString() {
		return "HoaDon [idhoadon=" + idhoadon + ", tongtien=" + tongtien + ", ngaytao=" + ngaytao + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(idhoadon, ngaytao, tongtien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return idhoadon == other.idhoadon && Objects.equals(ngaytao, other.ngaytao)
				&& Double.doubleToLongBits(tongtien) == Double.doubleToLongBits(other.tongtien);
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(int idhoadon, double tongtien, Date ngaytao) {
		super();
		this.idhoadon = idhoadon;
		this.tongtien = tongtien;
		this.ngaytao = ngaytao;
	}
	public int getIdhoadon() {
		return idhoadon;
	}
	public void setIdhoadon(int idhoadon) {
		this.idhoadon = idhoadon;
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
