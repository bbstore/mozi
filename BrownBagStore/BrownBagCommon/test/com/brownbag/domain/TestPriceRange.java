package com.brownbag.domain;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class TestPriceRange {

	@Test
	public void testInvalidConstruction() {
		try {
			new PriceRange<BigDecimal>(null, null);
			fail();
		} catch(IllegalArgumentException e) {
			// Expected
		}
		
		try {
			new PriceRange<BigDecimal>(BigDecimal.ZERO, null);
			fail();
		} catch(IllegalArgumentException e) {
			// Expected
		}

		try {
			new PriceRange<BigDecimal>(null, BigDecimal.ZERO);
			fail();
		} catch(IllegalArgumentException e) {
			// Expected
		}

		try {
			new PriceRange<BigDecimal>(new BigDecimal("1.000000000000001"), BigDecimal.ONE);
			fail();
		} catch(IllegalArgumentException e) {
			// Expected
		}
	}
	
	@Test
	public void testContains() {
		assertFalse(new PriceRange<BigDecimal>(new BigDecimal("0.0"), BigDecimal.ZERO).contains(BigDecimal.ONE));
		
		PriceRange<BigDecimal> priceRangeToTest = new PriceRange<BigDecimal>(new BigDecimal("-10.0"), new BigDecimal("10.0"));
		assertFalse(priceRangeToTest.contains(new BigDecimal("-10.0000001")));
		assertFalse(priceRangeToTest.contains(new BigDecimal("10.0000001")));

		assertTrue(priceRangeToTest.contains(new BigDecimal("-10.000000")));
		assertTrue(priceRangeToTest.contains(new BigDecimal("-9.999999")));
		assertTrue(priceRangeToTest.contains(BigDecimal.ZERO));
		assertTrue(priceRangeToTest.contains(new BigDecimal("10.00000")));

	}
}
