package com.concordia.flight.radar.manager;

import java.util.List;

import com.concordia.flight.radar.pojo.FlightInfo;

public interface FlightInfoManager {

	void createOrUpdate(List<FlightInfo> flightInfoList);

}
