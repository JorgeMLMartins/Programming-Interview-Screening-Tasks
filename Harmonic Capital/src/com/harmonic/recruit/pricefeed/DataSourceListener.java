package com.harmonic.recruit.pricefeed;

public interface DataSourceListener {
	/**
	 * Called when a price update is received. 
	 * 
	 * @param securityId The id of the security whose price has updated
	 * @param price The price of the security
	 * @param timestamp The time at which the price changed
	 */
	void priceUpdate(String securityId, double price, long timestamp);
}
