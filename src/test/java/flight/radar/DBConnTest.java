package flight.radar;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.concordia.flight.radar.dbUtils.CommonDbUtil;

public class DBConnTest {

	@Test
	public void test() {
		CommonDbUtil commonDbUtil = new CommonDbUtil();
		Statement s;
		try {
			
			s = commonDbUtil.getConn().createStatement();
			ResultSet result = s.executeQuery("select count(1) as count from Country");
			result.next();
			int size = result.getInt("count");
			if(size>=0)
				assertTrue("Connection to db is success", size>=0);
			else{
				fail("Unable to connect with sql server");
			}
			
		} catch (SQLException e) {
			fail("Unable to connect with sql server");
		}finally {
			commonDbUtil.closeConnection();
		}
		
		
		
		
	}

}
