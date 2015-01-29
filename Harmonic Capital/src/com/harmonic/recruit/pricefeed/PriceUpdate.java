package com.harmonic.recruit.pricefeed;

public interface PriceUpdate {

	/**
	 * Returns the id of the security to which this PriceUpdate relates.
	 */
	String getSecurityId();
	
	/**
	 * Returns the price of the security to which this PriceUpdate relates,
	 * at the time of this PriceUpdate.
	 */
	double getPrice();

	/**
	 * Returns the time at which the price changed.
	 */
	long getTime();
}
