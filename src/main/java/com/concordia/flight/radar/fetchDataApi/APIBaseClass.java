package com.concordia.flight.radar.fetchDataApi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIBaseClass implements BaseApi {
	
	public static APIBaseClass getInstance() {
		return new APIBaseClass();
	}
	
	public String doGetCall(ApiUrl apiUrl) throws Exception {
		var client = HttpClient.newHttpClient();

		// create a request
		var request = HttpRequest.newBuilder(URI.create(apiUrl.label)).header("accept", "application/json").build();

		// use the client to send the request
		HttpResponse<String> response;
		response = client.send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}
}
