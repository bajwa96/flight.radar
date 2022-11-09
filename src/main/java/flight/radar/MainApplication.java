package flight.radar;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.concordia.flight.radar.apiProcessor.LoadCountriesProcessor;

public class MainApplication {
	private static final Logger log = Logger.getLogger(MainApplication.class);
	
	public static void main(String[] args) throws Exception {
		BasicConfigurator.configure();
		LoadCountriesProcessor loadCountriesDataIntoDb = new LoadCountriesProcessor();
		loadCountriesDataIntoDb.loadCountriesIntoDb();
		
		
	}

}
