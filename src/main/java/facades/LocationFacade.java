package facades;

import com.google.gson.*;
import dtos.LocationApiDTO;
import dtos.LocationDTO;
import entities.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class LocationFacade {

    private static LocationFacade instance;

    private static EntityManagerFactory emf;

    private LocationFacade() {
    }

    public static LocationFacade getLocationFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new LocationFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();

    }

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public String fetchData(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json"); // Add this line
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
            return stringBuilder.toString();
        }
    }

    public LocationDTO createLocationDTO(String apiUrl) throws IOException {
        String json = fetchData(apiUrl);
        return GSON.fromJson(json, LocationDTO.class);
    }

    public List<Location> getAllLocation() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Location> query = em.createQuery("SELECT a FROM Location a", Location.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Location createLocation(String ipaddress, String country) {
        EntityManager em = emf.createEntityManager();
        Location location = new Location(ipaddress, country);
        try {
            em.getTransaction().begin();
            em.persist(location);
            em.getTransaction().commit();
            return location;
        } finally {
            em.close();
        }
    }

    public Location getLocationById(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Location.class, id);
        } finally {
            em.close();
        }
    }

    public Location updateLocation(Location location) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Location updatedLocation = em.merge(location);
            em.getTransaction().commit();
            return updatedLocation;
        } finally {
            em.close();
        }
    }

    public Location deleteLocation(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Location location = em.find(Location.class, id);
            em.remove(location);
            em.getTransaction().commit();
            return location;
        } finally {
            em.close();
        }
    }

    public Location addLocation(Location location) throws IOException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(location);
            em.getTransaction().commit();
            return location;
        } finally {
            em.close();
        }
    }

    public LocationApiDTO getLocationFromApi() throws IOException {
        String apiUrl = "https://api.country.is/";
        String json = fetchData(apiUrl);
        JsonObject root = JsonParser.parseString(json).getAsJsonObject();
        JsonArray results = root.getAsJsonArray("Results");
        LocationApiDTO locationApiDTOs = new LocationApiDTO();
        return locationApiDTOs;
    }

    public static void main(String[] args) throws IOException {


            LocationFacade locationFacade = LocationFacade.getLocationFacade(emf);
            // get your location by IP
            LocationApiDTO location = locationFacade.getLocationFromApi();
            // print the location
            System.out.println(locationFacade.getLocationFromApi().toString());



/*      LocationFacade locationFacade = LocationFacade.getLocationFacade(emf);
        List<LocationApiDTO> list = locationFacade.getAllLocationFromApi();
        for(LocationApiDTO locationApiDTO : list) {
            System.out.println(locationApiDTO.toString());
        }*/

        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        //CarFacade carFacade = CarFacade.getCarFacade(emf);
        //carFacade.createCar("Mercedes", "C200", 2019, "Copenhagen", 200000, "user");
        //CarFacade facade = CarFacade.getCarFacade(emf);
//
        //// Test getAllCars
        //List<Car> cars = facade.getAllCars();
        //for (Car car : cars) {
        //    System.out.println(car.toString());
        //}
//
        //// Test createCarDTO
        //try {
        //    CarDTO carDTO = facade.createCarDTO("https://vpic.nhtsa.dot.gov/api/vehicles/GetModelsForMake/mercedes?format=json");
        //    System.out.println(carDTO.toString());
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
//
        //// Test getAllCarsFromApi
        //List<CarDTO> carDTOs = facade.getAllCarsFromApi();
        //for (CarDTO carDTO : carDTOs) {
        //    System.out.println(carDTO.toString());
        //}
//
        //emf.close();

    }
}


