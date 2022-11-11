package com.concordia.flight.radar.managerImpl;

import java.util.Date;

import org.apache.log4j.Logger;

import com.concordia.flight.radar.dao.UpdateHistoryDao;
import com.concordia.flight.radar.dao.impl.UpdateHistoryDaoImpl;
import com.concordia.flight.radar.manager.UpdateHistoryManager;

public class UpdateHistoryManagerImpl extends ManagerBase implements UpdateHistoryManager {
	private static final Logger log = Logger.getLogger(UpdateHistoryManagerImpl.class);
	private UpdateHistoryDao updateHistoryDao;

	public UpdateHistoryManagerImpl() {
		updateHistoryDao = new UpdateHistoryDaoImpl(conn);
	}

	@Override
	public Date getLastUpdateTimeOnCountryTable() {
		try {
			preConfig();
			Date result = updateHistoryDao.getLastUpdateTimeOnCountryTable();
			postConfig();
			return result;
		} catch (Exception e) {
			log.error("Unable to fetch update time from country table", e);
			failedTransaactionHandler();
		}
		return null;
	}

	@Override
	public Date getLastUpdateTimeOnFlightInfoTable() {
		try {
			preConfig();
			Date result =  updateHistoryDao.getLastUpdateTimeOnFlightInfoTable();
			postConfig();
			return result;
		} catch (Exception e) {
			log.error("Unable to fetch update time from flight info table", e);
			failedTransaactionHandler();
		}
		return null;
	}

}
