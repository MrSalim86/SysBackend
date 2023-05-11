package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ChuckNorrisDto;
import dtos.JokeDTO;
import dtos.WeatherDTO;
import dtos.WeatherRemoteDTO;
import facades.ChuckNorrisFacade;
import facades.WatherFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("weather")
public class WeatherResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final WatherFacade FACADE = WatherFacade.getWatherFacade(EMF);
    //comment to test for workflow on github

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getWeather() throws Exception {
        WeatherRemoteDTO weatherremotedto = FACADE.createWeatherRemoteDTO(FACADE.fetchData("http://api.openweathermap.org/data/2.5/weather?q=Copenhagen,dk&APPID=8b0c35951da0067a47eea12e613ac76d"));
        System.out.println(weatherremotedto);
        WeatherDTO weather = new WeatherDTO(weatherremotedto);
        return Response.ok().entity(weather).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    @RolesAllowed("user")
    public Response getFromUser() throws IOException {
        WeatherRemoteDTO weatherremotedto = FACADE.createWeatherRemoteDTO(FACADE.fetchData("http://api.openweathermap.org/data/2.5/weather?q=Copenhagen,dk&APPID=8b0c35951da0067a47eea12e613ac76d"));
        System.out.println(weatherremotedto);
        System.out.println("This is an endpoint only for users");
        WeatherDTO weather = new WeatherDTO(weatherremotedto);
        return Response.ok().entity(weather).build();
    }



}

