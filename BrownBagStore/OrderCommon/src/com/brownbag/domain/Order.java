package com.brownbag.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Order {

	private String id;
	private List<Product> products;
	private Set<OrderEvent> events;
	private PaymentData paymentData;
	private ShippingData shippingData;
	private CouponData couponData;
	
	private String email;

	public Order(String id) {
		super();
		
		this.id = id;
		this.products = new ArrayList<Product>();
		this.events = new HashSet<OrderEvent>();
	}

	public String getId() {
		return id;
	}
	
	public List<Product> getProducts() {
		return this.products;
	}

	public boolean addProducts(List<Product> products) {
		return products.addAll(products);
	}

	public Order setProducts(List<Product> products) {
		this.products = products;
		return this;
	}

	public boolean removeProdcuts(List<Product> products) {
		return products.removeAll(products);
	}

	public Set<OrderEvent> getEvents() {
		return this.events;
	}

	public boolean addEvents(Set<OrderEvent> events) {
		return this.events.addAll(events);
	}
	
	public Order setEvents(Set<OrderEvent> events) {
		this.events = events;
		return this;
	}

	public boolean removeEvents(Set<OrderEvent> events) {
		return this.events.removeAll(events);
	}
	
	public PaymentData getPaymentData() {
		return paymentData;
	}

	public Order setPaymentData(PaymentData paymentData) {
		this.paymentData = paymentData;
		return this;
	}

	public ShippingData getShippingData() {
		return this.shippingData;
	}

	public Order setShippingData(ShippingData shippingData) {
		this.shippingData = shippingData;
		return this;
	}

	public CouponData getCouponData() {
		return this.couponData;
	}

	public Order setCouponData(CouponData couponData) {
		this.couponData = couponData;
		return this;
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
