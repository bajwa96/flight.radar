package com.concordia.flight.radar.fetchDataApi;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.concordia.flight.radar.dao.CountryDao;
import com.concordia.flight.radar.dao.impl.CountryDaoImpl;
import com.concordia.flight.radar.manager.CountryManager;
import com.concordia.flight.radar.managerImpl.CountryManagerImpl;
import com.concordia.flight.radar.pojo.Country;

public class LoadCountriesDataIntoDb {
	private static final Logger log = Logger.getLogger(LoadCountriesDataIntoDb.class);

	private CountryManager countryManager;

	public LoadCountriesDataIntoDb() {
		countryManager = new CountryManagerImpl();
	}

	public void loadCountriesIntoDb() {
		String countriesFromApi = FetchCountriesInfoFromAPI.getCountriesInfoFromApi();
		log.info("going to parse countries data from api");
		List<Country> countries = parseDataFromApi(countriesFromApi);
		countryManager.createOrUpdate(countries);
		log.info("successfully sync countries in db");
	}

	private List<Country> parseDataFromApi(String countriesFromApi) {
		List<Country> countries = new LinkedList<>();
		try {
			JSONObject jo = new JSONObject(countriesFromApi);
			JSONArray parsedJsonResponse = jo.getJSONArray("response");
			for (Object now : parsedJsonResponse) {
				JSONObject curr = (JSONObject) now;
				countries.add(new Country(curr.getString("name"), curr.getString("code"), curr.getString("code3")));
			}

		} catch (Exception e) {
			log.error("Issue occured while processing countries", e);
		}
		log.debug("Countries count=" + countries.size());
		return countries;
	}
}
