package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ChuckNorrisDto;
import dtos.JokeDTO;
import facades.ChuckNorrisFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("jokes")
public class ChuckNorrisResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final ChuckNorrisFacade FACADE = ChuckNorrisFacade.getChuckNorrisFacade(EMF);
    //comment to test for workflow on github
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getJoke() throws Exception {
        ChuckNorrisDto chuckNorrisDto  = FACADE.createChuckNorrisDto(FACADE.fetchData("https://api.chucknorris.io/jokes/random"));
        System.out.println(chuckNorrisDto);
        JokeDTO myJokeDTO = new JokeDTO(chuckNorrisDto);
        return Response.ok().entity(myJokeDTO).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    @RolesAllowed("user")
    public Response getFromUser() throws IOException {
        ChuckNorrisDto chuckNorrisDto  = FACADE.createChuckNorrisDto(FACADE.fetchData("https://api.chucknorris.io/jokes/random"));
        System.out.println(chuckNorrisDto);
        System.out.println("This is an endpoint only for users");
        JokeDTO myJokeDTO = new JokeDTO(chuckNorrisDto);
        return Response.ok().entity(myJokeDTO).build();
    }



}
