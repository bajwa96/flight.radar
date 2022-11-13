package com.concordia.flight.radar.apiProcessor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class DbRefreshTaskExecutor {

	private static final Logger log = Logger.getLogger(DbRefreshTaskExecutor.class);

	public static DbRefreshTaskExecutor instance;

	public static DbRefreshTaskExecutor getInstance() {
		log.debug("Inside getInstance for db");
		if (instance == null) {
			log.debug("Creating new instance for db connection");
			instance = new DbRefreshTaskExecutor();
		}
		return instance;
	}

	/**
	 * since this is singleton class so making the constructor as private Please
	 * refer to: {@code getInstance()}
	 */
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
				log.error("Error while loading Countries Data to db", e);
			}
			log.debug("[Scheduled Task]Sucess updating countries");
		};

		Runnable task2 = () -> {
			try {
				loadFlightInfoProcessor.loadFlightInfoIntoDb();
			} catch (Exception e) {
				log.error("Error while loading Flight Info Data to db", e);
			}
			log.debug("[Scheduled Task]Sucess updating flightInfo");
		};

		ses.scheduleAtFixedRate(task1, 0, 120, TimeUnit.MINUTES);
		ses.scheduleAtFixedRate(task2, 0, 2, TimeUnit.MINUTES);
	}

}
