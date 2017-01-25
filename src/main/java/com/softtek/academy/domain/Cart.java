package com.softtek.academy.domain;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;

public class Cart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CartKey id;
	
	@Embedded
	private CartDetails details;
	
	public CartKey getId() {
		return id;
	}
	public void setId(CartKey id) {
		this.id = id;
	}
	public CartDetails getDetails() {
		return details;
	}
	public void setDetails(CartDetails details) {
		this.details = details;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((details == null) ? 0 : details.hashCode());
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
		Cart other = (Cart) obj;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
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
		return "Cart [id=" + id + ", details=" + details + "]";
	}
	
	
	
	
	
	
	
	
}
