package com.concordia.flight.radar.apiProcessor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.concordia.flight.radar.manager.FlightInfoManager;
import com.concordia.flight.radar.managerImpl.FlightInfoManagerImpl;
import com.concordia.flight.radar.pojo.FlightInfo;


@Service
public class HandleFlightInfoUpdateRequest {
	
	private DbRefreshTaskExecutor dbRefreshTaskExecutor;
//	private LoadCountriesProcessor loadCountriesDataIntoDb;
//	private LoadFlightInfoProcessor loadFlightInfoProcessor;
//	private UpdateHistoryManager updateHistoryManager;
	private FlightInfoManager flightInfoManager;

	private void initialize() {
//		this.loadCountriesDataIntoDb = new LoadCountriesProcessor();
//		this.loadFlightInfoProcessor = new LoadFlightInfoProcessor();
//		this.updateHistoryManager = new UpdateHistoryManagerImpl();
		this.flightInfoManager = new FlightInfoManagerImpl();
		this.dbRefreshTaskExecutor=new DbRefreshTaskExecutor();
	}
//
//	private static Integer UPDATE_COUNTRIES_AFTER_SEC = 3600;
//	private static Integer UPDATE_FLIGHT_INFO_AFTER_SEC = 60;

	public void processUpdateFlightAndCountryInfo() throws Exception {
		initialize();
		dbRefreshTaskExecutor.createAutoDbRefreshRequest();
//		Date countryTableLastUpdateTime = updateHistoryManager.getLastUpdateTimeOnCountryTable();
//		Date flightInfoTableLastUpdateTime = updateHistoryManager.getLastUpdateTimeOnFlightInfoTable();
//
//		boolean lastUpdateWithinTheLimit = checkIfTheLastUpdateTimeIsWithinTheLimit(countryTableLastUpdateTime,
//				UPDATE_COUNTRIES_AFTER_SEC);
//		System.out.println("updating countries="+!lastUpdateWithinTheLimit);
//		if (!lastUpdateWithinTheLimit) {
//			loadCountriesDataIntoDb.loadCountriesIntoDb();
//		}
//		
//		System.out.println("updating flight info="+!lastUpdateWithinTheLimit);
//		lastUpdateWithinTheLimit = checkIfTheLastUpdateTimeIsWithinTheLimit(flightInfoTableLastUpdateTime,
//				UPDATE_FLIGHT_INFO_AFTER_SEC);
//		if (!lastUpdateWithinTheLimit) {
//			loadFlightInfoProcessor.loadFlightInfoIntoDb();
//		}
	}

//	private boolean checkIfTheLastUpdateTimeIsWithinTheLimit(Date countryTableLastUpdateTime, Integer minDiff) {
//		if (countryTableLastUpdateTime == null) {
//			return false;
//		}
//		Date now = new Date();
//		long diffInMillies = Math.abs(countryTableLastUpdateTime.getTime() - now.getTime()); // in seconds
//		System.out.println(diffInMillies);
//		if (diffInMillies >= minDiff) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//	
	public List<FlightInfo> retrieveRecordsFromDb(){
		return flightInfoManager.retrieveRecords();
	}

}
