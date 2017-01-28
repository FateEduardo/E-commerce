package com.softtek.academy.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name = "cart")
public class Cart extends Audit implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@TableGenerator(name="ORDEN_SEQ",table="tsequence",
	pkColumnName="seq_name",valueColumnName="seq_acount",
	pkColumnValue="CART",allocationSize=1)
	@Column(name="cart_id")
	private Long id;
	
	@Column(name = "shipping_amount")
	private Double shippingAmount;
	
	@Column(name = "cart_amount")
	private Double cartAmount;
	
	@Column(name = "active")
	//@Convert(converter=StausToBoolean.class)
	private Boolean staus;
	
	@ManyToOne
	@JoinColumn(name = "ship_to_id")
	private ShipTo shipTo;
	
	@ManyToOne
	@JoinColumn(name = "payment_id")
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

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cartAmount == null) ? 0 : cartAmount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", shippingAmount=" + shippingAmount + ", cartAmount=" + cartAmount + ", staus="
				+ staus + ", shipTo=" + shipTo + ", payment=" + payment + "]";
	}
	
	
	
	
	
	
	
	
	
}
