package com.concordia.flight.radar.fetchDataApi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.apache.log4j.Logger;

public class FetchCountriesInfoFromAPI {
	private static final Logger log = Logger.getLogger(FetchCountriesInfoFromAPI.class);
	private final static String URL = "https://airlabs.co/api/v9/countries?api_key=88a7dabf-183f-4511-be1a-9f436ae39e1f";

	protected static String getCountriesInfoFromApi() {
		try {
			var client = HttpClient.newHttpClient();

			// create a request
			var request = HttpRequest.newBuilder(URI.create(URL)).header("accept", "application/json").build();

			// use the client to send the request
			HttpResponse<String> response;
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return response.body();
		} catch (Exception e) {
			log.error("Error occured while fetching data from api", e);
		}
		return null;

	}

}
