package com.concordia.flight.radar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration  // Sprint Boot Auto Configuration
@ComponentScan(basePackages = "com.concordia.flight.radar")
public class MainApplication extends SpringBootServletInitializer {
//	private static final Logger log = Logger.getLogger(MainApplication.class);
	private static final Class<MainApplication> applicationClass = MainApplication.class;

	public static void main(String[] args) throws Exception {
//		BasicConfiguratora.configure();
//		LoadCountriesProcessor loadCountriesDataIntoDb = new LoadCountriesProcessor();
//		loadCountriesDataIntoDb.loadCountriesIntoDb();
//		LoadFlightInfoProcessor loadFlightInfoProcessor = new LoadFlightInfoProcessor();
//		loadFlightInfoProcessor.loadFlightInfoIntoDb();
//		SpringApplication.run(applicationClass);
//		ConfigurableApplicationContext c = SpringApplication.run(FlightService.class, args);
		System.out.println("Welcome to Spring Boot");
		SpringApplication sa = new SpringApplication(
				MainApplication.class);
		sa.run(args);
	}

	@Override
    protected SpringApplicationBuilder configure(
      SpringApplicationBuilder builder) {
        return builder.sources(MainApplication.class);
    }


}
