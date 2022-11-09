package com.concordia.flight.radar.apiProcessor;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.concordia.flight.radar.fetchDataApi.APIBaseClass;
import com.concordia.flight.radar.fetchDataApi.ApiUrl;
import com.concordia.flight.radar.manager.FlightInfoManager;
import com.concordia.flight.radar.managerImpl.FlightInfoManagerImpl;
import com.concordia.flight.radar.pojo.FlightInfo;

public class loadFlightInfoProcessor {
	private static final Logger log = Logger.getLogger(loadFlightInfoProcessor.class);

	private FlightInfoManager flightInfoManager;

	public loadFlightInfoProcessor() {
		flightInfoManager = new FlightInfoManagerImpl();
	}

	public void loadCountriesIntoDb() throws Exception {
		String countriesFromApi = APIBaseClass.getInstance().doGetCall(ApiUrl.COUNTRIES_URL);
		log.info("going to parse countries data from api");
		List<FlightInfo> flightInfoList = parseDataFromApi(countriesFromApi);
		flightInfoManager.createOrUpdate(flightInfoList);
		log.info("successfully sync countries in db");
	}

	private List<FlightInfo> parseDataFromApi(String flightInfoData) {
		List<FlightInfo> flightInfolst = new LinkedList<>();
		try {
			JSONObject jo = new JSONObject(flightInfoData);
			JSONArray parsedJsonResponse = jo.getJSONArray("response");
			for (Object now : parsedJsonResponse) {
				JSONObject curr = (JSONObject) now;
				flightInfolst.add(new FlightInfo());
			}
		} catch (Exception e) {
			log.error("Issue occured while processing countries", e);
		}
		log.debug("FlightInfo count=" + flightInfolst.size());
		return flightInfolst;
	}
}
