package com.brownbag.domain;

import java.math.BigDecimal;

/**
 * Represents a product that's sold by Brown Bag Store
 * 
 * @author manjuram
 *
 */
public class Product {

	private final String id;
	private final String description;
	private final BigDecimal price;
	
	public Product(String id, String description, BigDecimal price) {
		this.id = id;
		this.description = description;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description
				+ ", price=" + price + "]";
	}
}
