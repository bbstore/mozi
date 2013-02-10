package com.brownbag.api;

/**
 * TODO
 * 
 * @author Manjuram
 *
 */
public interface OrderManagementService {
	public void createOrder(Stirng symbol, int quantity, BigDecimal money);

	public void cancelOrder(String orderNo);

}
