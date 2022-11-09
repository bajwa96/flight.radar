package com.concordia.flight.radar.fetchDataApi;

public enum ApiUrl {
	COUNTRIES_URL("https://airlabs.co/api/v9/countries?api_key=88a7dabf-183f-4511-be1a-9f436ae39e1f"),
	FLIGHT_INFO_URL("https://airlabs.co/api/v9/flights?api_key=88a7dabf-183f-4511-be1a-9f436ae39e1f");
	
	public final String label;

    private ApiUrl(String label) {
        this.label = label;
    }
}