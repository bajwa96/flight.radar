package com.concordia.flight.radar.manager;

import java.util.List;

import com.concordia.flight.radar.pojo.FlightInfo;

public interface FlightInfoManager {

	/**
	 * creates FlightInfo Table in db
	 * 
	 * @throws Exception
	 */
	void createTable() throws Exception;

	/**
	 * Delete existing db records and create new based on updated flights info
	 * objects
	 * 
	 * @param flightInfoList
	 * @throws Exception
	 */
	void flushAndFillFlightInfo(List<FlightInfo> flightInfoList) throws Exception;

	/**
	 * retrieve flightInfo Objects
	 * 
	 * @return
	 */
	List<FlightInfo> retrieveRecords();

	/**
	 * Retrieve FlightInfo Based on Country name or Country code, for instance CA or
	 * Canada as value in order to retrieve all flight status belonging to this
	 * country
	 * 
	 * @param countryNameOrCode
	 * @return
	 */
	List<FlightInfo> retrieveRecordsFromDbBasedOnCountryNameOrCode(String countryNameOrCode);

	/**
	 * Retrieve FlightInfo Based on Arrival/Destination Airport ICAO code
	 * @param airportIcao
	 * @return
	 */
	List<FlightInfo> retrieveRecordsFromDbBasedOnArrAirportIcao(String airportIcao);

}
