package com.concordia.flight.radar.customAPI.requestHandler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.concordia.flight.radar.apiProcessor.HandleFlightInfoUpdateRequest;
import com.concordia.flight.radar.pojo.FlightInfo;

@RestController
@RequestMapping(value = "/getFlightInfo")
public class FlighInfoController extends AbstractRestHandler {

	@Autowired
	private HandleFlightInfoUpdateRequest handleFlightInfoUpdateRequest;

	@RequestMapping(value = "/{query}", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<FlightInfo> getFlightInfo(@PathVariable("query") String query, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		handleFlightInfoUpdateRequest.processUpdateFlightAndCountryInfo();
		List<FlightInfo> result = handleFlightInfoUpdateRequest.retrieveRecordsFromDb();

		checkResourceFound(result);
		return result;
	}
}
