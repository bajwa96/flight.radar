package com.concordia.flight.radar.manager;

import java.util.List;

import com.concordia.flight.radar.pojo.Country;

public interface CountryManager {
	public void createCountryTable();
	public void createOrUpdate(List<Country> countries);
}
