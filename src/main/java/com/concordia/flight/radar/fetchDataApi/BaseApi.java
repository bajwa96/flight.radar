package com.concordia.flight.radar.fetchDataApi;

public interface BaseApi {
	/**
	 * Contains implementation for get call
	 * @param url
	 * @return - string response
	 * @throws Exception
	 */
	public String doGetCall(ApiUrl url) throws Exception;
}
