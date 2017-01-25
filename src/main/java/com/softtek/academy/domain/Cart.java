package com.softtek.academy.domain;

public class Cart {
	
	private Long id;
	private User user;
	private Double shippingAmount;
	private Double cartAmount;
	private Boolean staus;
	private ShipTo shipTo;
	private Audit audit;
	private Payment payment;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getShippingAmount() {
		return shippingAmount;
	}
	public void setShippingAmount(Double shippingAmount) {
		this.shippingAmount = shippingAmount;
	}
	public Double getCartAmount() {
		return cartAmount;
	}
	public void setCartAmount(Double cartAmount) {
		this.cartAmount = cartAmount;
	}
	public Boolean getStaus() {
		return staus;
	}
	public void setStaus(Boolean staus) {
		this.staus = staus;
	}
	public ShipTo getShipTo() {
		return shipTo;
	}
	public void setShipTo(ShipTo shipTo) {
		this.shipTo = shipTo;
	}
	public Audit getAudit() {
		return audit;
	}
	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((audit == null) ? 0 : audit.hashCode());
		result = prime * result + ((cartAmount == null) ? 0 : cartAmount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result + ((shipTo == null) ? 0 : shipTo.hashCode());
		result = prime * result + ((shippingAmount == null) ? 0 : shippingAmount.hashCode());
		result = prime * result + ((staus == null) ? 0 : staus.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (audit == null) {
			if (other.audit != null)
				return false;
		} else if (!audit.equals(other.audit))
			return false;
		if (cartAmount == null) {
			if (other.cartAmount != null)
				return false;
		} else if (!cartAmount.equals(other.cartAmount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		if (shipTo == null) {
			if (other.shipTo != null)
				return false;
		} else if (!shipTo.equals(other.shipTo))
			return false;
		if (shippingAmount == null) {
			if (other.shippingAmount != null)
				return false;
		} else if (!shippingAmount.equals(other.shippingAmount))
			return false;
		if (staus == null) {
			if (other.staus != null)
				return false;
		} else if (!staus.equals(other.staus))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", shippingAmount=" + shippingAmount + ", cartAmount=" + cartAmount + ", staus="
				+ staus + ", shipTo=" + shipTo + ", audit=" + audit + ", payment=" + payment + ", user=" + user + "]";
	}

	
	
	
	
	
}
