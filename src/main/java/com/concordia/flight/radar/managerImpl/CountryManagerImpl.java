package com.concordia.flight.radar.managerImpl;

import java.util.List;

import org.apache.log4j.Logger;

import com.concordia.flight.radar.dao.CountryDao;
import com.concordia.flight.radar.dao.impl.CountryDaoImpl;
import com.concordia.flight.radar.manager.CountryManager;
import com.concordia.flight.radar.pojo.Country;

public class CountryManagerImpl extends ManagerBase implements CountryManager {

	private static final Logger log = Logger.getLogger(CountryManagerImpl.class);
	public CountryManagerImpl() {
		countryDao = new CountryDaoImpl(conn);
	}

	private CountryDao countryDao;

	@Override
	public void createCountryTable() {
		try {
			preConfig();
			countryDao.createCountryTable();
			postConfig();
		} catch (Exception e) {
			log.error("Unable to create country table", e);
		}

	}

	@Override
	public void createOrUpdate(List<Country> countries) {
		try {
			preConfig();
			countryDao.createOrUpdate(countries);
			postConfig();
		} catch (Exception e) {
			log.error("Unable to create records in country table", e);
		}

	}

}
