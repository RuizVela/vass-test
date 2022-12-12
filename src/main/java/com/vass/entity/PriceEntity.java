package com.vass.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRICES")
public class PriceEntity {

	@Id
	@Column(name = "PRICE_ID")
	private Long id;
	@Column(name = "BRAND_ID", nullable = false)
	private Integer brand;
	@Column(name = "START_DATE")
	private LocalDateTime startDate;
	@Column(name = "END_DATE")
	private LocalDateTime endDate;
	@Column(name = "PRICE_LIST")
	private Integer priceList;
	@Column(name = "PRODUCT_ID")
	private Integer productId;
	@Column(name = "PRIORITY")
	private Integer priority;
	@Column(name = "PRICE")
	private Double price;
	@Column(name = "CURR")
	private String curr;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getBrand() {
		return brand;
	}
	public void setBrand(Integer brand) {
		this.brand = brand;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public Integer getPriceList() {
		return priceList;
	}
	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCurr() {
		return curr;
	}
	public void setCurr(String curr) {
		this.curr = curr;
	}

	
}
