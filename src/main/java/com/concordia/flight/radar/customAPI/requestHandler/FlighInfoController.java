package com.concordia.flight.radar.customAPI.requestHandler;

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

import com.concordia.flight.radar.apiProcessor.LoadCountriesProcessor;
import com.concordia.flight.radar.apiProcessor.LoadFlightInfoProcessor;
import com.concordia.flight.radar.pojo.FlightInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/example/v1/flight")
@Api(tags = {"flight"})
public class FlighInfoController extends AbstractRestHandler{
	
	@Autowired
	private LoadCountriesProcessor loadCountriesDataIntoDb;
	
	@Autowired
	private LoadFlightInfoProcessor loadFlightInfoProcessor;
	
	
	
	@RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single hotel.", notes = "You have to provide a valid hotel ID.")
    public
    @ResponseBody
    FlightInfo getFlightInfo(@ApiParam(value = "flightNumber", required = true)
                             @PathVariable("id") Long id,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
		FlightInfo flightInfo = new FlightInfo();
        checkResourceFound(flightInfo);
        //todo: http://goo.gl/6iNAkz
        return flightInfo;
    }
}
