package edu.mum.cs545.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

import cs545.airline.dao.AirlineDao;
import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;

@Path("/airline")
public class AirlineService {

	// These services should be evaluated to reconsider which methods should be
	// public

	private AirlineDao airlineDao;
	private ObjectMapper objectMapper = new ObjectMapper();

	public AirlineService(AirlineDao airlineDao) {
		this.airlineDao = airlineDao;
	}

	public AirlineService() {
		super();
		this.airlineDao = new AirlineDao();
		// TODO Auto-generated constructor stub
	}

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Flight create() {
		Airport mco = new Airport("MCO", "Orlando", "Florida", "USA");
		Airport mia = new Airport("MIA", "Miami", "Florida", "USA");
		Airplane airplane1 = new Airplane("56789", "A380", 519);
		Airline airline1 = new Airline("Delta");

		Flight flight1 = new Flight("DE 36", "08/06/2009", "7:10 pm", "06/25/2015", "9:00 am", airline1, mia, mco,
				airplane1);
		return flight1;
	}

	@GET
	@Path("/create")
	public void create(@QueryParam("name") String name) {
		Airline airline1 = new Airline(name);
		// public void create(@QueryParam("serialnr") String
		// serialnr,@QueryParam("model") String model,@QueryParam("capacity")
		// int capacity) {
		// Airplane airplane = new Airplane(serialnr, model, capacity);
		// public void create(Airline airport) {
		// public void create(@QueryParam("airportcode") String airportcode,
		// @QueryParam("name") String name,
		// @QueryParam("city") String city, @QueryParam("country") String
		// country) {
		// Airport airport = new Airport(airportcode, name, city, country);
		// try {
		// AccountBean acc = ObjectMapper.readValue(json, AccountBean.class);
		// System.out.println(acc.getName());
		// System.out.println(acc);
		// } catch (JsonParseException e) {
		// e.printStackTrace();
		// } catch (JsonMappingException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		System.out.println("---------------------------------------------" + name);
		airlineDao.create(airline1);
	}

	public void delete(Airline airport) {
		airlineDao.delete(airport);
	}

	public Airline update(Airline airport) {
		return airlineDao.update(airport);
	}

	public Airline find(Airline airport) {
		return airlineDao.findOne(airport.getId());
	}

	public Airline findByName(String name) {
		return airlineDao.findOneByName(name);
	}

	public List<Airline> findByFlight(Flight flight) {
		return airlineDao.findByFlight(flight.getId());
	}

	@GET
	@Path("/findall")
	public List<Airline> findAll() {
		return airlineDao.findAll();
	}
}
