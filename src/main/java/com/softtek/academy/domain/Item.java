package com.softtek.academy.domain;

public class Item {
	
	private Long id;
	private String features;
	private String description;
	private Double price;
	private Integer stock;
	private String active;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFeatures() {
		return features;
	}


	public void setFeatures(String features) {
		this.features = features;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}


	public String getActive() {
		return active;
	}


	public void setActive(String active) {
		this.active = active;
	}


	@Override
	public String toString() {
		return "Item [id=" + id + ", features=" + features + ", description=" + description + ", price=" + price
				+ ", stock=" + stock + ", active=" + active + "]";
	}
	
	
	

}
