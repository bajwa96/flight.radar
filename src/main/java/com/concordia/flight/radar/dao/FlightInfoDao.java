package com.concordia.flight.radar.dao;

import java.util.List;

import com.concordia.flight.radar.pojo.FlightInfo;

public interface FlightInfoDao {

	void createOrUpdateFlightInfo(List<FlightInfo> flightInfoList) throws Exception;

	void createFlightInfoTable();

	void deleteRecordsFromFlightInfo() throws Exception;

	List<FlightInfo> retrieveRecords() throws Exception;

	List<FlightInfo> retrieveRecordsFromDbBasedOnCountryNameOrCode(String countryNameOrCode) throws Exception;

	List<FlightInfo> retrieveRecordsFromDbBasedOnArrAirportIcao(String airportIcao) throws Exception;

}
