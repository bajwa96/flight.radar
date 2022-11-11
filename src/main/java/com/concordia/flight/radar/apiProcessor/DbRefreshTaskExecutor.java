package com.concordia.flight.radar.apiProcessor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class DbRefreshTaskExecutor {

	public static DbRefreshTaskExecutor instance;

	public static DbRefreshTaskExecutor getInstance() {
		if (instance == null) {
			instance = new DbRefreshTaskExecutor();
		}
		return instance;
	}

	private DbRefreshTaskExecutor() {
	}

	private LoadCountriesProcessor loadCountriesDataIntoDb;
	private LoadFlightInfoProcessor loadFlightInfoProcessor;

	private void initialise() {
		this.loadCountriesDataIntoDb = new LoadCountriesProcessor();
		this.loadFlightInfoProcessor = new LoadFlightInfoProcessor();
	}

	@PostConstruct
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
		ses.scheduleAtFixedRate(task1, 0, 120, TimeUnit.MINUTES);
		ses.scheduleAtFixedRate(task2, 0, 2, TimeUnit.MINUTES);
	}

}
