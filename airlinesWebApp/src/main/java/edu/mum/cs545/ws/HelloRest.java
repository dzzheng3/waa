package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cs545.airline.dao.AirlineDao;
import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;

@Path("/hello")
public class HelloRest {

	// Not the best way of doing it, but it works for this project
	private AirlineService airlineService = new AirlineService(new AirlineDao());

	@GET
	public String helloWorld(@DefaultValue("Gorgeous") @QueryParam("name") String name) {
		return "Hello " + name + "!";
	}

	@Path("airline")
	@GET
	public String getAirlineTest() {
		String result = "Nil!";
		List<Airline> airlines = airlineService.findAll();

		for (Airline airline : airlines) {
			result = "This is an airline: " + airline.getName();
		}
		return result;
	}

	
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Flight create() {
		Airport mco = new Airport("MCO", "Orlando", "Florida", "USA");
		Airport mia = new Airport("MIA", "Miami", "Florida", "USA");
		Airplane airplane1 = new Airplane("56789", "A380", 519);
		Airline airline1 = new Airline("Delta");

		Flight flight1 = new Flight("DE 36", "08/06/2009", "7:10 pm",
				"06/25/2015", "9:00 am", airline1, mia, mco, airplane1);
		return flight1;
	}
}
