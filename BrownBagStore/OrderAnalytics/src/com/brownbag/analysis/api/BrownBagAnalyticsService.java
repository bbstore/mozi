package com.brownbag.analysis.api;

import java.math.BigDecimal;
import java.util.Set;

import com.brownbag.domain.Order;
import com.brownbag.domain.PriceRange;

public interface BrownBagAnalyticsService {
	
	public Set<Order> ordersWithProductsInThePriceRange(Set<Order> orders, PriceRange<BigDecimal> priceRange);
}
