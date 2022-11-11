package com.concordia.flight.radar.manager;

import java.util.Date;

public interface UpdateHistoryManager {

	Date getLastUpdateTimeOnCountryTable();

	Date getLastUpdateTimeOnFlightInfoTable();

}
