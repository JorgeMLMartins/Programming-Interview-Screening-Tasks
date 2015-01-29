package com.harmonic.recruit.pricefeed.test;

import com.harmonic.recruit.pricefeed.DataSourceListener;
import com.harmonic.recruit.pricefeed.FilteringPriceFeed;
import com.harmonic.recruit.pricefeed.PriceUpdate;


public class TestSecurityPriceFeed {

	public static FilteringPriceFeed getPriceFeed() {
		//TODO return an instance of your class
		return null;
	}
	
	public static void main(String[] args) {
		FilteringPriceFeed priceFeed = getPriceFeed();
		DataSourceListener dsListener = (DataSourceListener) priceFeed;
		
		// add a listener for BBB
		RecordingListener listener = new RecordingListener(1);
		priceFeed.addListener("BBB", listener);
		
		//provide an update for AAA, the BBB listener should not be updated
		dsListener.priceUpdate("AAA", 100.0, 1L);
		if (listener.hasUpdate()) {
			throw new IllegalStateException();
		}
		
		//provide an update for BBB, the BBB listener should be updated eventually
		dsListener.priceUpdate("BBB", 95.0, 2L);
		PriceUpdate update = listener.getUpdate(); // NB this waits for upto 5 seconds by default
		if (update == null || update.getPrice() != 95.0 || update.getTime() != 2L || !update.getSecurityId().equals("BBB")) {
			throw new IllegalStateException();
		}
		
		//provide an update for BBB, the BBB listener should be updated eventually
		dsListener.priceUpdate("BBB", 97.5, 3L);
		update = listener.getUpdate();
		if (update == null || update.getPrice() != 97.5 || update.getTime() != 3L || !update.getSecurityId().equals("BBB")) {
			throw new IllegalStateException();
		}
		
		System.out.println("Done. All tests passed!");
		System.exit(0); // Do a system exit here because PriceFeed may have created some threads that are still running
	}

}
