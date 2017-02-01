package com.softtek.academy.domain;

import java.io.Serializable;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

@Entity
@Table(name="category_item")
@NamedNativeQueries({
	@NamedNativeQuery(
			name="findCategoryItemByItemId",
			query="SELECT c.item_id as id, "
					+ "c.category_id as category"
					+" FROM category_item as c "
			+ "WHERE c.item_id = :item",
			resultSetMapping = "categoryItemMapping"),
	
	@NamedNativeQuery(
			name="deleteCategoryItem",
			query="DELETE"
					+" FROM category_item as c "
			+ "WHERE c.item_id = :id",
			resultSetMapping = "delete")
	
})
@SqlResultSetMappings({
	@SqlResultSetMapping(name="categoryItemMapping",
			classes= {
					@ConstructorResult(
							targetClass = CategoryItem.class,
							columns = {
								@ColumnResult(name = "id", type = Long.class),
								@ColumnResult(name = "category", type = Long.class),
				

							})
			}),
	@SqlResultSetMapping(name="delete",
	classes= {
			@ConstructorResult(
					targetClass = CategoryItem.class,
					columns = {
						@ColumnResult(name = "count"),
						
		

					})
	})
})
public class CategoryItem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private CategoryKey id;

	public CategoryItem(){
		
	}
	public CategoryItem(Long id,Long category){
		this.id=new CategoryKey(id, category);
	}


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
		CategoryItem other = (CategoryItem) obj;
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
