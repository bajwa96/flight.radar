package com.concordia.flight.radar.managerImpl;

import java.util.ArrayList;
import java.util.List;

import com.concordia.flight.radar.dao.FlightInfoDao;
import com.concordia.flight.radar.dao.impl.FlightInfoDaoImpl;
import com.concordia.flight.radar.manager.FlightInfoManager;
import com.concordia.flight.radar.pojo.FlightInfo;

public class FlightInfoManagerImpl extends ManagerBase implements FlightInfoManager {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			preConfig();
			List<FlightInfo> obj=  flightInfoDao.retrieveRecords();
			postConfig();
			return obj;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			failedTransaactionHandler();
		}
		return null;
	}

}
