package com.concordia.flight.radar.manager;

import java.util.List;

import com.concordia.flight.radar.pojo.FlightInfo;

public interface FlightInfoManager {

	void createTable() throws Exception;

	void flushAndFillFlightInfo(List<FlightInfo> flightInfoList) throws Exception;

	List<FlightInfo> retrieveRecords();

}
