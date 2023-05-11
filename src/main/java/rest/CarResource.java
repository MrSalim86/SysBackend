package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CarApiDTO;
import dtos.CarDTO;
import facades.CarFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("car")
public class CarResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final CarFacade FACADE = CarFacade.getCarFacade(EMF);
    private static final String API_URL = "https://vpic.nhtsa.dot.gov/api/vehicles/GetModelsForMake/mercedes?format=json";

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCarDTOFromApi() throws IOException {
        List<CarApiDTO> carDTOList = FACADE.getAllCarsFromApi();
        return Response.ok().entity(carDTOList).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    @RolesAllowed("user")
    public Response getFromUser() {
        System.out.println("This is an endpoint only for users");
        return Response.ok().build();
    }
}
