package com.concordia.flight.radar.apiProcessor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.concordia.flight.radar.manager.FlightInfoManager;
import com.concordia.flight.radar.managerImpl.FlightInfoManagerImpl;
import com.concordia.flight.radar.pojo.FlightInfo;

@Service
public class HandleFlightInfoUpdateRequest {

	private FlightInfoManager flightInfoManager;

	public HandleFlightInfoUpdateRequest() {
		this.flightInfoManager = new FlightInfoManagerImpl();
	}

	public List<FlightInfo> retrieveRecordsFromDb() {
		return flightInfoManager.retrieveRecords();
	}

	public List<FlightInfo> retrieveRecordsFromDbBasedOnCountryNameOrCode(String countryNameOrCode) {
		return flightInfoManager.retrieveRecordsFromDbBasedOnCountryNameOrCode(countryNameOrCode);
	}

}
