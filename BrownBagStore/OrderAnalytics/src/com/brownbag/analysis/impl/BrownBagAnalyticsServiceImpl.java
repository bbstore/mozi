package com.brownbag.analysis.impl;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.brownbag.domain.Order;
import com.brownbag.domain.PriceRange;
import com.brownbag.domain.Product;

import com.brownbag.analysis.api.BrownBagAnalyticsService;

public class BrownBagAnalyticsServiceImpl implements BrownBagAnalyticsService {

	@Override
	public Set<Order> ordersWithProductsInThePriceRange(Set<Order> orders, PriceRange<BigDecimal> priceRange) {
		if(orders == null || priceRange == null) {
			throw new IllegalArgumentException("Null data: " + orders + " " + priceRange);
		}

		Set<Order> result = new HashSet<Order>();
		
		// Build set of orders that contain product(s) that are in the price range
		for(Order order: orders) {
			for(Product product: order.getProducts()) {
				if(priceRange.contains(product.getPrice())) {
					result.add(order);
					break;
				}
			}
		}		
		
		return result;
	}

}
