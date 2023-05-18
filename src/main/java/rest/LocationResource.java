package rest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.*;
import facades.LocationFacade;

import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("location")
public class LocationResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private static final LocationFacade FACADE = LocationFacade.getLocationFacade(EMF);

    private static final String API_URL = "https://api.country.is/";

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getLocationFromApi() throws Exception {
        LocationDTO locationDTO = FACADE.createLocationDTO(FACADE.fetchData("https://api.country.is/"));
        System.out.println(locationDTO);
        return Response.ok().entity(locationDTO).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    @RolesAllowed("user")
    public Response getFromUser() throws IOException {
        System.out.println("This is an endpoint only for users");
        return Response.ok().build();
    }
}