package dtos;

public class WeatherDTO {
    private double temp;
    private double feelsLike;
    private double tempMin;
    private double tempMax;
    private int pressure;
    private int humidity;
    private int id;
    private String name;
    private double lon;
    private double lat;

    public WeatherDTO(WeatherRemoteDTO WRD) {
        this.id = WRD.id;
        this.temp = WRD.main.temp;
        this.feelsLike = WRD.main.feels_like;
        this.tempMin = WRD.main.temp_min;
        this.tempMax = WRD.main.temp_max;
        this.pressure = WRD.main.pressure;
        this.humidity = WRD.main.humidity;
        this.name = WRD.name;
        this.lon = WRD.coord.lon;
        this.lat = WRD.coord.lat;


    }

    public WeatherDTO(WeatherDTO weatherdto) {
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
