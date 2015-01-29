package com.harmonic.recruit.pricefeed.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.harmonic.recruit.pricefeed.BlockingPriceFeed;
import com.harmonic.recruit.pricefeed.DataSourceListener;
import com.harmonic.recruit.pricefeed.PriceUpdate;

public class TestBlockingFeed {

	private static BlockingPriceFeed getBlockingPriceFeed() {
		//TODO return an instance of your class
		return null;
	}
	
	/**
	 * Class that implements Callable (to return a Future) and waits for a new price on a BlockingPriceFeed
	 *
	 */
	private static class PriceClient implements Callable<PriceUpdate> {
		
		private final BlockingPriceFeed feed;
		private final String securityId;
		
		public PriceClient(BlockingPriceFeed feed, String securityId) {
			super();
			this.feed = feed;
			this.securityId = securityId;
		}

		@Override
		public PriceUpdate call() {
			return feed.waitForNewPrice(securityId);
		}
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService exec = Executors.newCachedThreadPool();
		
		BlockingPriceFeed blockingFeed = getBlockingPriceFeed();
		DataSourceListener dsListener = (DataSourceListener) blockingFeed;
		
		// create a new thread waiting for a price update for security AAA
		PriceClient aaaClient = new PriceClient(blockingFeed, "AAA");
		Future<PriceUpdate> waitResult = exec.submit(aaaClient);
		
		// having not provided any prices for AAA yet the thread above should still be waiting
		sleep(2);
		if (waitResult.isDone()) {
			throw new IllegalStateException("Stopped waiting for AAA despite having not provided a price");
		}
		
		// give a price for BBB, should still be waiting for AAA a couple of seconds later
		dsListener.priceUpdate("BBB", 101, 1L);
		sleep(2);
		if (waitResult.isDone()) {
			throw new IllegalStateException("Stopped waiting for AAA despite having not provided a price");
		}
		
		//give a price for AAA, expect the blocking feed to receive an update within 5 seconds
		dsListener.priceUpdate("AAA", 120, 2L);
		PriceUpdate update = waitResult.get(5, TimeUnit.SECONDS);
		if (update == null || update.getPrice() != 120 || update.getTime() != 2L) {
			throw new IllegalStateException("Failed to get correct price update, received " + update);
		}
		
		// start waiting for BBB, as we have provided a price for BBB and not called getPrice this shouldn't block
		PriceClient bbbClient = new PriceClient(blockingFeed, "BBB");
		waitResult = exec.submit(bbbClient);
		update = waitResult.get(5, TimeUnit.SECONDS);
		if (update == null || update.getPrice() != 101 || update.getTime() != 1L) {
			throw new IllegalStateException("Failed to get correct price update, received " + update);
		}
		
		//shutdown exec and then the JVM in case blockingFeed creates some threads
		exec.shutdown();
		System.out.println("Done. All tests passed!");
		System.exit(0);
	}

	private static void sleep(int secs) {
		try {
			Thread.sleep(1000 * secs);
		}
		catch (InterruptedException e) {
			throw new IllegalStateException("Unexpected interruption", e);
		}
	}
}
