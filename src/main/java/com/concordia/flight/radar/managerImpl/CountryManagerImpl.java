package com.concordia.flight.radar.managerImpl;

import java.util.List;

import com.concordia.flight.radar.dao.CountryDao;
import com.concordia.flight.radar.dao.impl.CountryDaoImpl;
import com.concordia.flight.radar.manager.CountryManager;
import com.concordia.flight.radar.pojo.Country;

public class CountryManagerImpl extends ManagerBase implements CountryManager {

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void createOrUpdate(List<Country> countries) {
		try {
			preConfig();
			countryDao.createOrUpdate(countries);
			postConfig();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
