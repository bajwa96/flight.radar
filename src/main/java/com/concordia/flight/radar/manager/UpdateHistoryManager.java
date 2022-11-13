package com.concordia.flight.radar.manager;

import java.util.Date;

public interface UpdateHistoryManager {

	// Both the functions got deprecated with the DbRefreshTaskExecutor which
	// handles the refresh based on set interval and requires no db lookup

	/**
	 * getLastUpdateTime for country table
	 * 
	 * @return
	 */
	@Deprecated
	Date getLastUpdateTimeOnCountryTable();

	/**
	 * getLastUpdateTime for flight info table
	 * 
	 * @return
	 */
	@Deprecated
	Date getLastUpdateTimeOnFlightInfoTable();

}
