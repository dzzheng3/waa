package edu.mum.cs545.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import cs545.airline.dao.FlightDao;
import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.nonmanaged.JpaUtil;
import cs545.airline.service.FlightService;
@Path("/app")
public class App {
	private static Logger logger = Logger.getLogger(App.class);
	private FlightService flightService;

	public static void main(String[] args) {		
		App app = new App();
		app.run();
		
		// This is needed because not its not closing Hibernate's connection 
		// - use beans instead of instantiating the JPA directly
		JpaUtil.destroyJpaUtil();
		
	}

	// Init Services
	public App() {
		// Services should be injected -DI
		// all of these objects are singleton and application scoped
		flightService = new FlightService(new FlightDao());
	}

//	public void run() {
//
//		// fill the database
//		fillDataBase();
//
//		// Flights leaving USA capacity > 500
//
//		logger.trace("List all the flights:");
//		List<Flight> flights = flightService.findAll();
//		logger.trace(String.format("%-9s%-31s%-31s", "Flight:", "Departs:", "Arrives:"));
//		for (Flight flight : flights) {
//			logger.trace(String.format("%-7s  %-12s %7s %8s  %-12s %7s %8s", flight.getFlightnr(),
//					flight.getOrigin().getCity(), flight.getDepartureDate(), flight.getDepartureTime(),
//					flight.getDestination().getCity(), flight.getArrivalDate(), flight.getArrivalTime()));
//		}
//	}
	@Path("getflights")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> run() {

		// fill the database
		fillDataBase();

		// Flights leaving USA capacity > 500

		logger.trace("List all the flights:");
		List<Flight> flights = flightService.findAll();
		logger.trace(String.format("%-9s%-31s%-31s", "Flight:", "Departs:", "Arrives:"));
		for (Flight flight : flights) {
			logger.trace(String.format("%-7s  %-12s %7s %8s  %-12s %7s %8s", flight.getFlightnr(),
					flight.getOrigin().getCity(), flight.getDepartureDate(), flight.getDepartureTime(),
					flight.getDestination().getCity(), flight.getArrivalDate(), flight.getArrivalTime()));
		}
		return flights;
	}

	public void fillDataBase() {
		
		// There is a IMPORT.SQL script in resources that is executed before this code to fill up the database

		Airport mco = new Airport("MCO", "Orlando", "Florida", "USA");
		Airport mia = new Airport("MIA", "Miami", "Florida", "USA");

		Airplane airplane1 = new Airplane("56789", "A380", 519);

		Airline airline1 = new Airline("Delta");

		Flight flight1 = new Flight("DE 36", "08/06/2009", "7:10 pm",
				"06/25/2015", "9:00 am", airline1, mia, mco, airplane1);
		
		flightService.create(flight1);
	}
}
