package com.concordia.flight.radar.managerImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.concordia.flight.radar.dao.FlightInfoDao;
import com.concordia.flight.radar.dao.impl.FlightInfoDaoImpl;
import com.concordia.flight.radar.manager.FlightInfoManager;
import com.concordia.flight.radar.pojo.FlightInfo;

public class FlightInfoManagerImpl extends ManagerBase implements FlightInfoManager {
	private static final Logger log = Logger.getLogger(FlightInfoManagerImpl.class);
	private FlightInfoDao flightInfoDao;

	public FlightInfoManagerImpl() {
		this.flightInfoDao = new FlightInfoDaoImpl(this.conn);
	}

	@Override
	public void createTable() throws Exception {
		try {
			preConfig();
			flightInfoDao.createFlightInfoTable();
			postConfig();
		} catch (Exception e) {
			failedTransaactionHandler();
			log.error("Unable to create flight info table",e);
		}

	}

	@Override
	public void flushAndFillFlightInfo(List<FlightInfo> flightInfoList) throws Exception {
		try {
			preConfig();
			List<List<FlightInfo>> flightInfoChunkList = chunkList(flightInfoList, 500);
			flightInfoDao.deleteRecordsFromFlightInfo();
			for(List<FlightInfo> currList : flightInfoChunkList) {
				flightInfoDao.createOrUpdateFlightInfo(currList);
			}
			
			postConfig();
		} catch (Exception e) {
			log.error("Unable to flush And Fill FlightInfo records",e);
			failedTransaactionHandler();
		}

	}

	public static  <T> List<List<T>> chunkList(List<T> list, int chunkSize) {
	    if (chunkSize <= 0) {
	        throw new IllegalArgumentException("Invalid chunk size: " + chunkSize);
	    }
	    List<List<T>> chunkList = new ArrayList<>(list.size() / chunkSize);
	    for (int i = 0; i < list.size(); i += chunkSize) {
	        chunkList.add(list.subList(i, i + chunkSize >= list.size() ? list.size()-1 : i + chunkSize));
	    }
	    return chunkList;
	}

	@Override
	public List<FlightInfo> retrieveRecords() {
		try {
			List<FlightInfo> obj=  flightInfoDao.retrieveRecords();
			return obj;
		} catch (Exception e) {
			log.error("Unable to retrieve FlightInfo records",e);
		}
		return null;
	}

	@Override
	public List<FlightInfo> retrieveRecordsFromDbBasedOnCountryNameOrCode(String countryNameOrCode) {
		try {
			List<FlightInfo> obj=  flightInfoDao.retrieveRecordsFromDbBasedOnCountryNameOrCode(countryNameOrCode);
			return obj;
		} catch (Exception e) {
			log.error("Unable to retrieve FlightInfo records based on country name or code",e);
		}
		return null;
	}

	@Override
	public List<FlightInfo> retrieveRecordsFromDbBasedOnArrAirportIcao(String airportIcao) {
		try {
			List<FlightInfo> obj=  flightInfoDao.retrieveRecordsFromDbBasedOnArrAirportIcao(airportIcao);
			return obj;
		} catch (Exception e) {
			log.error("Unable to retrieve FlightInfo records based on airport icao code code",e);
		}
		return null;
	}

}
