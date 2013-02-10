package com.brownbag.api;

/**
 * TODO
 * 
 * @author Manjuram
 *
 */
public interface OrderManagementService {
	public String createOrder(Stirng symbol, int quantity, BigDecimal money);
	public void modifyOrder	(Stirng orderNo, int quantity, BigDecimal money);

	public void cancelOrder(String orderNo);

}
