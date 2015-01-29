package com.harmonic.recruit.pricefeed;

public interface BlockingPriceFeed {

	/**
	 * Immediately returns the latest price available for the specified security.
	 * If no price is available, then null is returned.
	 */
	PriceUpdate getLatestPrice(String securityId);

	/**
	 * Returns the the latest price available for the specified security if it is 
	 * more recent than the last price returned by <bold>either</bold> getLatestPrice or 
	 * waitForNewPrice. Otherwise, this method blocks until the next price update 
	 * for the relevant security.
	 * 
	 * If a price is updated with the same value multiple times in a row, then 
	 * each of these updates is considered new (i.e., it is more recent than the first).
	 * 
	 * If multiple threads are waiting for a new price, then all will return when 
	 * one becomes available.
	 */
	PriceUpdate waitForNewPrice(String securityId);
	
}
