package com.concordia.flight.radar.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;

import com.concordia.flight.radar.pojo.Country;
import com.concordia.flight.radar.pojo.FlightInfo;

public class DBConnTest {

	@Test
	public void validateCountryPojo() {
		Country sampleCountry = new Country();
		sampleCountry.setCountryName("Canada");
		sampleCountry.setCode("CA");

		EntityManager entityManager = mock(EntityManager.class);
		when(entityManager.find(Country.class, 1L)).thenReturn(sampleCountry);

		CommonReader reader = new CommonReader();
		reader.setEntityManager(entityManager);

		String countryName = reader.findCountryNameUsingCode(1L);
		assertEquals("Canada", countryName);
	}
	
	@Test
	public void validateFlightInfoPojo() {
		FlightInfo flightInfo = new FlightInfo();
		flightInfo.setFlightInfoPkId(1);
		flightInfo.setFlightNumber("AI117");
		flightInfo.setFlag("CA");
		flightInfo.setFlightIata("en-route");
		
		EntityManager entityManager = mock(EntityManager.class);
		when(entityManager.find(FlightInfo.class, 1L)).thenReturn(flightInfo);

		CommonReader reader = new CommonReader();
		reader.setEntityManager(entityManager);

		String flightNumber = reader.findFlightInfo(1L);
		assertEquals("AI117", flightNumber);
	}

}

class CommonReader {

	@PersistenceContext
	private EntityManager entityManager;

	public String findCountryNameUsingCode(long l) {
		Country country = entityManager.find(Country.class, l);
		return country.getCountryName();
	}

	public String findFlightInfo(long l) {
		FlightInfo flightInfo = entityManager.find(FlightInfo.class, l);
		return flightInfo.getFlightNumber();
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
