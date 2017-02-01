package com.softtek.academy.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

@Entity
@Table(name="category")
@NamedNativeQueries({
	@NamedNativeQuery(
			name="findCategoryByItemId",
			query="SELECT c.category_id as id "
					+" FROM category as c "
			+ "   JOIN category_item as  ct   ON c.category_id = ct.category_id "
			+ "JOIN item as i   ON ct.item_id = i.item_id "
			+ "WHERE i.item_id = :id",
			resultSetMapping = "categoryMapping")
	
	
})
@SqlResultSetMappings({
	@SqlResultSetMapping(name="categoryMapping",
			classes= {
					@ConstructorResult(
							targetClass = Category.class,
							columns = {
								@ColumnResult(name = "id", type = Long.class),

							})
			})
})
public class Category implements Serializable{

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	public Category() {
		
	}
	public Category(Long id) {
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="category_id")
	private Long id;
	
	@Column(name="description")
	private String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Category other = (Category) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", description=" + description + "]";
	}
	
	
	
}
