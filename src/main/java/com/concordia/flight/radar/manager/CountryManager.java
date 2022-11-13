package com.concordia.flight.radar.manager;

import java.util.List;

import com.concordia.flight.radar.pojo.Country;

public interface CountryManager {
	/**
	 * create country table in db
	 */
	public void createCountryTable();

	/**
	 * Create of update countries table record
	 * 
	 * @param countries
	 */
	public void createOrUpdate(List<Country> countries);
}
