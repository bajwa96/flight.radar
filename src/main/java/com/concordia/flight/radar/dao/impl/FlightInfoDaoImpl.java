package com.concordia.flight.radar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.concordia.flight.radar.dao.FlightInfoDao;
import com.concordia.flight.radar.pojo.FlightInfo;

public class FlightInfoDaoImpl implements FlightInfoDao {
	private Connection conn;

	public FlightInfoDaoImpl(Connection conn) {
		this.conn = conn;
	}

	private static final Logger log = Logger.getLogger(FlightInfoDaoImpl.class);

	private final String INSERT_QUERY = "INSERT INTO flight_info\n"
			+ "(hex, flag, reg_number, latitude, longitude, altitude, direction, vertical_velocity, squawk, flight_number, flight_icao,"
			+ " flight_iata, dep_icao, dep_iata, arr_icao, airline_icao, updated, status, update_user, update_time, create_user, create_time, aircraft_icao,speed)\n"
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);\n" + "";

	@Override
	public void createOrUpdateFlightInfo(List<FlightInfo> flightInfoList) throws Exception {
		PreparedStatement preparedStatement = conn.prepareStatement(INSERT_QUERY);
		for (int index = 0; index < flightInfoList.size(); index++) {
			FlightInfo flighInfo = flightInfoList.get(index);
			preparedStatement.setObject(1, flighInfo.getHex());
			preparedStatement.setObject(2, flighInfo.getFlag());
			preparedStatement.setObject(3, flighInfo.getRegNumber());
			preparedStatement.setObject(4, flighInfo.getLatitude());
			preparedStatement.setObject(5, flighInfo.getLongitude());
			preparedStatement.setObject(6, flighInfo.getAltitude());
			preparedStatement.setObject(7, flighInfo.getDirection());
			preparedStatement.setObject(8, flighInfo.getVerticalVelocity());
			preparedStatement.setObject(9, flighInfo.getSquawk());
			preparedStatement.setObject(10, flighInfo.getFlightNumber());
			preparedStatement.setObject(11, flighInfo.getFlightIcao());
			preparedStatement.setObject(12, flighInfo.getFlightIata());
			preparedStatement.setObject(13, flighInfo.getDepIcao());
			preparedStatement.setObject(14, flighInfo.getDepIcao());
			preparedStatement.setObject(15, flighInfo.getArrIcao());
			preparedStatement.setObject(16, flighInfo.getAirlineIcao());
			preparedStatement.setObject(17, flighInfo.getUpdated());
			preparedStatement.setObject(18, flighInfo.getStatus());
			preparedStatement.setObject(19, flighInfo.getUpdateUser());
			preparedStatement.setObject(20, flighInfo.getUpdateTime());
			preparedStatement.setObject(21, flighInfo.getCreateUser());
			preparedStatement.setObject(22, flighInfo.getCreateTime());
			preparedStatement.setObject(23, flighInfo.getAircraftIcao());
			preparedStatement.setObject(24, flighInfo.getSpeed());
			preparedStatement.addBatch();
		}
		preparedStatement.executeBatch();
		log.debug("Success executing insert/update on flight_info table");

	}

	public void createFlightInfoTable() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRecordsFromFlightInfo() throws Exception {
		PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM flight_info;");
		preparedStatement.execute();
		log.debug("Success deleted records from flight_info table");
	}

	@Override
	public List<FlightInfo> retrieveRecords() throws Exception {
		PreparedStatement preparedStatement = conn.prepareStatement("select * FROM flight_info;");
		ResultSet rs = preparedStatement.executeQuery();
		return prepareFlightInfoObjectFromResultSet(rs);
	}

	private List<FlightInfo> prepareFlightInfoObjectFromResultSet(ResultSet rs) throws SQLException {
		LinkedList<FlightInfo> flightInfolst = new LinkedList<>();
		while (rs.next()) {
			var curr = rs;
			FlightInfo flightInfo = new FlightInfo();
			flightInfo.setHex(curr.getString("hex"));
			flightInfo.setRegNumber(curr.getString("reg_number"));
			flightInfo.setFlag(curr.getString("flag"));
			flightInfo.setLatitude(curr.getDouble("latitude"));
			flightInfo.setLongitude(curr.getDouble("longitude"));
			flightInfo.setAltitude(curr.getInt("altitude"));
			flightInfo.setDirection(curr.getInt("direction"));
			flightInfo.setSpeed(curr.getInt("speed"));
			flightInfo.setVerticalVelocity(curr.getInt("vertical_velocity"));
			flightInfo.setSquawk(curr.getString("squawk"));
			flightInfo.setFlightNumber(curr.getString("flight_number"));
			flightInfo.setFlightIcao(curr.getString("flight_icao"));
			flightInfo.setFlightIata(curr.getString("flight_iata"));
			flightInfo.setDepIata(curr.getString("dep_icao"));
			flightInfo.setDepIata(curr.getString("dep_iata"));
			flightInfo.setArrIcao(curr.getString("arr_icao"));
			flightInfo.setAirlineIata(curr.getString("airline_iata"));
			flightInfo.setAirlineIcao(curr.getString("airline_icao"));
			flightInfo.setUpdated(curr.getDate("updated"));
			flightInfo.setAircraftIcao(curr.getString("aircraft_icao"));
			flightInfo.setStatus(curr.getString("status"));
			flightInfo.setCreateTime(new Date());
			flightInfo.setCreateUser(this.getClass().getTypeName());
			flightInfo.setUpdateTime(new Date());
			flightInfo.setUpdateUser(this.getClass().getTypeName());

			flightInfolst.add(flightInfo);
		}
		return flightInfolst;
	}

	@Override
	public List<FlightInfo> retrieveRecordsFromDbBasedOnCountryNameOrCode(String countryNameOrCode) throws Exception {
		String query = "select *  from flight_info fi inner join Country c on c.code = fi.flag where c.code like '%"
				+ countryNameOrCode + "' or c.name like '" + countryNameOrCode + "';";
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
		return prepareFlightInfoObjectFromResultSet(rs);
	}
}
