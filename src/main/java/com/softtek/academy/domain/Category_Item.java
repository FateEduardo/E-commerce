package com.softtek.academy.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="category_item")
public class Category_Item implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private CategoryKey id;


	public CategoryKey getId() {
		return id;
	}

	public void setId(CategoryKey id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Category_Item other = (Category_Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category_Item [id=" + id + "]";
	}
	
	
}
