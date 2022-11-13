package com.concordia.flight.radar.dao;

import java.util.List;

import com.concordia.flight.radar.pojo.Country;

public interface CountryDao {
	public void createCountryTable() throws Exception;

	public void createOrUpdate(List<Country> countries) throws Exception;
}
