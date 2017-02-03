package com.softtek.academy.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="item")
@NamedNativeQueries({
	@NamedNativeQuery(
			name="findItemByCategory",
			query="SELECT i.item_id as id, "
					+ "i.features as features,"
					+ "i.description as description, "
					+ "i.unit_price as price, "
					+ "i.stock as stock "
					+" FROM item as i "
			+ "   JOIN category_item as  ct   ON i.item_id = ct.item_id "
			+ "JOIN category as c   ON ct.category_id = c.category_id "
			+ "WHERE c.description = :description",
			resultSetMapping = "itemMapping")
	
	
})
@SqlResultSetMappings({
	@SqlResultSetMapping(name="itemMapping",
			classes= {
					@ConstructorResult(
							targetClass = ItemEntity.class,
							columns = {
								@ColumnResult(name = "id", type = Long.class),
								@ColumnResult(name = "features", type = String.class),
								@ColumnResult(name = "description", type = String.class),
								@ColumnResult(name = "price", type = Double.class),
								@ColumnResult(name = "stock", type = Integer.class),

							})
			})
})
public class ItemEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="ORDEN_SEQ")
	@TableGenerator(name="ORDEN_SEQ",table="tsequence",
	pkColumnName="seq_name",valueColumnName="seq_acount",
	pkColumnValue="ITEM",allocationSize=5)
	@Column(name="item_id")
	private Long item_id;
	
	@Column(name="features")
	private String features;
	
	@Column(name="description")
	private String description;
	
	@Column(name="unit_price")
	private Double price;
	
	@Column(name="stock")
	private Integer stock;
	
	@Column(name="active")
	@Convert(converter=StausToBoolean.class)
	private Boolean active;
	
	public ItemEntity(Long id, String features, String description, Double price, Integer stock) {
		this.item_id = id;
		this.features = features;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}
	
	
	
	public ItemEntity() {
	}





	public Long getId() {
		return item_id;
	}


	public void setId(Long id) {
		this.item_id = id;
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


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}


	@Override
	public String toString() {
		return "Item [id=" + item_id + ", features=" + features + ", description=" + description + ", price=" + price
				+ ", stock=" + stock + ", active=" + active + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((features == null) ? 0 : features.hashCode());
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemEntity other = (ItemEntity) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (features == null) {
			if (other.features != null)
				return false;
		} else if (!features.equals(other.features))
			return false;
		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		return true;
	}
	
	
	

}
