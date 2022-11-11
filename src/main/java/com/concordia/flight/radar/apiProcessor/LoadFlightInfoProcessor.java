package com.concordia.flight.radar.apiProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;
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

public class LoadFlightInfoProcessor {
	private static final Logger log = Logger.getLogger(LoadFlightInfoProcessor.class);

	private FlightInfoManager flightInfoManager;

	private void initialize() {
		flightInfoManager = new FlightInfoManagerImpl();
	}

	public void loadFlightInfoIntoDb() throws Exception {
		initialize();
		String countriesFromApi = APIBaseClass.getInstance().doGetCall(ApiUrl.FLIGHT_INFO_URL);
		log.info("going to parse countries data from api");
		List<FlightInfo> flightInfoList = parseDataFromApi(countriesFromApi);
		flightInfoManager.flushAndFillFlightInfo(flightInfoList);
		log.info("successfully sync countries in db");
	}

	private List<FlightInfo> parseDataFromApi(String flightInfoData) {
		List<FlightInfo> flightInfolst = new LinkedList<>();
		try {
			JSONObject jo = new JSONObject(flightInfoData);
			JSONArray parsedJsonResponse = jo.getJSONArray("response");
			for (Object now : parsedJsonResponse) {
				JSONObject curr = (JSONObject) now;
				FlightInfo flightInfo = new FlightInfo();
				flightInfo.setHex(curr.getString("hex"));
				if (curr.has("reg_number"))
					flightInfo.setRegNumber(curr.getString("reg_number"));
				if (curr.has("flag"))
					flightInfo.setFlag(curr.getString("flag"));
				System.out.println(flightInfo.getFlag());
				flightInfo.setLatitude(curr.getDouble("lat"));
				if (curr.has("lng"))
					flightInfo.setLongitude(curr.getDouble("lng"));
				if (curr.has("alt"))
					flightInfo.setAltitude(curr.getInt("alt"));
				if (curr.has("dir"))
					flightInfo.setDirection(curr.getInt("dir"));
				if (curr.has("speed"))
					flightInfo.setSpeed(curr.getInt("speed"));
				if (curr.has("v_speed"))
					flightInfo.setVerticalVelocity(curr.getInt("v_speed"));
				if (curr.has("squawk"))
					flightInfo.setSquawk(curr.getString("squawk"));
				if (curr.has("flight_number"))
					flightInfo.setFlightNumber(curr.getString("flight_number"));
				if (curr.has("flight_icao"))
					flightInfo.setFlightIcao(curr.getString("flight_icao"));
				if (curr.has("flight_iata"))
					flightInfo.setFlightIata(curr.getString("flight_iata"));
				if (curr.has("dep_icao"))
					flightInfo.setDepIata(curr.getString("dep_icao"));
				if (curr.has("dep_iata"))
					flightInfo.setDepIata(curr.getString("dep_iata"));
				if (curr.has("arr_icao"))
					flightInfo.setArrIcao(curr.getString("arr_icao"));
				if (curr.has("airline_iata"))
					flightInfo.setAirlineIata(curr.getString("airline_iata"));
				if (curr.has("airline_icao"))
					flightInfo.setAirlineIcao(curr.getString("airline_icao"));

				if (curr.has("updated")) {
					SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
					Date date = originalFormat.parse(String.valueOf(curr.getInt("updated")));
					flightInfo.setUpdated(date);
				}
				if (curr.has("aircraft_icao"))
					flightInfo.setAircraftIcao(curr.getString("aircraft_icao"));

				flightInfo.setStatus(curr.getString("status"));
				flightInfo.setCreateTime(new Date());
				flightInfo.setCreateUser(this.getClass().getTypeName());
				flightInfo.setUpdateTime(new Date());
				flightInfo.setUpdateUser(this.getClass().getTypeName());

				flightInfolst.add(flightInfo);
			}
		} catch (Exception e) {
			log.error("Issue occured while processing countries", e);
		}
		log.debug("FlightInfo count=" + flightInfolst.size());
		return flightInfolst;
	}
}
