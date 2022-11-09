package flight.radar;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.concordia.flight.radar.dbUtils.DBConnection;
import com.concordia.flight.radar.fetchDataApi.LoadCountriesDataIntoDb;

public class MainApplication {
	private static final Logger log = Logger.getLogger(MainApplication.class);
	
	public static void main(String[] args) {
		BasicConfigurator.configure();
		LoadCountriesDataIntoDb loadCountriesDataIntoDb = new LoadCountriesDataIntoDb();
		loadCountriesDataIntoDb.loadCountriesIntoDb();
		
		

	}

}
