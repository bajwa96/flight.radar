package com.concordia.flight.radar.apiProcessor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class DbRefreshTaskExecutor {
	
	private LoadCountriesProcessor loadCountriesDataIntoDb;
	private LoadFlightInfoProcessor loadFlightInfoProcessor;
	
	private void initialise() {
		this.loadCountriesDataIntoDb = new LoadCountriesProcessor();
		this.loadFlightInfoProcessor = new LoadFlightInfoProcessor();
	}
	
	public void createAutoDbRefreshRequest() {
		initialise();
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);

	    Runnable task1 = () -> {
	    	try {
				loadCountriesDataIntoDb.loadCountriesIntoDb();
			} catch (Exception e) {
				e.printStackTrace();
			}
	        System.out.println("[Scheduled Task]Sucess updating countries");
	    };
	    
	    Runnable task2 = () -> {
	    	try {
				loadFlightInfoProcessor.loadFlightInfoIntoDb();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	System.out.println("[Scheduled Task]Sucess updating flight");
	    };
	    
	    // since countries code will not change rapidly
	    ScheduledFuture<?> scheduledFuture = ses.scheduleAtFixedRate(task1, 0, 120, TimeUnit.MINUTES);
	    ScheduledFuture<?> scheduledFuture2 = ses.scheduleAtFixedRate(task2, 0, 1, TimeUnit.MINUTES);
	}
	
}
