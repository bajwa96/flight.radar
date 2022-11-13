package com.concordia.flight.radar.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FlightInfo extends BasePojo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flightInfoPkId;
	private String hex;
	private String regNumber;
	private String flag;
	private Double latitude;
	private Double longitude;
	private Integer altitude;
	private Integer direction;
	private Integer speed;
	private Integer verticalVelocity;
	private String squawk;
	private String flightNumber;
	private String flightIcao;
	private String flightIata;
	private String depIcao;
	private String depIata;
	private String arrIcao;
	private String airlineIcao;
	private String airlineIata;
	private String aircraftIcao;

	public String getAircraftIcao() {
		return aircraftIcao;
	}

	public void setAircraftIcao(String aircraftIcao) {
		this.aircraftIcao = aircraftIcao;
	}

	private Date updated;
	private String status;

	public Integer getFlightInfoPkId() {
		return flightInfoPkId;
	}

	public void setFlightInfoPkId(Integer flightInfoPkId) {
		this.flightInfoPkId = flightInfoPkId;
	}

	public String getHex() {
		return hex;
	}

	public void setHex(String hex) {
		this.hex = hex;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Integer getAltitude() {
		return altitude;
	}

	public void setAltitude(Integer altitude) {
		this.altitude = altitude;
	}

	public Integer getDirection() {
		return direction;
	}

	public void setDirection(Integer direction) {
		this.direction = direction;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Integer getVerticalVelocity() {
		return verticalVelocity;
	}

	public void setVerticalVelocity(Integer verticalVelocity) {
		this.verticalVelocity = verticalVelocity;
	}

	public String getSquawk() {
		return squawk;
	}

	public void setSquawk(String squawk) {
		this.squawk = squawk;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightIcao() {
		return flightIcao;
	}

	public void setFlightIcao(String flightIcao) {
		this.flightIcao = flightIcao;
	}

	public String getFlightIata() {
		return flightIata;
	}

	public void setFlightIata(String flightIata) {
		this.flightIata = flightIata;
	}

	public String getDepIcao() {
		return depIcao;
	}

	public void setDepIcao(String depIcao) {
		this.depIcao = depIcao;
	}

	public String getDepIata() {
		return depIata;
	}

	public void setDepIata(String depIata) {
		this.depIata = depIata;
	}

	public String getArrIcao() {
		return arrIcao;
	}

	public void setArrIcao(String arrIcao) {
		this.arrIcao = arrIcao;
	}

	public String getAirlineIcao() {
		return airlineIcao;
	}

	public void setAirlineIcao(String airlineIcao) {
		this.airlineIcao = airlineIcao;
	}

	public String getAirlineIata() {
		return airlineIata;
	}

	public void setAirlineIata(String airlineIata) {
		this.airlineIata = airlineIata;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("[flightInfoPkId:").append(flightInfoPkId).append(", ");
		str.append("hex:").append(hex).append(", ");
		str.append("regNumber:").append(regNumber).append(", ");
		str.append("flag:").append(flag).append(", ");
		str.append("latitude:").append(latitude).append(", ");
		str.append("longitude:").append(longitude).append(", ");
		str.append("altitude:").append(altitude).append(", ");
		str.append("direction:").append(direction).append(", ");
		str.append("speed:").append(speed).append(", ");
		str.append("verticalVelocity:").append(verticalVelocity).append(", ");
		str.append("squawk:").append(squawk).append(", ");
		str.append("flightNumber:").append(flightNumber).append(", ");
		str.append("flightIcao:").append(flightIcao).append(", ");
		str.append("flightIcao:").append(flightIcao).append(", ");
		str.append("flightIata:").append(flightIata).append(", ");
		str.append("depIcao:").append(depIcao).append(", ");
		str.append("depIata:").append(depIata).append(", ");
		str.append("arrIcao:").append(arrIcao).append(", ");
		str.append("airlineIcao:").append(airlineIcao).append(", ");
		str.append("airlineIata:").append(airlineIata).append(", ");
		str.append("aircraftIcao:").append(aircraftIcao).append("]");
		return str.toString();
	}

}
