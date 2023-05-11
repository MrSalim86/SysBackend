package facades;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import dtos.CarApiDTO;
import dtos.CarDTO;
import entities.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CarFacade {

    private static CarFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private CarFacade() {
    }

    public static CarFacade getCarFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CarFacade();
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

    public CarDTO createCarDTO(String apiUrl) throws IOException {
        String json = fetchData(apiUrl);
        return GSON.fromJson(json, CarDTO.class);
    }

    public List<Car> getAllCars() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Car> query = em.createQuery("SELECT c FROM Car c", Car.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Car createCar(String make, String model, double year, String location, double price, String username  ) {
        EntityManager em = emf.createEntityManager();
        Car car = new Car(make, model, year, location, price, username);
        try {
            em.getTransaction().begin();
            em.persist(car);
            em.getTransaction().commit();
            return car;
        } finally {
            em.close();
        }
    }

    public Car getCarById(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Car.class, id);
        } finally {
            em.close();
        }
    }

    public Car updateCar(Car car) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Car updatedCar = em.merge(car);
            em.getTransaction().commit();
            return updatedCar;
        } finally {
            em.close();
        }
    }

    public Car deleteCar(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Car car = em.find(Car.class, id);
            em.remove(car);
            em.getTransaction().commit();
            return car;
        } finally {
            em.close();
        }
    }

    public Car addCar(Car car) throws IOException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(car);
            em.getTransaction().commit();
            return car;
        } finally {
            em.close();
        }

    }

    public List<CarApiDTO> getAllCarsFromApi() throws IOException {
        String apiUrl = "https://vpic.nhtsa.dot.gov/api/vehicles/GetModelsForMake/mercedes?format=json";
        String json = fetchData(apiUrl);
        JsonObject root = JsonParser.parseString(json).getAsJsonObject();
        JsonArray results = root.getAsJsonArray("Results");
        List<CarApiDTO> carDTOs = new ArrayList<>();
        for(JsonElement result : results) {
            CarApiDTO carDTO = GSON.fromJson(result, CarApiDTO.class);
            carDTOs.add(carDTO);
        }
        //Type carDTOListType = new TypeToken<ArrayList<CarDTO>>() {}.getType();
        //return GSON.fromJson(results, carDTOListType);
        return carDTOs;
    }

    public static void main(String[] args) throws IOException {

        CarFacade carFacade = CarFacade.getCarFacade(emf);
        List<CarApiDTO> list = carFacade.getAllCarsFromApi();
        for(CarApiDTO carApiDTO : list) {
            System.out.println(carApiDTO.toString());
        }
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

