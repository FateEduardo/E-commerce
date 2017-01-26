package com.softtek.academy.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="item")
public class Item implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="ORDEN_SEQ")
	@TableGenerator(name="ORDEN_SEQ",table="tsequence",
	pkColumnName="seq_name",valueColumnName="seq_acount",
	pkColumnValue="ITEM",allocationSize=1)
	@Column(name="item_id")
	private Long id;
	
	@Column(name="features")
	private String features;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="stock")
	private Integer stock;
	
	@Column(name="active")
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
