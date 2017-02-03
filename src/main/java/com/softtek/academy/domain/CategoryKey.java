package com.softtek.academy.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CategoryKey implements Serializable{
	
	/**
	 * 
	 */
	public CategoryKey(Long id,Long category){
		this.id=new CategoryEntity();
		this.id.setId(category);
		this.item=new ItemEntity();
		item.setId(id);
	}
	public CategoryKey(){
		
	}
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="category_id")
	private CategoryEntity id;
	
	@ManyToOne
	@JoinColumn(name="item_id")
	private ItemEntity item;
	

	public CategoryEntity getId() {
		return id;
	}
	public void setId(CategoryEntity id) {
		this.id = id;
	}
	public ItemEntity getItem() {
		return item;
	}
	public void setItem(ItemEntity item) {
		this.item = item;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
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
		CategoryKey other = (CategoryKey) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CategoryKey [id=" + id + ", item=" + item + "]";
	}
	
	
}
