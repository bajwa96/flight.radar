package com.concordia.flight.radar.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.concordia.flight.radar.dao.SampleDao;
import com.concordia.flight.radar.dbUtils.CommonDbUtil;
import com.concordia.flight.radar.dbUtils.DBConnection;
import com.concordia.flight.radar.pojo.SamplePerson;


public class SampleDAOImpl extends CommonDbUtil implements SampleDao{

	SampleDAOImpl() {
		super();
	}

	private static final Logger log = Logger.getLogger(DBConnection.class.getName());  

    /**
     * Insert a person into the database
     *
     * @param firstName
     * @param lastName
     * @return
     */
    public boolean insertPerson(SamplePerson person) {
        boolean success = false;

        if (person != null) {
            //log.debug("insertPerson({} {})", person.getFirstName(), person.getLastName());
            if (conn != null) {
                PreparedStatement pstmt = null;

                try {
                    pstmt = conn.prepareStatement("INSERT INTO sample_table VALUES (null, ?, ?, ?)");
                    pstmt.setString(1, person.getFirstName());
                    pstmt.setString(2, person.getLastName());
                    pstmt.setInt(3, person.getAge());

                    success = (pstmt.executeUpdate() == 1);  // success means exactly one row inserted
                } catch (SQLException e) {
                    log.error("Unable to insert" + person.getFirstName() + " " + person.getLastName() + "into the table", e);
                } finally {
                    if (pstmt != null) {
                        try {
                            pstmt.close();
                        } catch (SQLException e) {
                        }
                    }
                }
            }
        }
        return success;
    }

    /**
     * Get all the people stored in the database
     *
     * @return
     */
    public List<SamplePerson> getAllPeople() {
        log.debug("getAllPeople()");
        List<SamplePerson> people = new ArrayList<SamplePerson>();
        SamplePerson person;
        if (conn != null) {
            Statement stmt = null;

            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM sample_table");

                while (rs.next()) {
                    person = new SamplePerson();
                    person.setId(rs.getInt("id"));
                    person.setFirstName(rs.getString("first_name"));
                    person.setLastName(rs.getString("last_name"));
                    person.setAge(rs.getInt("age"));
                    people.add(person);
                }
            } catch (SQLException e) {
                log.error("Unable to create the database table", e);
            } finally {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                    }
                }
            }
        }

        return people;
    }

    /**
     * Get a person by their unique ID
     *
     * @param id
     * @return
     */
    @Override
    public SamplePerson getPersonById(int id) {
        SamplePerson person = null;
        if (conn != null) {
            PreparedStatement pstmt = null;

            try {
                pstmt = conn.prepareStatement("SELECT * FROM sample_table WHERE id = ?");
                pstmt.setInt(1, id);

                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    person = new SamplePerson();
                    person.setId(rs.getInt("id"));
                    person.setFirstName(rs.getString("first_name"));
                    person.setLastName(rs.getString("last_name"));
                    person.setAge(rs.getInt("age"));
                } else {
                    log.warn("No person found for id = "+id);
                }
            } catch (SQLException e) {
                log.error("Unable query person by ID(" + id + ")", e);
            } finally {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (SQLException e) {
                    }
                }
            }
        }

        return person;
    }
}
