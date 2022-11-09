package com.concordia.flight.radar.managerImpl;

import java.util.List;

import com.concordia.flight.radar.dao.FlightInfoDao;
import com.concordia.flight.radar.dao.impl.FlightInfoDaoImpl;
import com.concordia.flight.radar.manager.FlightInfoManager;
import com.concordia.flight.radar.pojo.FlightInfo;

public class FlightInfoManagerImpl extends ManagerBase implements FlightInfoManager {
	private FlightInfoDao flightInfoDao;
	public FlightInfoManagerImpl(){
		this.flightInfoDao = new FlightInfoDaoImpl();
	}
	
	@Override
	public void createOrUpdate(List<FlightInfo> flightInfoList) {
		try {
			preConfig();
			flightInfoDao.createCountryTable();
			postConfig();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
