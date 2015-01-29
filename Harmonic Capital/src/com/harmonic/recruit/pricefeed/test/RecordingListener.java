package com.harmonic.recruit.pricefeed.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import com.harmonic.recruit.pricefeed.PriceListener;
import com.harmonic.recruit.pricefeed.PriceUpdate;

/**
 * A PriceListener that may be useful for testing.
 * <p>
 * Records updates in a BlockingQueue so should be used carefully, could cause callers to block.
 * 
 */
public class RecordingListener implements PriceListener {

	private final BlockingQueue<PriceUpdate> updates;
	
	private final long pollTimeout = 5;
	private TimeUnit pollTimeUnit = TimeUnit.SECONDS;
	
	public RecordingListener(int capacity) {
		 updates = new ArrayBlockingQueue<PriceUpdate>(capacity, true);
	}
	
	/**
	 * Puts an update on the blocking queue, will block while queue is full.
	 */
	@Override
	public void priceUpdated(PriceUpdate priceUpdate) {
		try {
			updates.put(priceUpdate);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean hasUpdate() {
		return !updates.isEmpty();
	}

	/**
	 * Gets the next update from the queue waiting for a time if one is not available.
	 */
	public PriceUpdate getUpdate() {
		try {
			return updates.poll(pollTimeout, pollTimeUnit);
		} catch (InterruptedException e) {
			return null;
		}
	}
	
}
