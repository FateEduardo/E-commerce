package com.softtek.academy.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CartDetails {
	
	@Column(name = "shipping_amount")
	private Double shippingAmount;
	
	@Column(name = "cart_amount")
	private Double cartAmount;
	private Boolean staus;
	private ShipTo shipTo;
	private Payment payment;
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
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartAmount == null) ? 0 : cartAmount.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result + ((shipTo == null) ? 0 : shipTo.hashCode());
		result = prime * result + ((shippingAmount == null) ? 0 : shippingAmount.hashCode());
		result = prime * result + ((staus == null) ? 0 : staus.hashCode());
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
		CartDetails other = (CartDetails) obj;
		if (cartAmount == null) {
			if (other.cartAmount != null)
				return false;
		} else if (!cartAmount.equals(other.cartAmount))
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
		return true;
	}
	@Override
	public String toString() {
		return "CartDetails [shippingAmount=" + shippingAmount + ", cartAmount=" + cartAmount + ", staus=" + staus
				+ ", shipTo=" + shipTo + ", payment=" + payment + "]";
	}
	
	
	
}
