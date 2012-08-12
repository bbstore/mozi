package com.brownbag.domain;

import java.util.Date;

public class OrderEvent implements Comparable<OrderEvent> {
	
	private final Integer id;
	private final OrderStateEnum orderState;
	private final Date createDate;
	
	public OrderEvent(Integer id, OrderStateEnum orderState, Date createDate) {
		super();
		this.id = id;
		this.orderState = orderState;
		this.createDate = createDate;
	}

	public Integer getId() {
		return id;
	}

	public OrderStateEnum getOrderState() {
		return orderState;
	}

	public Date getCreateDate() {
		return createDate;
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
		OrderEvent other = (OrderEvent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(OrderEvent input) {
		return this.id.compareTo(input.id) ;
	}
}
