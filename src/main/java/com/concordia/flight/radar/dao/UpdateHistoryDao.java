package com.concordia.flight.radar.dao;

import java.util.Date;

public interface UpdateHistoryDao {

	Date getLastUpdateTimeOnCountryTable() throws Exception;

	Date getLastUpdateTimeOnFlightInfoTable() throws Exception;

}
