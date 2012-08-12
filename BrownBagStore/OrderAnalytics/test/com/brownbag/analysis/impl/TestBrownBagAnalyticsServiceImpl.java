package com.brownbag.analysis.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.brownbag.analysis.api.BrownBagAnalyticsService;
import com.brownbag.domain.Order;
import com.brownbag.domain.OrderEvent;
import com.brownbag.domain.PriceRange;
import com.brownbag.domain.Product;

public class TestBrownBagAnalyticsServiceImpl {
	
	private BrownBagAnalyticsService service;
	
	@Before
	public void setUp() {
		service = new BrownBagAnalyticsServiceImpl();
	}

	@Test
	public void testOrdersWithProductsInThePriceRangeWithInvalidData() {
		try {
			service.ordersWithProductsInThePriceRange(null, null);
			fail();
		} catch (IllegalArgumentException e) {
			// expected
		}

		try {
			service.ordersWithProductsInThePriceRange(new HashSet<Order>(), null);
			fail();
		} catch (IllegalArgumentException e) {
			// expected
		}
	}
	
	@Test
	public void testOrdersWithProductsInThePriceRangeWithoutMatch() {
		Set<Order> orders = new HashSet<Order>();
		Product product1 = new Product("id1", "staple", new BigDecimal("1.25"));
		Set<OrderEvent> events = new HashSet<OrderEvent>();

		assertEquals(0, service.ordersWithProductsInThePriceRange(orders, new PriceRange<BigDecimal>(BigDecimal.ZERO, BigDecimal.ZERO)).size());

		orders.add(new Order("order1").setProducts(Arrays.asList(product1)).setEvents(events));
		
		assertEquals(0, service.ordersWithProductsInThePriceRange(orders, new PriceRange<BigDecimal>(new BigDecimal("-1.25"), BigDecimal.ZERO)).size());
		assertEquals(0, service.ordersWithProductsInThePriceRange(orders, new PriceRange<BigDecimal>(BigDecimal.ZERO, BigDecimal.ZERO)).size());
		assertEquals(0, service.ordersWithProductsInThePriceRange(orders, new PriceRange<BigDecimal>(new BigDecimal("0.0"), new BigDecimal("1.24"))).size());
		assertEquals(0, service.ordersWithProductsInThePriceRange(orders, new PriceRange<BigDecimal>(new BigDecimal("1.26"), new BigDecimal(Long.MAX_VALUE))).size());
	}
	
	@Test
	public void testOrdersWithProductsInThePriceRangeWithtMatch() {
		Set<Order> orders = new HashSet<Order>();
		Product product1 = new Product("id1", "staple", new BigDecimal("1.25"));
		Product product2 = new Product("id2", "book", new BigDecimal("1.50"));
		Product product3 = new Product("id3", "CD", new BigDecimal("2.50"));

		orders.add(new Order("order1").setProducts(Arrays.asList(product1)));
		assertEquals(1, service.ordersWithProductsInThePriceRange(orders, new PriceRange<BigDecimal>(new BigDecimal("1.00"), new BigDecimal("1.75"))).size());
	
		// More than one product matches the range
		orders.add(new Order("order2").setProducts(Arrays.asList(product1, product2)));
		assertEquals(2, service.ordersWithProductsInThePriceRange(orders, new PriceRange<BigDecimal>(new BigDecimal("1.00"), new BigDecimal("1.75"))).size());
		
		// Multiple units of the same product
		orders.add(new Order("order3").setProducts(Arrays.asList(product2, product2, product2)));
		orders.add(new Order("order4").setProducts(Arrays.asList(product3)));
		assertEquals(4, service.ordersWithProductsInThePriceRange(orders, new PriceRange<BigDecimal>(new BigDecimal("1.00"), new BigDecimal("2.75"))).size());
		assertEquals(3, service.ordersWithProductsInThePriceRange(orders, new PriceRange<BigDecimal>(new BigDecimal("1.00"), new BigDecimal("1.75"))).size());
		assertEquals(2, service.ordersWithProductsInThePriceRange(orders, new PriceRange<BigDecimal>(new BigDecimal("1.26"), new BigDecimal("1.5"))).size());
		assertEquals(1, service.ordersWithProductsInThePriceRange(orders, new PriceRange<BigDecimal>(new BigDecimal("2.00"), new BigDecimal("2.50"))).size());
	}
	
}
