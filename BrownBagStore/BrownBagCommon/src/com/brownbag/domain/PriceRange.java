package com.brownbag.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PriceRange<T extends Comparable<T>> {
	
	private final T from;
	private final T to;
	
	public PriceRange(T from, T to) {
		if( from == null || to == null ) {
			throw new IllegalArgumentException("Null Data: " + this);
		}
		
		if( from.compareTo(to) > 0) {
			throw new IllegalArgumentException("Invalid Data. From is greater than To value:" + this);
		}
		
		this.from = from;
		this.to = to;
	}
	
	public boolean contains(T data) {
		if(data == null) {
			throw new IllegalArgumentException("Null data");
		}
		
		return from.compareTo(data) <= 0 && to.compareTo(data) >= 0;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
