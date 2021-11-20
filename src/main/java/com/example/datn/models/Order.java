package com.example.datn.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="orders")
public class Order {

    @Id
    private Long orderId;


    @NotNull
	private Date createdDate = new Date((new java.util.Date()).getTime());


    @NotBlank
	@Size(max = 50)
	private String province;


    @NotBlank
	@Size(max = 50)
	private String district;

    @NotBlank
	@Size(max = 50)
	private String ward;

    @NotBlank
	@Size(max = 150)
	private String address;

    @NotBlank
	@Size(max = 10)
	private String phoneNumber;

    
    @DecimalMin(value = "0.00", message = "*Price has to be non negative number")
    private BigDecimal total;


	private String email;


	private String fullName;


	private String note;
    

    @ManyToOne
	@JoinColumn(name = "customer_Id", nullable = true, foreignKey = @ForeignKey(name = "customer_order"))
	Customer customer;

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderDetail> order_items;


	public Order() {
	}


	


	public Order(Long orderId, @NotNull Date createdDate, @NotBlank @Size(max = 50) String province,
			@NotBlank @Size(max = 50) String district, @NotBlank @Size(max = 50) String ward,
			@NotBlank @Size(max = 150) String address, @NotBlank @Size(max = 10) String phoneNumber,
			@DecimalMin(value = "0.00", message = "*Price has to be non negative number") BigDecimal total,
			String email, String fullName, String note, Customer customer, List<OrderDetail> order_items) {
		this.orderId = orderId;
		this.createdDate = createdDate;
		this.province = province;
		this.district = district;
		this.ward = ward;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.total = total;
		this.email = email;
		this.fullName = fullName;
		this.note = note;
		this.customer = customer;
		this.order_items = order_items;
	}





	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getWard() {
		return ward;
	}


	public void setWard(String ward) {
		this.ward = ward;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public Customer getCustomer() {
		return customer;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<OrderDetail> getOrder_items() {
		return order_items;
	}


	public void setOrder_items(List<OrderDetail> order_items) {
		this.order_items = order_items;
	}

}
