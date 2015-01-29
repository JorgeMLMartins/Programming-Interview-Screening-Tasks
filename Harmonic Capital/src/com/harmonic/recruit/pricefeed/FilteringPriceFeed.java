package com.harmonic.recruit.pricefeed;

public interface FilteringPriceFeed {

	/**
	 * Adds a listener for a specific security. 
	 * When this method has returned, the registered listener will receive 
	 * all price updates for the specified security, until cancelled by a 
	 * call to removeListener.
	 */
	void addListener(String securityId, PriceListener listener);
	
	/**
	 * Removes a listener for a specific security.
	 * The registered listener will receive no further updates for the 
	 * relevant security after this method returns, but will continue to 
	 * receive updates for any other securities for which it is 
	 * registered (if any).
	 */
	void removeListener(String securityId, PriceListener listener);

	/**
	 * Immediately returns the latest price available for the specified security.
	 * If no price is available, then null is returned.
	 */
	PriceUpdate getLatestPrice(String securityId);
	
}
